package es.uva.inf.grammar.parser.visitors;

import es.uva.inf.grammar.parser.*;
import es.uva.inf.grammar.utilities.Constants;

/**
 * From the outside you should only call 'callIsACompoundNumber'. The other methods can't be protected/private
 * due to inheritance.
 */
public class CompoundMagicNumberVisitor extends GrammarBaseVisitor {


    /**
     * Returns True if the call is a compound number
     *
     * To be considered a compound number, the call must meet the following conditions:
     *        - The function called must be included in Constants.FUNCTIONS_THAT_FORM_COMPOUND_MAGIC_NUMBERS
     *        - It doesn't contain identifiers (neither constants nor variables).
     *        - If there are nested calls, every function called must be included in Constants.FUNCTIONS_THAT_FORM_COMPOUND_MAGIC_NUMBERS
     *        - It doesn't contain wildcards
     */
    public boolean callIsACompoundNumber(GrammarParser.CallContext call){
        return visitCall(call);
    }


    @Override
    public Boolean visitExprList(GrammarParser.ExprListContext ctx) {
        for(GrammarParser.ExprContext expr: ctx.expr()){
            if(! (boolean) this.visit(expr))
                return false;
        }

        return true;
    }


    @Override
    public Boolean visitExprOperation(GrammarParser.ExprOperationContext ctx) {
        return (boolean) visit(ctx.expr(0)) && (boolean) visit(ctx.expr(1));
    }

    @Override
    public Object visitConstVensim(GrammarParser.ConstVensimContext ctx) {
        return ctx.StringConst()==null;
    }

    @Override
    public Object visitKeyword(GrammarParser.KeywordContext ctx) {
        if(ctx.expr()==null)
            return true;

        return visit(ctx.expr());
    }

    @Override
    public Object visitLookup(GrammarParser.LookupContext ctx) {
        return false;
    }



    @Override
    public Boolean visitCall(GrammarParser.CallContext ctx) {
        String funcName = ctx.Id().getText();
        return Constants.FUNCTIONS_THAT_FORM_COMPOUND_MAGIC_NUMBERS.contains(funcName) && visitExprList(ctx.exprList());
    }



    @Override
    public Boolean visitWildCard(GrammarParser.WildCardContext ctx) {
        return false;
    }

    @Override
    public Object visitSignExpr(GrammarParser.SignExprContext ctx) {
        if(ctx.exprAllowSign() instanceof GrammarParser.ParensContext) {
            GrammarParser.ParensContext parenth = (GrammarParser.ParensContext) ctx.exprAllowSign();
            return visit(parenth.expr());

        }else if(ctx.exprAllowSign() instanceof GrammarParser.CallExprContext)
            return visit(ctx.exprAllowSign());

        return false;
    }

}
