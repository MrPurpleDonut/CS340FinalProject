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
}
