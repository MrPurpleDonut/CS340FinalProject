
import java.util.*;

/**
 * This class represents an exit statement in the AST.
 *
 * @author Peter Ohmann
 */
public class ExitStatementNode extends StatementNode {
    public ExitStatementNode(ExpressionNode e) {
        super();
        this.children.add(e);
    }

    @Override
    public String toString() {
        return "Exit Statement";
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
