import java.util.*;

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
