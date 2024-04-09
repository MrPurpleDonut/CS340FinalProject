/**
 * This class represents an AST node that is a Statement that is itself
 * just an expression where we ignore the value.
 * (For example: a function call with a return value, or "x = 3")
 *
 * @author Peter Ohmann + <your name here>
 */
public class ExpressionStatementNode extends StatementNode {
    public ExpressionStatementNode(ExpressionNode e) {
        super();
        this.children.add(e);
    }

    @Override
    public String toString() {
        return "Statement as Expression";
    }
}
