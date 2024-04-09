/**
 * This class represents an error statement block in the AST.
 *
 * @author Peter Ohmann
 */
public class ErrorStatementNode extends StatementNode {
    public ErrorStatementNode(StatementListNode l) {
        super();
        this.children.add(l);
    }

    @Override
    public String toString() {
        return "Error Statement";
    }
}
