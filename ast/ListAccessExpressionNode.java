/**
 * This class represents a list access (expression[expression]) in the
 * AST.
 *
 * @author Peter Ohmann
 */
public class ListAccessExpressionNode extends ExpressionNode {
    private ExpressionNode array;
    private ExpressionNode position;

    public ListAccessExpressionNode(ExpressionNode array, ExpressionNode pos) {
        super();
        this.array = array;
        this.position = pos;
        this.children.add(array);
        this.children.add(pos);
    }

    @Override
    public String toString() {
        return "List Access";
    }
}
