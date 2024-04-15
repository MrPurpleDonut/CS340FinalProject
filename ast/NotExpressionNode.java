import java.util.*;

/**
 * This class represents a unary operation NOT in the AST.
 *
 * @author Peter Ohmann
 */
public class NotExpressionNode extends ExpressionNode {
    private ExpressionNode negatedValue;

    public NotExpressionNode(ExpressionNode negatedValue) {
        super();
        this.negatedValue = negatedValue;
        this.children.add(negatedValue);
    }

    @Override
    public String toString() {
        return "Not expression";
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
