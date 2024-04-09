import java_cup.runtime.*;

/**
 * This class represents a quoted string (as an expression in the AST).
 *
 * @author Peter Ohmann
 */
public class StringExpressionNode extends ExpressionNode {
    private String value;

    public StringExpressionNode(String qstring) {
        super();
        this.value = qstring;
    }

    @Override
    public String toString() {
        return "Quoted string: " + this.value;
    }
}
