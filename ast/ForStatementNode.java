
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
    this.collection = this.collection.evaluate(symbolTableList, functionTable);    
	if (!(this.collection instanceof ListExpressionNode)){ //Checks that the collection's type is a ListType (which has a child node containing the element type). We do this first to make sure we don't get a NullPointer when we try to get the child in the next check
	    throw new IllegalArgumentException("Must give list variable in for loop");
	}
    //The for loop should have its own context
    context = new HashMap<String, TypeExpressionPair>();
    symbolTableList.add(context);
    context.put(this.loopVar, new TypeExpressionPair(this.loopVarType, null));


	ListExpressionNode listExpr = (ListExpressionNode) this.collection.evaluate(symbolTableList,functionTable); //I could put this in a try, and catch TypeCastExceptions, but we check above to make sure collection is a List already so I don't know if that would be redundant / necessary 
	for (int i = 0; i < listExpr.size(); i++){
        TypeExpressionPair loopPair = context.get(this.loopVar);
        switch (loopPair.getType().getTypeName()){
            case "num":
                loopPair.setValue(new NumExpressionNode((Double)listExpr.get(i)));
                break;

            case "text":
                loopPair.setValue(new StringExpressionNode((String)listExpr.get(i)));
                break;

            case "bool":
                loopPair.setValue(new BooleanLiteralExpressionNode((Boolean)listExpr.get(i)));
                break;

            default:
                symbolTableList.remove(context);
                throw new IllegalStateException("Error iterating through list");

        }
        Interpreter.runStatementList(symbolTableList, functionTable, this.body); 
	}
        symbolTableList.remove(context);
        throw new UnsupportedOperationException("Types are correct, for loop not yet implemented");
    }
}
