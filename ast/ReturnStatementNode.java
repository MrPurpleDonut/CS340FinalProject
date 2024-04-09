/**
 * This class represents a return statement in the AST.
 *
 * @author Peter Ohmann
 */
public class ReturnStatementNode extends StatementNode {
    public ReturnStatementNode(ExpressionNode e) {
        super();
        this.children.add(e);
    }

    @Override
    public String toString() {
        return "Return Statement";
    }
}
