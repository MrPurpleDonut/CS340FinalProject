import java_cup.runtime.*;

/**
 * This class represents a file read statement in the AST.
 *
 * @author Peter Ohmann
 */
public class FileReadStatementNode extends AssignStatementNode {
    public FileReadStatementNode(String id, ExpressionNode e) {
        super(id, e);
    }

    @Override
    public String toString() {
        return "File Read into variable: " + this.getId();
    }
}
