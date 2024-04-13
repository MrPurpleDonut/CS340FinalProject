
import java.util.*;

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
