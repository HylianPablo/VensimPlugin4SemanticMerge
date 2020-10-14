package es.uva.inf.grammar.parser.visitors;

import es.uva.inf.grammar.parser.*;

//import es.uva.inf.grammar.utilities.logs.VensimLogger;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RawSymbolTableVisitor extends GrammarBaseVisitor<Object> {

    private SymbolTable table;
    //protected static VensimLogger LOG = VensimLogger.getInstance();
    private static Pattern sequencePattern = Pattern.compile("(.*?)(\\d+)");

    public SymbolTable getSymbolTable(GrammarParser.FileContext context){
        table = new SymbolTable();
        visit(context);

        return table;
    }


    private int getStartLine(ParserRuleContext context){
        return context.start.getLine();
    }

    private Symbol getSymbolOrCreate(SymbolTable table,String token){
        if(table.hasSymbol(token))
            return table.getSymbol(token);

        else{
            return table.addSymbol(new Symbol(token));
        }
    }

    @Override
    public Symbol visitSubscriptRange(GrammarParser.SubscriptRangeContext ctx) {
        Symbol subscript = getSymbolOrCreate(table,ctx.Id().getSymbol().getText());
        subscript.addDefinitionLine(getStartLine(ctx));
        subscript.setType(SymbolType.Subscript);


        if(ctx.subscriptValueList()!=null) {
            List<Symbol> values = visitSubscriptValueList(ctx.subscriptValueList());
            subscript.addDependencies(values);
        }

        if(ctx.subscriptSequence()!=null)
            subscript.addDependencies(visitSubscriptSequence(ctx.subscriptSequence()));


        if(ctx.call()!=null)
            subscript.addDependencies(visitCall(ctx.call()));

        return subscript;
    }


    @Override
    public Symbol visitEquation(GrammarParser.EquationContext ctx) {
        Symbol symbol = visitLhs(ctx.lhs());
        symbol.addDefinitionLine(getStartLine(ctx));


        if(ctx.expr()!=null)
            symbol.addDependencies( (List<Symbol>) visit(ctx.expr()));

        return symbol;
    }


    @Override
    public Symbol visitConstraint(GrammarParser.ConstraintContext ctx) {
        Symbol symbol = visitLhs(ctx.lhs());
        symbol.setType(SymbolType.Reality_Check);
        symbol.addDefinitionLine(getStartLine(ctx));

        return symbol;
    }

    @Override
    public Object visitMacroDefinition(GrammarParser.MacroDefinitionContext ctx) {
        Symbol symbol = getSymbolOrCreate(table,ctx.macroHeader().Id().getSymbol().getText());
        symbol.setType(SymbolType.Function);
        symbol.addDefinitionLine(getStartLine(ctx));

        return super.visitMacroDefinition(ctx);
    }

    @Override
    public Symbol visitUnchangeableConstant(GrammarParser.UnchangeableConstantContext ctx) {
        Symbol symbol = visitLhs(ctx.lhs());
        symbol.setType(SymbolType.Constant);
        symbol.addDefinitionLine(getStartLine(ctx));
        return symbol;
    }

    @Override
    public Symbol visitDataEquation(GrammarParser.DataEquationContext ctx) {
        Symbol symbol = visitLhs(ctx.lhs());
        symbol.addDefinitionLine(getStartLine(ctx));

        if(ctx.expr()!=null)
            symbol.addDependencies( (List<Symbol>) visit(ctx.expr()));

        return symbol;
    }

    @Override
    public Symbol visitLookupDefinition(GrammarParser.LookupDefinitionContext ctx) {
        Symbol symbol = visitLhs(ctx.lhs());
        symbol.addDefinitionLine(getStartLine(ctx));
        symbol.setType(SymbolType.Lookup_Table);

        if (ctx.lookup()!=null)
            symbol.addDependencies(  visitLookup(ctx.lookup()));
        else if (ctx.call()!=null)
            symbol.addDependencies(visitCall(ctx.call()));


        return symbol;
    }

    @Override
    public Symbol visitStringAssign(GrammarParser.StringAssignContext ctx) {
        Symbol symbol = visitLhs(ctx.lhs());
        symbol.setType(SymbolType.Constant);
        symbol.addDefinitionLine(getStartLine(ctx));

        return symbol;
    }


    @Override
    public Symbol visitSubscriptCopy(GrammarParser.SubscriptCopyContext ctx) {

        Symbol copy = getSymbolOrCreate(table,ctx.copy.getText());
        copy.setType(SymbolType.Subscript);
        copy.addDefinitionLine(getStartLine(ctx));

        Symbol original = getSymbolOrCreate(table, ctx.original.getText());
        copy.setDependencies(original.getDependencies()); // Must be setDependencies instead of addDependencies so it works even if 'original' hasn't been defined yet.

        return copy;
    }

    @Override
    public Symbol visitRealityCheck(GrammarParser.RealityCheckContext ctx) {
        Symbol symbol = visitLhs(ctx.lhs());
        symbol.setType(SymbolType.Reality_Check);
        symbol.addDefinitionLine(getStartLine(ctx));

        return symbol;

    }



    @Override
    public Symbol visitSubscriptId(GrammarParser.SubscriptIdContext ctx) {
        return getSymbolOrCreate(table,ctx.Id().getSymbol().getText());
    }

    @Override
    public List<Symbol> visitSubscriptSequence(GrammarParser.SubscriptSequenceContext ctx) {


        try{
            return parseSubscriptSequence(ctx);
        }catch (IllegalArgumentException ex){
            //LOG.info(ex.getMessage() + "\nThe in-between values of the range will be ignored.");
            Symbol firstSymbol = getSymbolOrCreate(table,ctx.Id(0).getSymbol().getText());
            Symbol secondSymbol = getSymbolOrCreate(table,ctx.Id(1).getSymbol().getText());

            firstSymbol.setType(SymbolType.Subscript_Value);
            firstSymbol.addDefinitionLine(getStartLine(ctx));
            secondSymbol.setType(SymbolType.Subscript_Value);
            secondSymbol.addDefinitionLine(getStartLine(ctx));

            return Arrays.asList(firstSymbol,secondSymbol);
        }


    }

    private List<Symbol> parseSubscriptSequence(GrammarParser.SubscriptSequenceContext ctx) {
        Matcher startMatcher = sequencePattern.matcher(ctx.start.getText().trim());
        Matcher endMatcher = sequencePattern.matcher(ctx.end.getText().trim());

        if (startMatcher.matches() && endMatcher.matches()) {


            List<Symbol> symbolSequence = new ArrayList<>();
            String startText = startMatcher.group(1).trim();
            String endText = endMatcher.group(1).trim();

            if (!startText.equals(endText)) {
                throw new IllegalArgumentException("The subscript sequence: '" + ctx.getText() + "doesn't match. The text '" + startText + "' and '" + endText + "' should be the same.");
            }

            int startNumber = Integer.parseInt(startMatcher.group(2));
            int endNumber = Integer.parseInt(endMatcher.group(2));

            if (startNumber>=endNumber) {
                throw new IllegalArgumentException("The end number of a sequence must be greater than the start number.  Found: '" + ctx.getText() + "'.");
            }

            String text = ctx.start.getText().trim();
            for (int i = startNumber; i < endNumber + 1; i++) {
                Symbol value = getSymbolOrCreate(table,text.replace(startMatcher.group(2),String.valueOf(i)));
                value.setType(SymbolType.Subscript_Value);
                value.addDefinitionLine(getStartLine(ctx));
                symbolSequence.add(value);
            }

            return symbolSequence;
        }else{
            throw new IllegalArgumentException("The subscript sequence " + ctx.getText() + " is invalid.");
        }


    }


    @Override
    public Object visitExprOperation(GrammarParser.ExprOperationContext ctx) {
        List<Symbol> symbols = (List<Symbol>) visit(ctx.expr(0));
        symbols.addAll((List<Symbol>) visit(ctx.expr(1)));

        return  symbols;
    }



    @Override
    public Object visitVar(GrammarParser.VarContext ctx) {
        Symbol id = getSymbolOrCreate(table,ctx.Id().getSymbol().getText());

        List<Symbol> symbols = new ArrayList<>();
        symbols.add(id);

        return symbols;
    }

    @Override
    public Object visitConst(GrammarParser.ConstContext ctx) {
        return new ArrayList<Symbol>();
    }

    @Override
    public List<Symbol> visitKeyword(GrammarParser.KeywordContext ctx) {
        if (ctx.expr()!=null)
            return (List<Symbol>) visit(ctx.expr());
        else
            return new ArrayList<>();
    }


    @Override
    public Object visitParens(GrammarParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Object visitWildCard(GrammarParser.WildCardContext ctx) {
        return new ArrayList<Symbol>();
    }


    @Override
    public Object visitDelayPArg(GrammarParser.DelayPArgContext ctx) {
        List<Symbol> symbols = new ArrayList<>();
        Symbol delayP = getSymbolOrCreate(table,"DELAYP");
        List<Symbol> input = (List<Symbol>) visit(ctx.expr(0));
        List<Symbol> delayTime = (List<Symbol>) visit(ctx.expr(1));
        Symbol pipeline = getSymbolOrCreate(table,ctx.Id().getSymbol().getText());
        pipeline.setType(SymbolType.Variable);
        pipeline.addDefinitionLine(ctx.Id().getSymbol().getLine());


        symbols.add(delayP);
        symbols.addAll(input);
        symbols.addAll(delayTime);

        pipeline.addDependencies(symbols);

        symbols.add(pipeline);
        return  symbols;
    }

    @Override
    public Object visitTabbedArray(GrammarParser.TabbedArrayContext ctx) {
        List<Symbol> symbols = new ArrayList<>();
        Symbol tabbedFunc = getSymbolOrCreate(table,"TABBED ARRAY");

        symbols.add(tabbedFunc);
        return symbols;
    }

    @Override
    public Object visitSignExpr(GrammarParser.SignExprContext ctx) {
        return visit(ctx.exprAllowSign());

    }


    @Override
    public List<Symbol> visitCall(GrammarParser.CallContext ctx) {
        String token = ctx.Id().getSymbol().getText();
        Symbol call;

        if (table.hasSymbol(token))
            call = table.getSymbol(token);
        else{
            call = table.addSymbol(new Symbol(token));
            call.setType(SymbolType.UNDETERMINED_FUNCTION);
        }


        List<Symbol> symbols;
        if(ctx.exprList()!=null)
             symbols =  (List<Symbol>) visit(ctx.exprList());
        else
            symbols = new ArrayList<>();

        symbols.add(call);
        return symbols;
    }




    @Override
    public Object visitExprList(GrammarParser.ExprListContext ctx) {
        List<Symbol> symbols = new ArrayList<>();
        for(GrammarParser.ExprContext expr: ctx.expr()){
            symbols.addAll((List<Symbol>)visit(expr));
        }
        return symbols;
    }


    @Override
    public List<Symbol> visitIndexList(GrammarParser.IndexListContext ctx) {
        List<Symbol> symbols = new ArrayList<>();


        if(!ctx.subscriptId().isEmpty()){
            for(GrammarParser.SubscriptIdContext subscript: ctx.subscriptId()){
                symbols.add( visitSubscriptId(subscript));
            }
        }

        return symbols;
    }


    @Override
    public List<Symbol> visitSubscriptValueList(GrammarParser.SubscriptValueListContext ctx) {
        List<Symbol> symbols = new ArrayList<>();


        if(!ctx.subscriptId().isEmpty()){
            for(GrammarParser.SubscriptIdContext value: ctx.subscriptId()){
                Symbol valueSymbol = visitSubscriptId(value);
                valueSymbol.setType(SymbolType.Subscript_Value);
                valueSymbol.addDefinitionLine(getStartLine(value));

                symbols.add(valueSymbol);
            }
        }

        if(!ctx.subscriptSequence().isEmpty()){
            for(GrammarParser.SubscriptSequenceContext sequence: ctx.subscriptSequence()){
                symbols.addAll(visitSubscriptSequence(sequence));
            }
        }
        return symbols;
    }

    @Override
    public List<Symbol> visitLookup(GrammarParser.LookupContext ctx) {
        return new ArrayList<>();
    }


    @Override
    public List<Symbol> visitLookupPoint(GrammarParser.LookupPointContext ctx) {

        return  new ArrayList<>();
    }

    @Override
    public List<Symbol> visitConstList(GrammarParser.ConstListContext ctx) {
        return new ArrayList<>();
    }

    @Override
    public List<Symbol> visitLookupPointList(GrammarParser.LookupPointListContext ctx) {
        List<Symbol> symbols = new ArrayList<>();


        for(GrammarParser.LookupPointContext point:ctx.lookupPoint()){
            symbols.addAll(visitLookupPoint(point));
        }



        return symbols;
    }

    @Override
    public List<Symbol> visitLookupRange(GrammarParser.LookupRangeContext ctx) {
        List<Symbol> symbols = new ArrayList<>();

        symbols.addAll(visitLookupPoint(ctx.lookupPoint(0)));
        symbols.addAll(visitLookupPoint(ctx.lookupPoint(1)));

        if (ctx.referenceLine()!=null)
            symbols.addAll(visitReferenceLine(ctx.referenceLine()));

       return symbols;
    }


    @Override
    public List<Symbol> visitReferenceLine(GrammarParser.ReferenceLineContext ctx) {
        return visitLookupPointList(ctx.lookupPointList());
    }

    @Override
    public List<Symbol> visitNumberList(GrammarParser.NumberListContext ctx) {
        return new ArrayList<>();
    }


    @Override
    public Symbol visitSymbolWithDoc(GrammarParser.SymbolWithDocContext ctx) {
        Object symbolObj = visitSymbolWithDocDefinition(ctx.symbolWithDocDefinition());
        if(!(symbolObj instanceof Symbol))
            throw new IllegalStateException("The visitor returned an object that isn't of type Symbol. Actual object: "+ symbolObj);

        Symbol symbol = (Symbol) symbolObj;

        String comment = ctx.unitsDoc().comment.getText().substring(1);
        String units = ctx.unitsDoc().units.getText().substring(1);

        if(!comment.isBlank())
            symbol.setComment(comment);

        if(!units.isBlank())
            symbol.setUnits(units);


        return symbol;
    }

    @Override
    public Symbol visitLhs(GrammarParser.LhsContext ctx) {
       Symbol id =  getSymbolOrCreate(table,ctx.Id().getText());

       if(ctx.indexes!=null) {
           List<Symbol> indexes = visitSubscript(ctx.indexes);
           id.addIndexLine(indexes);
       }

        return id;
    }

    @Override
    public List<Symbol> visitSubscript(GrammarParser.SubscriptContext ctx) {
       return  visitIndexList(ctx.indexList());
    }




}