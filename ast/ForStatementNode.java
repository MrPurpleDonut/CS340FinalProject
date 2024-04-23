
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
    
    /**
     * Constructor for ForStatementNodes, note for loops can only be for each loops and only have 2 arguments to initalize
     * @param loopVarType The type of the newly created loop variable
     * @param loopVarName The String ID name of the newly created loop variable
     * @param collection The expression representing the collection to iterate through
     * @param body The statements composing the body of the loop 
     */
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
	Map<String, TypeExpressionPair> context = symbolTableList.get(0);	
	for (int i = symbolTableList.size() - 1; i >= 0; i--){
	    context = symbolTableList.get(i);
	    if (context.containsKey(this.loopVar)){ //Checks if the loop variable has been established in the current or any larger contexts
		throw new IllegalStateException("Cannot re-instantiate variable: " + this.loopVar);	
	    }
	}
	//What we want to do is run the statement list, each time giving it the next successive element in the collection... Not sure how to do that, I see Interpreter.runStatementList() being used
	//I'm not sure if I'm iterating through the colllection expressionNode properly
	
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
