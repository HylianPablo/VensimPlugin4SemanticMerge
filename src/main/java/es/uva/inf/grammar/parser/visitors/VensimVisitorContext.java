package es.uva.inf.grammar.parser.visitors;

import es.uva.inf.grammar.parser.*;

import java.util.ArrayList;
import java.util.List;

public class VensimVisitorContext {

    private GrammarParser.FileContext rootNode;
    //private List<Issue> issues;
    private SymbolTable parsedTable;
    private SymbolTable dbTable;

    public GrammarParser.FileContext getRootNode() {
        return rootNode;
    }

    /*
    public List<Issue> getIssues() {
        return issues;
    }
    */

    public VensimVisitorContext(GrammarParser.FileContext rootNode, SymbolTable parsedTable, SymbolTable dbTable){
        this.rootNode = rootNode;
        //issues = new ArrayList<>();
        this.parsedTable = parsedTable;
        this.dbTable = dbTable;
    }

    /*
    public void addIssue(Issue issue){
        issues.add(issue);
    }
    */


    public SymbolTable getParsedSymbolTable(){
        return parsedTable;
    }

    public SymbolTable getDbSymbolTable(){
        return dbTable;
    }
}
