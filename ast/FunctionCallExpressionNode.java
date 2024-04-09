/**
 * This class represents a function call in the AST.
 *
 * @author Peter Ohmann
 */
public class FunctionCallExpressionNode extends ExpressionNode {
    private String funcName;
    private ExpressionListNode params;

    public FunctionCallExpressionNode(String funcName,
                                      ExpressionListNode parameters) {
        super();
        this.funcName = funcName;
        this.params = parameters;
        this.children.add(parameters);
    }

    @Override
    public String toString() {
        return "Function call: " + this.funcName;
    }
}
