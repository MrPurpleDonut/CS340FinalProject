
import java.util.*;

/**
 * This class represents an until statement in the AST.
 *
 * @author Peter Ohmann
 */
public class UntilStatementNode extends StatementNode {
    private StatementNode checkStatement;
    private StatementListNode loopBody;

    public UntilStatementNode(StatementNode s, StatementListNode body) {
        super();
        this.checkStatement = s;
        this.loopBody = body;
        this.children.add(s);
        this.children.add(body);
    }

    @Override
    public String toString() {
        return "Until Statement";
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
