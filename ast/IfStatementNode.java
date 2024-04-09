/**
 * This class represents an if (or an if-else) statement in the AST.
 *
 * @author Peter Ohmann
 */
public class IfStatementNode extends StatementNode {
    private ExpressionNode condition;
    private StatementListNode ifBody;
    private StatementListNode elseBody;

    public IfStatementNode(ExpressionNode cond, StatementListNode ifBody) {
        super();
        this.condition = cond;
        this.ifBody = ifBody;
        this.elseBody = null;
        this.children.add(cond);
        this.children.add(ifBody);
    }

    public IfStatementNode(ExpressionNode cond, StatementListNode ifBody,
                           StatementListNode elseBody) {
        this(cond, ifBody);
        this.elseBody = elseBody;
        this.children.add(elseBody);
    }

    @Override
    public String toString() {
        return "If Statement";
    }
}
