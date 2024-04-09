/**
 * This class represents a print statement in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class PrintStatementNode extends StatementNode {
    public PrintStatementNode(ExpressionNode e) {
        super();
        this.children.add(e);
    }

    @Override
    public String toString() {
        return "Print Statement";
    }
}
