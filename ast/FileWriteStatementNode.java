/**
 * This class represents a file write statement in the AST.
 *
 * @author Peter Ohmann
 */
public class FileWriteStatementNode extends StatementNode {
    private ExpressionNode contents;
    private ExpressionNode filePath;

    public FileWriteStatementNode(ExpressionNode c, ExpressionNode path) {
        super();
        this.contents = c;
        this.filePath = path;
        this.children.add(c);
        this.children.add(path);
    }

    @Override
    public String toString() {
        return "File Write Statement";
    }
}
