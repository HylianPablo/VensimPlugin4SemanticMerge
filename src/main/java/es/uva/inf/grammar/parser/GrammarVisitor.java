// Generated from Grammar.g4 by ANTLR 4.8
package es.uva.inf.grammar.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(GrammarParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(GrammarParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#sketchesGraphsAndMetadata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSketchesGraphsAndMetadata(GrammarParser.SketchesGraphsAndMetadataContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#symbolWithDoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolWithDoc(GrammarParser.SymbolWithDocContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#symbolWithDocDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolWithDocDefinition(GrammarParser.SymbolWithDocDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#subscriptRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptRange(GrammarParser.SubscriptRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#subscriptSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptSequence(GrammarParser.SubscriptSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#subscriptMappingList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptMappingList(GrammarParser.SubscriptMappingListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#subscriptMapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptMapping(GrammarParser.SubscriptMappingContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(GrammarParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhs(GrammarParser.LhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#subscriptCopy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptCopy(GrammarParser.SubscriptCopyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#unchangeableConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnchangeableConstant(GrammarParser.UnchangeableConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#dataEquation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataEquation(GrammarParser.DataEquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#lookupDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupDefinition(GrammarParser.LookupDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(GrammarParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#realityCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealityCheck(GrammarParser.RealityCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#stringAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAssign(GrammarParser.StringAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#macroDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroDefinition(GrammarParser.MacroDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code const}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst(GrammarParser.ConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Keyword}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(GrammarParser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOperation}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOperation(GrammarParser.ExprOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code signExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignExpr(GrammarParser.SignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WildCard}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildCard(GrammarParser.WildCardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LookupArg}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupArg(GrammarParser.LookupArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link GrammarParser#exprAllowSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(GrammarParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DelayPArg}
	 * labeled alternative in {@link GrammarParser#exprAllowSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelayPArg(GrammarParser.DelayPArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link GrammarParser#exprAllowSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(GrammarParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tabbedArray}
	 * labeled alternative in {@link GrammarParser#exprAllowSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTabbedArray(GrammarParser.TabbedArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link GrammarParser#exprAllowSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(GrammarParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(GrammarParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#macroHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroHeader(GrammarParser.MacroHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#macroArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacroArguments(GrammarParser.MacroArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(GrammarParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#subscriptValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptValueList(GrammarParser.SubscriptValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#indexList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexList(GrammarParser.IndexListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#subscript}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscript(GrammarParser.SubscriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#lookup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookup(GrammarParser.LookupContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#lookupRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupRange(GrammarParser.LookupRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#lookupPointList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupPointList(GrammarParser.LookupPointListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#referenceLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceLine(GrammarParser.ReferenceLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#lookupPoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLookupPoint(GrammarParser.LookupPointContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#constantLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantLine(GrammarParser.ConstantLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#constList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstList(GrammarParser.ConstListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#numberList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberList(GrammarParser.NumberListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#graphsGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphsGroup(GrammarParser.GraphsGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#graphs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphs(GrammarParser.GraphsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#graph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraph(GrammarParser.GraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(GrammarParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#xaxis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaxis(GrammarParser.XaxisContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#xlabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXlabel(GrammarParser.XlabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#xdiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXdiv(GrammarParser.XdivContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#yaxis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYaxis(GrammarParser.YaxisContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#ylabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYlabel(GrammarParser.YlabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#ydiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYdiv(GrammarParser.YdivContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#xmin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmin(GrammarParser.XminContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#xmax}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmax(GrammarParser.XmaxContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#nolegend}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNolegend(GrammarParser.NolegendContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#scale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScale(GrammarParser.ScaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#graphvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphvar(GrammarParser.GraphvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#gvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGvar(GrammarParser.GvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#ymin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYmin(GrammarParser.YminContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#ymax}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYmax(GrammarParser.YmaxContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#linewidthgraph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinewidthgraph(GrammarParser.LinewidthgraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#metadataDivisor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetadataDivisor(GrammarParser.MetadataDivisorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#metadataLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetadataLine(GrammarParser.MetadataLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#sketches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSketches(GrammarParser.SketchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#sketchesDelimiter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSketchesDelimiter(GrammarParser.SketchesDelimiterContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#viewInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewInfo(GrammarParser.ViewInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#sketchInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSketchInfo(GrammarParser.SketchInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#versionCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionCode(GrammarParser.VersionCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#viewName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewName(GrammarParser.ViewNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#viewSettings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewSettings(GrammarParser.ViewSettingsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#viewVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewVariables(GrammarParser.ViewVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#arrow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrow(GrammarParser.ArrowContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#arrowCoordinates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowCoordinates(GrammarParser.ArrowCoordinatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#viewVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewVariable(GrammarParser.ViewVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#visualInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisualInfo(GrammarParser.VisualInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#typography}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypography(GrammarParser.TypographyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#typographyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypographyName(GrammarParser.TypographyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#textFormat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextFormat(GrammarParser.TextFormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(GrammarParser.ColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#rgbColor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRgbColor(GrammarParser.RgbColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#singleColor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleColor(GrammarParser.SingleColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#subscriptId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptId(GrammarParser.SubscriptIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#constVensim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstVensim(GrammarParser.ConstVensimContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#integerConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerConst(GrammarParser.IntegerConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#floatingConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingConst(GrammarParser.FloatingConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#unitsDoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitsDoc(GrammarParser.UnitsDocContext ctx);
}