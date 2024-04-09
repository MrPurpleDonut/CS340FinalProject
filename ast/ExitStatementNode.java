/**
 * This class represents an exit statement in the AST.
 *
 * @author Peter Ohmann
 */
public class ExitStatementNode extends StatementNode {
    public ExitStatementNode(ExpressionNode e) {
        super();
        this.children.add(e);
    }

    @Override
    public String toString() {
        return "Exit Statement";
    }
}
