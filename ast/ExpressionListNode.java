import java.util.*;

/**
 * This class represents an Expression List in the AST.
 *
 * @author Peter Ohmann
 */
public class ExpressionListNode extends ExpressionNode {
    /**
     * An empty expression list.
     */
    public ExpressionListNode() {
        super();
    }

    /**
     * An expression list with just a single element.
     */
    public ExpressionListNode(ExpressionNode e) {
        super();
        this.children.add(e);
    }

    public void addExpression(ExpressionNode e, int position) {
        this.children.add(position, e);
    }

    public void addExpression(StatementNode e) {
        this.children.add(e);
    }

    @Override
    public String toString() {
        return "Expression List";
    }
    /**
     *This method evaluates this node and returns the expression after evaluating
     *@return ExpressionNode with the simplified expression
     *@throws UnsupportedOperationException
     */
    @Override
    public ExpressionNode evaluate(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
