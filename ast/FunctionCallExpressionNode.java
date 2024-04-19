import java.util.*;


/**
 * This class represents a function call in the AST.
 *
 * @author Peter Ohmann
 */
public class FunctionCallExpressionNode extends ExpressionNode {
    private String funcName;
    private ExpressionListNode params;
    private boolean debugMode = false;

    public FunctionCallExpressionNode(String funcName,
                                      ExpressionListNode parameters) {
        super();
        this.funcName = funcName;
        this.params = parameters;
        this.children.add(parameters);
    }

    @Override
    public String toString() {
        return "Function call: " + this.funcName;
    }

    /**
     *This method evaluates this node and returns the expression after evaluating
     *@return ExpressionNode with the simplified expression
     *@throws UnsupportedOperationException
     */
    @Override
    public ExpressionNode evaluate(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        
        if(this.debugMode) {
            System.out.println("==== FC DEBUG START ====");
        }
        
        // first see if the function trying to call actually exists
        boolean exists = functionTable.containsKey(this.funcName);
        if(!(exists)) {
            throw new IllegalStateException("Error: funktion " + this.funcName + " doesn't exist");
        }

        // get function object
        FunctionNode funk = functionTable.get(this.funcName);
        String expectedType = funk.getType().getTypeName();;
        boolean returnIsVoid = expectedType.equals("void");

        // check if number of called paramters equals number of expected called paramteres
        Iterator<ASTNode> funkParamsIterator = funk.getParams().childrenIter().iterator();
        Iterator<ASTNode> callParamsIterator = this.params.childrenIter().iterator();

        // create arrayLists of function and function call parameters to check if types match later
        ArrayList<ParameterNode> funkParams = new ArrayList<ParameterNode>();
        ArrayList<ExpressionNode> callParams = new ArrayList<ExpressionNode>();
        
        int funkParamsCount = 0;
        while(funkParamsIterator.hasNext()) {
            funkParams.add((ParameterNode) funkParamsIterator.next());

            ++funkParamsCount;
        }

        int callParamsCount = 0;
        while(callParamsIterator.hasNext()) {
            callParams.add((ExpressionNode) callParamsIterator.next());
            
            ++callParamsCount;
        }

        boolean paramsCountSame = (funkParamsCount == callParamsCount);
        if(!(paramsCountSame)) {
            throw new IllegalStateException("Error: Number of parameters in function and function call do not match");
        }

        if(this.debugMode) {
            System.out.println("--param counts match? " + String.valueOf(funkParamsCount == callParamsCount));
        }
        
        Map<String, TypeExpressionPair> context = new HashMap<String, TypeExpressionPair>();
        // make sure called parameters types and function paramter types match
        for(int i = 0; i < funkParams.size(); i++) {
            String funkParamType = funkParams.get(i).getTypeNode().getTypeName();
            ExpressionNode evaluate = callParams.get(i).evaluate(symbolTableList, functionTable);
            String callParamType = evaluate.getValue().getClass().getSimpleName();
            context.put(funkParams.get(i).getName(), 
                new TypeExpressionPair(
                    funkParams.get(i).getTypeNode(), 
                    evaluate));

            boolean match = false;

            switch(callParamType) {
                case "Double":
                    if(funkParamType.equals("num")) {
                        match = true;
                    }
    
                    break;
                case "String":
                    if(funkParamType.equals("text")) {
                        match = true;
                    }

                    break;
            }

            if(!(match)) {
                throw new IllegalStateException(
                    "Error: Paramter " + i + 
                    " types of function (" + funkParamType + ")" + 
                    " and call (" + callParamType + ")" +
                    " do not match"
                );
            }
            
            if(this.debugMode) {
                System.out.println("--Parms " + i + " matches: " + funkParamType + ", " + callParamType);
            }
        }

        if(this.debugMode) {
            System.out.println("PARAMS ARE GOOD!");
        }

        
        symbolTableList.add(context);
        
        

        // get retunrned expression node (call evaluate in case something like ID and need actual value)
        ExpressionNode returned = null;
        
        // check if return value exists and matches expected type
        if(!(returnIsVoid)) {
            // make sure return value exists
            Object returnedType = null;
            try {
                returned = funk.getReturnValue(symbolTableList, functionTable).evaluate(symbolTableList, functionTable);
                returnedType = returned.getValue().getClass().getSimpleName();
            }
            catch(NullPointerException N) {
                symbolTableList.remove(context);
                throw new IllegalStateException("Error: No return statement");
            }

            boolean typeMatches = false;

            switch((String) returnedType) {
                case "Double":
                    if(expectedType.equals("num")) {
                        typeMatches = true;
                    }

                    break;
                case "String":
                    if(expectedType.equals("text")) {
                        typeMatches = true;
                    }

                    break;
            }

            if(!(typeMatches)) {
                symbolTableList.remove(context);
                throw new IllegalStateException("Error: expected type of " + expectedType + " doesn't match returned type of " + returnedType);
            }
        }
        // make sure there is no return for void functions
        else {
            try {
                returned = funk.getReturnValue(symbolTableList, functionTable).evaluate(symbolTableList, functionTable);
                symbolTableList.remove(context);
                throw new IllegalStateException("Error: Void return function cannot have a return statement");
            }
            catch(NullPointerException N) {
                
                String unused = "unused";
            }
        }
        
        if(this.debugMode) {
            System.out.println("==== FC DEBUG END ====");
        }


        symbolTableList.remove(context);
        return returned;
    }
}
