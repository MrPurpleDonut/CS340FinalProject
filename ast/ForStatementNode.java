
import java.util.*;

/**
 * This class represents a for-each statement in the AST.
 *
 * @author Peter Ohmann
 */
public class ForStatementNode extends StatementNode {
    private TypeNode loopVarType;
    private String loopVar;
    private ExpressionNode collection;
    private StatementListNode body;

    public ForStatementNode(TypeNode loopVarType, String loopVarName,
                            ExpressionNode collection,
                            StatementListNode body) {
        super();
        this.loopVarType = loopVarType;
        this.loopVar = loopVarName;
        this.collection = collection;
        this.body = body;
        this.children.add(loopVarType);
        this.children.add(collection);
        this.children.add(body);
    }

    @Override
    public String toString() {
        return "For Statement: " + this.loopVar;
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
