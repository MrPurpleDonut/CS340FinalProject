import java_cup.runtime.*;

/**
 * This class represents a boolean literal (either true or false).
 *
 * @author Peter Ohmann
 */
public class BooleanLiteralExpressionNode extends ExpressionNode {
    private boolean value;

    public BooleanLiteralExpressionNode(boolean val) {
        super();
        this.value = val;
    }

    public boolean getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Boolean literal: " + this.value;
    }
}
