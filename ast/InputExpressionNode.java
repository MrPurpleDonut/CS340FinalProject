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
}
