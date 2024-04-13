
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
     *@param symbolTableList list with the symbol tables in order from least
     *to most specific
     *@param functionTable map with the functions
     *@throws UnsupportedOperationException not yet implemented
     */
    @Override
    public void run(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        //TODO: Implement run
        //TODO: Change toString method for some of the ExpressionNodes so
        //the method better represents the value so we can print easier
        //Call evaluate(...) on the node first, then print it out
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
