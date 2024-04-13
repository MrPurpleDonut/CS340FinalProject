
import java.util.*;

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
    
    /**
     *This method impliments the run method all statements need to
     *@param symbolTables list with the symbol tables in order from least
     *to most specific
     *@param functionTable map with the functions
     *@throws UnsupportedOperationException not yet implemented
     */
    @Override
    public void run(List<Map<String, TypeExpressionPair>> symbolTables,
            Map<String, FunctionNode> functionTable){
        //TODO: Implement run
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
