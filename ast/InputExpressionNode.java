import java.util.*;

/**
 * This class represents an input expression in the AST.
 *
 * @author Peter Ohmann
 */
public class InputExpressionNode extends ExpressionNode {
    private ExpressionNode prompt;

    public InputExpressionNode(ExpressionNode prompt) {
        super();
        this.prompt = prompt;
        this.children.add(prompt);
    }

    @Override
    public String toString() {
        return "Input expression";
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
