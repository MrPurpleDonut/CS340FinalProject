
import java.util.*;

/**
 * This class represents a statement that is a declaration of a variable.
 *
 * @author Peter Ohmann + <your name here>
 */
public class DeclarationStatementNode extends StatementNode {
    private TypeNode varType;
    private String varName;

    /**
     * Just a plain declaration.
     * For example:  num myVal;
     */
    public DeclarationStatementNode(TypeNode type, String varName) {
        super();
        this.varType = type;
        this.varName = varName;
        this.children.add(type);
    }

    /**
     * A declaration that includes initialization.
     * For example:  num myVal = 3.5;
     * For example:  text data << "/a/file";
     */
    public DeclarationStatementNode(TypeNode type, String varName,
                                    AssignStatementNode assignment) {
        this(type, varName);
        this.children.add(assignment);
    }

    @Override
    public String toString() {
        return "Declaration statement: " + this.varName;
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