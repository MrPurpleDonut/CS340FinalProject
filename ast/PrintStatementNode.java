
import java.util.*;
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
