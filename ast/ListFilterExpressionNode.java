/**
 * This class represents a list filter operation (expression[? expression ?])
 * in the AST.
 *
 * @author Peter Ohmann
 */
public class ListFilterExpressionNode extends ExpressionNode {
    private ExpressionNode array;
    private ExpressionNode position;

    public ListFilterExpressionNode(ExpressionNode array, ExpressionNode pos) {
        super();
        this.array = array;
        this.position = pos;
        this.children.add(array);
        this.children.add(pos);
    }

    @Override
    public String toString() {
        return "List Filter";
    }
}
