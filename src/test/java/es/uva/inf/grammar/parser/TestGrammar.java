package es.uva.inf.grammar.parser;


import static org.junit.Assert.*;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.Test;

import java.io.IOException;

import static es.uva.inf.grammar.testutilities.GeneralTestUtilities.*;

public class TestGrammar {

    @Test
    public void testFloatNotation(){
        String program = "const = -1e-3 ~~|";

        getParseTreeFromString(program);
    }


    @Test
    public void testNegativeFloatsAreDetected(){
        String program = "const = -0.3-4.1 ~~|";
        getParseTreeFromString(program);
    }

    @Test
    public void testNegativeIntegersAreDetected(){
        String program = "const = -5-4 ~~|" ;
        getParseTreeFromString(program);
    }

    @Test
    public void testParseTwoDimensionalArrays(){
        String program = "initial population equiv comma semicolon syntax[country row,blood type column]=\t\n" +
                "1,2,3,4;\n" +
                "5,6,7,8;\n" +
                "9,10,11,12;\n~~|";

        getParseTreeFromString(program);
    }

    @Test
    public void testWeirdChars(){
        String program = "URR tot agg oil Laherrère 2006= 10  ~~|";

        getParseTreeFromString(program);
    }


    @Test
    public void testReferenceLineInLookup(){
        String program = "myLookup(" + "[(0,0)-(10,10),(1.25382,3.55263),(3.85321,4.5614),(7.15596,7.67544),(8.74618,9.21053)]," +
                "(1.25382,3.55263),(3.42508,3.64035),(3.85321,4.5614),(4.8318,7.80702),(6.36086,4.91228 ),(7.15596,7.67544)," +
                "(7.18654,5.92105),(8.74618,9.21053))~~|";

        GrammarParser.FileContext tree = getParseTreeFromString(program);

        String reference_line = tree.model().symbolWithDoc(0).symbolWithDocDefinition().lookupDefinition().lookup().lookupRange().referenceLine().getText();

        assertEquals(",(1.25382,3.55263),(3.85321,4.5614),(7.15596,7.67544),(8.74618,9.21053)",reference_line);

    }


    @Test
    public void testNegativeIsReadCorrectly(){
        String program = "var = -foo - otherVar~~|";

        GrammarParser.FileContext tree = getParseTreeFromString(program);

        GrammarParser.ExprOperationContext parentExpr = (GrammarParser.ExprOperationContext) tree.model().symbolWithDoc(0).symbolWithDocDefinition().equation().expr();

        GrammarParser.SignExprContext firstChild = (GrammarParser.SignExprContext) parentExpr.getChild(0);
        assertEquals("-",firstChild.start.getText());

        TerminalNode secondChild = (TerminalNode) parentExpr.getChild(1);
        assertEquals("-",secondChild.getSymbol().getText());

        GrammarParser.ExprContext thirdChild = (GrammarParser.ExprContext) parentExpr.getChild(2);
        assertEquals("otherVar", thirdChild.getText());

    }

    @Test
    public void testNegativeWithParenthesis(){
        String program = "var = -(foo)~~|";

        getParseTreeFromString(program);
    }


    @Test
    public void testGrammarRecognizesWildCard(){
        String program = "testWildcard :THE CONDITION: FINAL TIME=101 :IMPLIES: \t* <  6:AND: * >=  1e+007  ~~|";

        getParseTreeFromString(program);
    }



    @Test
    public void testMedeas1() throws IOException {
       getSymbolTable("medeas1.mdl");
    }



    @Test
    public void testMedeas2() throws IOException{
        getSymbolTable("medeas2.mdl");

    }

    @Test
    public void testMedeasEU() throws IOException{
        getSymbolTable("medeasEU.mdl");
    }



    @Test
    public void testNewLineInsideSubscript(){
        String program = "\"materials per new capacity installed - wind offshore\"[\"Electric/electronic components\"\\ \n" +
                "]=5~~|";

        SymbolTable table = getRAWSymbolTableFromString(program);
        GrammarParser.FileContext file = getParseTreeFromString(program);

        assertEquals("\"Electric/electronic components\"",file.model().symbolWithDoc(0).symbolWithDocDefinition().equation().lhs().subscript(0).indexList().subscriptId(0).getText());
    }

