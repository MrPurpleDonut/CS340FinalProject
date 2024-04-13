import java_cup.runtime.*;
import java.util.*;

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
