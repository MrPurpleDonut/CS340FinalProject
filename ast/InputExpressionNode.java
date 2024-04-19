import java.util.*;

/**
 * This class represents an input expression in the AST.
 *
 * @author Peter Ohmann
 */
public class InputExpressionNode extends ExpressionNode {
    private ExpressionNode prompt;
    private Scanner console;
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
     */
    @Override
    public ExpressionNode evaluate(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
	console = new Scanner(System.in);
	ExpressionNode p = prompt.evaluate(symbolTableList, functionTable);
	if (!(p instanceof StringExpressionNode)){
	    throw new IllegalArgumentException("Must give valid String prompt for input!");
	}
	System.out.println(p.getValue());
    ExpressionNode returnValue = new StringExpressionNode(console.next());
	return returnValue;
    }
}
