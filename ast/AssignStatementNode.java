import java_cup.runtime.*;

/**
 * This class represents an assignment statement in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class AssignStatementNode extends StatementNode {
    private String id;

    public AssignStatementNode(String id, ExpressionNode e) {
        super();
        this.id = id;
        this.children.add(e);
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Assignment statement: " + this.id;
    }
}
