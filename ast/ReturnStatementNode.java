
import java.util.*;

/**
 * This class represents a return statement in the AST.
 *
 * @author Peter Ohmann
 */
public class ReturnStatementNode extends StatementNode {
    private ExpressionNode returnExpressionNode;

    public ReturnStatementNode(ExpressionNode e) {
        super();
        this.children.add(e);
        this.returnExpressionNode = e;

    }

    public ExpressionNode getReturnExpressionNode() {
        return this.returnExpressionNode;
    }

    @Override
    public String toString() {
        return "Return Statement";
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
        //Check to see if size of symbolTableList is 1, if so end the program
        //else add value of e to previous symbolTable under "return", and
        //then remove the current symbol table from the list
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
