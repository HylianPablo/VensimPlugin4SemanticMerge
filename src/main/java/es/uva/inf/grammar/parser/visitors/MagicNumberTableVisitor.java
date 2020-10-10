package es.uva.inf.grammar.parser.visitors;

import es.uva.inf.grammar.parser.*;


import static es.uva.inf.grammar.utilities.UtilityFunctions.stringToFloat;
import static es.uva.inf.grammar.utilities.UtilityFunctions.stringToInt;

public class MagicNumberTableVisitor  extends GrammarBaseVisitor<Void> {


    private SymbolTable numberTable;



    public MagicNumberTableVisitor(){
        numberTable = new SymbolTable();
    }




    public  SymbolTable getSymbolTable(GrammarParser.FileContext context){
        numberTable = new SymbolTable();
        visit(context);
        return numberTable;
    }


    private boolean exprIsAConstant(GrammarParser.ExprContext ctx){
        return  ctx.getClass() == GrammarParser.ConstContext.class;
    }

    private boolean exprIsACompoundNumber(GrammarParser.ExprContext ctx){
        if(ctx.getClass()!= GrammarParser.SignExprContext.class)
            return false;


        GrammarParser.SignExprContext node = (GrammarParser.SignExprContext) ctx;
        if( node.exprAllowSign().getClass() != GrammarParser.CallExprContext.class)
            return false;


       GrammarParser.CallExprContext callNode = (GrammarParser.CallExprContext) node.exprAllowSign();
        
       return isCompoundNumber(callNode.call());
    }

    private boolean exprIsANumber(GrammarParser.ExprContext ctx){
        return exprIsAConstant(ctx) || exprIsACompoundNumber(ctx);
    }

    private Symbol getSymbolOrCreate(SymbolTable table,String token){
        if(table.hasSymbol(token))
            return table.getSymbol(token);

        else{
            return table.addSymbol(new Symbol(token));
        }
    }
    @Override
    public Void visitEquation(GrammarParser.EquationContext ctx) {

        if(ctx.expr()==null || exprIsANumber(ctx.expr()))
            return null;


        return super.visit(ctx.expr());

    }

    @Override
    public Void visitDataEquation(GrammarParser.DataEquationContext ctx) {

        if(ctx.expr()==null || exprIsANumber(ctx.expr()))
            return null;

            return super.visit(ctx.expr());


    }

    @Override
    public Void visitUnchangeableConstant(GrammarParser.UnchangeableConstantContext ctx) {
        return null;
    }

    @Override
    public Void visitLookup(GrammarParser.LookupContext ctx) {
        return null;
    }





    @Override
    public Void visitIntegerConst(GrammarParser.IntegerConstContext ctx) {
        String value = String.valueOf(stringToInt(ctx.getText()));
        Symbol integer = getSymbolOrCreate(numberTable,value);
        integer.addDefinitionLine(ctx.start.getLine());
        return null;
    }


    @Override
    public Void visitFloatingConst(GrammarParser.FloatingConstContext ctx) {
        float value = stringToFloat(ctx.getText());
        String strValue;
        if(isInteger(value)){
            int intValue = (int) value;
            strValue = String.valueOf(intValue);
        }else{
            strValue = String.valueOf(value);
        }

        Symbol floatSymbol = getSymbolOrCreate(numberTable,strValue);
        floatSymbol.addDefinitionLine(ctx.start.getLine());
        return null;
    }

    private boolean isInteger(float value) {
        return (int) value == value;
    }

    @Override
    public Void visitTabbedArray(GrammarParser.TabbedArrayContext ctx) {
        return null;
    }


    private String getFunctionName(GrammarParser.CallContext ctx){
        return ctx.Id().getText();
    }


    private boolean isCompoundNumber(GrammarParser.CallContext ctx){
        CompoundMagicNumberVisitor visitor = new CompoundMagicNumberVisitor();
        return visitor.visitCall(ctx);


    }



    @Override
    public Void visitCall(GrammarParser.CallContext ctx) {
        String functionName = getFunctionName(ctx);

        if ("WITH LOOKUP".equals(functionName)) {
            return visit(ctx.exprList().expr(0));
        }


        if(isCompoundNumber(ctx)){
            Symbol integer = getSymbolOrCreate(numberTable,ctx.getText().trim());
            integer.addDefinitionLine(ctx.start.getLine());
            return null;
        }


        return super.visitCall(ctx);
    }

    @Override
    public Void visitRealityCheck(GrammarParser.RealityCheckContext ctx) {
        return null;
    }

    @Override
    public Void visitConstraint(GrammarParser.ConstraintContext ctx) {
        return null;
    }


    @Override
    public Void visitLookupDefinition(GrammarParser.LookupDefinitionContext ctx) {
        if(ctx.call()!=null)
            super.visitCall(ctx.call());
        return null;
    }

    @Override
    public Void visitConstList(GrammarParser.ConstListContext ctx) {
        return null;
    }


    private boolean isASwitch(String symbol){
        return symbol.matches("SWITCH_.+");
    }

    @Override
    public Void visitExprOperation(GrammarParser.ExprOperationContext ctx) {
        if(ctx.op.getType() == GrammarLexer.Equal)
            if(isASwitch(ctx.expr(0).getText()) || isASwitch(ctx.expr(1).getText()) )
              return null;

        return super.visitExprOperation(ctx);

    }
}
