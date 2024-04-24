
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
	Map<String, TypeExpressionPair> context = symbolTableList.get(0);	
	for (int i = symbolTableList.size() - 1; i >= 0; i--){
	    context = symbolTableList.get(i);
	    if (context.containsKey(this.loopVar)){ //Checks if the loop variable has been established in the current or any larger contexts
		throw new IllegalStateException("Cannot re-instantiate variable: " + this.loopVar);	
	    }
	}

	context = symbolTableList.get(symbolTableList.size() - 1);
	if (!(context.get(this.collection).getType() instanceof ListTypeNode)){ //Checks that the collection's type is a ListType (which has a child node containing the element type). We do this first to make sure we don't get a NullPointer when we try to get the child in the next check
	    throw new IllegalArgumentException("Must give list variable in for loop");
	}

	TypeNode listType = context.get(collection).getType();
	if (listType.children.get(0) != this.loopVarType){ //Checks that the collection's element type is the same as the Loop Variable's Type
	    throw new IllegalArgumentException("List Type must match Loop Variable Type");   
	}
	ListExpressionNode listExpr = (ListExpressionNode) this.collection.evaluate(symbolTableList,functionTable); //I could put this in a try, and catch TypeCastExceptions, but we check above to make sure collection is a List already so I don't know if that would be redundant / necessary 
	for (int i = 0; i < listExpr.size(); i++){
	    //context.put(this.loopVar, listExpr.get(i)); Need to make the listExpression into a TypeExpressionPair to put it into the context
	    //We have a loop that will set the loopVar to successive entries in the List Expression in the current context
	    //TODO: Put context back into larger SymbolTableList then call Interpreter.runStatementList() with this.body for the statement list
	}
        throw new UnsupportedOperationException("Types are correct, for loop not yet implemented");
    }
}