    @Test
    public void testNumberInParenthesisIsNotConsideredLookup(){
        String program = "A = (3)~~|";

        GrammarParser.FileContext tree = getParseTreeFromString(program);

        GrammarParser.SignExprContext parenthesis = (GrammarParser.SignExprContext)  tree.model().symbolWithDoc(0).symbolWithDocDefinition().equation().expr();
        assertEquals(GrammarParser.ParensContext.class, parenthesis.exprAllowSign().getClass());

    }

    @Test
    public void testOnedimensionalArrayCanContainFinalSemicolon(){
        String program = "A = 3,4,5,6; ~~|";
        GrammarParser.FileContext tree= getParseTreeFromString(program);

        GrammarParser.ConstListContext array = tree.model().symbolWithDoc(0).symbolWithDocDefinition().equation().constList();
        assertNotNull(array);
        assertEquals("3,4,5,6;",array.getText());
    }

    @Test
    public void testOnedimensionalArraysDontRequireSemicolon(){
        String program = "A = 3,4,5,6 ~~|";
        GrammarParser.FileContext tree = getParseTreeFromString(program);

        GrammarParser.ConstListContext array = tree.model().symbolWithDoc(0).symbolWithDocDefinition().equation().constList();
        assertNotNull(array);
        assertEquals("3,4,5,6",array.getText());
    }


    @Test(expected = ParseCancellationException.class)
    public void testUnchangeableConstantsDontAllowOperations(){
        String program = "A == 3+3~~|";

        getParseTreeFromString(program);
    }

    @Test(expected = ParseCancellationException.class)
    public void  testUnchangeableConstantsDontAllowParenthesis(){
        String program = "A == (3)~~|";
        getParseTreeFromString(program);
    }

    @Test
    public void testUnchangeableConstantGetXLSConstant(){
        String program = "A ==\n" +
                "GET XLS CONSTANTS('inputs_W.xlsx', 'Climate', 'C98')~~|";

        getParseTreeFromString(program);
    }

    @Test
    public void testUnchangeableConstantAllowsLists(){
        String program = "A == 1,2,3,4~~|";
        getParseTreeFromString(program);
    }


    @Test
    public void testUnchangeableConstantAllowsBidimensionalLists(){
        String program = "A == 1,2,3,4; 5,6,7,8;~~|";
        getParseTreeFromString(program);
    }

    @Test
    public void testIntegerWithMultipleSigns(){
        String program = "A = -+---+-+----+-+--++-+---3~~|";
        getParseTreeFromString(program);
    }

    @Test
    public void testFloatWithMultipleSigns(){
        String program = "A = -+---+-+----+-+--++-+---3.0~~|";
        getParseTreeFromString(program);
    }

    @Test
    public void testCallWithMultipleSigns(){
        String program = "A = -++-++-+-+-+-++-+-+-+-SQRT(2)~~|";
        getParseTreeFromString(program);
    }

    @Test
    public void testIdentifierMultipleSigns(){
        String program = "A = -++-++-+-+-+-++-+-+-+-Time~~|";
        getParseTreeFromString(program);
    }

    @Test
    public void testParenthesisMultipleSigns(){
        String program = "A = -++-++-+-+-+-++-+-+-+-(10)~~|";
        getParseTreeFromString(program);
    }

    @Test
    public void testSuplementaryVariable(){
        String program = "A ~ units ~ comment ~ :SUPPLEMENTARY |";
        getParseTreeFromString(program);
    }

    @Test
    public void testVariableWithDoubleQuotesInComment(){
        String program = "A ~ units ~ \" |  ";
        getParseTreeFromString(program);
    }

    @Test
    public void testVariableWithDoubleQuotesInUnits(){
        String program = "A ~ \" ~ comment |  ";
        getParseTreeFromString(program);
    }
    

}