
import java.util.*;

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
