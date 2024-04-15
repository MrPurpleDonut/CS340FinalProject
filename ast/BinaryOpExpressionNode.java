/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class BinaryOpExpressionNode extends ExpressionNode {
    private ExpressionNode left;
    private ExpressionNode right;
    private String operator;

    /**
     * Represent an infix binary operator; that is "left op right".
     */
    public BinaryOpExpressionNode(ExpressionNode left,
                                  ExpressionNode right, String op) {
        super();
        this.left = left;
        this.right = right;
        this.operator = op;
        this.children.add(left);
        this.children.add(right);
    }

    @Override
    public String toString() {
        return "Binary operator '" + this.operator + "'";
    }
    /**
     *This method evaluates this node and returns the expression after evaluating
     *@return ExpressionNode with the simplified expression
     *@throws UnsupportedOperationException
     */
    @Override
    public ExpressionNode evaluate(){
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
