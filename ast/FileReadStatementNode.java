import java_cup.runtime.*;
import java.util.*;

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
    
    /**
     *This method impliments the run method all statements need to
     *@param symbolTableList list with the symbol tables in order from least
     *to most specific
     *@param functionTable map with the functions
     *@throws UnsupportedOperationException not yet implemented
     */
    @Override
    public void run(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        //TODO: Implement run
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
