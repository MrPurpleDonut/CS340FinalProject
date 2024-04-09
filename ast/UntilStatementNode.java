/**
 * This class represents an until statement in the AST.
 *
 * @author Peter Ohmann
 */
public class UntilStatementNode extends StatementNode {
    private StatementNode checkStatement;
    private StatementListNode loopBody;

    public UntilStatementNode(StatementNode s, StatementListNode body) {
        super();
        this.checkStatement = s;
        this.loopBody = body;
        this.children.add(s);
        this.children.add(body);
    }

    @Override
    public String toString() {
        return "Until Statement";
    }
}
