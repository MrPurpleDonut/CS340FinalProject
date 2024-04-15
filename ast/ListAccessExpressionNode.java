import java.util.*;

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
