// Generated from Bazaco.g4 by ANTLR 4.8
package es.uva.inf.grammar.bazaco;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BazacoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BazacoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BazacoParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(BazacoParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(BazacoParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#symbolWithDoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolWithDoc(BazacoParser.SymbolWithDocContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#symbolWithDocDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolWithDocDefinition(BazacoParser.SymbolWithDocDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#subscriptRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptRange(BazacoParser.SubscriptRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#subscriptSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptSequence(BazacoParser.SubscriptSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#subscriptMappingList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptMappingList(BazacoParser.SubscriptMappingListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#subscriptMapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptMapping(BazacoParser.SubscriptMappingContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(BazacoParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhs(BazacoParser.LhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#subscriptCopy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptCopy(BazacoParser.SubscriptCopyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#unchangeableConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnchangeableConstant(BazacoParser.UnchangeableConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#dataEquation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataEquation(BazacoParser.DataEquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#lookupDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupDefinition(BazacoParser.LookupDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(BazacoParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#realityCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealityCheck(BazacoParser.RealityCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#stringAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAssign(BazacoParser.StringAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#macroDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroDefinition(BazacoParser.MacroDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code const}
	 * labeled alternative in {@link BazacoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst(BazacoParser.ConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Keyword}
	 * labeled alternative in {@link BazacoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(BazacoParser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOperation}
	 * labeled alternative in {@link BazacoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOperation(BazacoParser.ExprOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code signExpr}
	 * labeled alternative in {@link BazacoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignExpr(BazacoParser.SignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WildCard}
	 * labeled alternative in {@link BazacoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildCard(BazacoParser.WildCardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LookupArg}
	 * labeled alternative in {@link BazacoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupArg(BazacoParser.LookupArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link BazacoParser#exprAllowSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(BazacoParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DelayPArg}
	 * labeled alternative in {@link BazacoParser#exprAllowSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelayPArg(BazacoParser.DelayPArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link BazacoParser#exprAllowSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(BazacoParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tabbedArray}
	 * labeled alternative in {@link BazacoParser#exprAllowSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTabbedArray(BazacoParser.TabbedArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link BazacoParser#exprAllowSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(BazacoParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(BazacoParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#macroHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroHeader(BazacoParser.MacroHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#macroArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroArguments(BazacoParser.MacroArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(BazacoParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#subscriptValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptValueList(BazacoParser.SubscriptValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#indexList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexList(BazacoParser.IndexListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#subscript}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscript(BazacoParser.SubscriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#lookup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookup(BazacoParser.LookupContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#lookupRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupRange(BazacoParser.LookupRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#lookupPointList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupPointList(BazacoParser.LookupPointListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#referenceLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceLine(BazacoParser.ReferenceLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#lookupPoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupPoint(BazacoParser.LookupPointContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#constantLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantLine(BazacoParser.ConstantLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#constList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstList(BazacoParser.ConstListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#numberList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberList(BazacoParser.NumberListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#sketchInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSketchInfo(BazacoParser.SketchInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#versionCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionCode(BazacoParser.VersionCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#viewNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewNumber(BazacoParser.ViewNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#viewSettings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewSettings(BazacoParser.ViewSettingsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#objectList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectList(BazacoParser.ObjectListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#objectParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectParam(BazacoParser.ObjectParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#points}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoints(BazacoParser.PointsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#viewX}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewX(BazacoParser.ViewXContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#viewInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewInfo(BazacoParser.ViewInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#sketches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSketches(BazacoParser.SketchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#graphs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphs(BazacoParser.GraphsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#metadata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetadata(BazacoParser.MetadataContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#subscriptId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptId(BazacoParser.SubscriptIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#constVensim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstVensim(BazacoParser.ConstVensimContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#integerConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerConst(BazacoParser.IntegerConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#floatingConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingConst(BazacoParser.FloatingConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link BazacoParser#unitsDoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitsDoc(BazacoParser.UnitsDocContext ctx);
}