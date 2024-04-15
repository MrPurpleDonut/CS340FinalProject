import java_cup.runtime.*;

/**
 * This class represents an identifier (as an expression in the AST).
 *
 * @author Peter Ohmann + <your name here>
 */
public class IdExpressionNode extends ExpressionNode {
    private String value;

    public IdExpressionNode(String id) {
        super();
        this.value = id;
    }

    @Override
    public String toString() {
        return "Identifier: " + this.value;
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
