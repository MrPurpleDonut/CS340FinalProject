import java.util.*;

/**
 * This class represents an AST node that is a Statement that is itself
 * just an expression where we ignore the value.
 * (For example: a function call with a return value, or "x = 3")
 *
 * @author Peter Ohmann + <your name here>
 */
public class ExpressionStatementNode extends StatementNode {
    public ExpressionStatementNode(ExpressionNode e) {
        super();
        this.children.add(e);
    }

    @Override
    public String toString() {
        return "Statement as Expression";
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
