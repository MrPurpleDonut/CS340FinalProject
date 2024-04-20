import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class represents a function in the AST.
 *
 * @author Peter Ohmann
 */
public class FunctionNode extends ASTNode {
    private TypeNode type;
    private String name;
    private ParameterListNode params;
    private StatementListNode body;
    private boolean debugMode = false;

    public FunctionNode(TypeNode type, String name,
                        ParameterListNode params, StatementListNode body) {
        super();
        this.type = type;
        this.name = name;
        this.params = params;
        this.body = body;

        this.children.add(type);
        this.children.add(params);
        this.children.add(body);
    }
    
    public String getName(){
        return this.name;
    }

    // for function call evaluate checking if returned value matches expected type
    public TypeNode getType() {
        return this.type;
    }

    public ParameterListNode getParams() {
        return this.params;
    }

    @Override
    public String toString() {
        return "Function declaration: " + this.name;
    }

    public ExpressionNode getReturnValue(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable) {
        
        if(this.debugMode) {
            System.out.println("--getting return value");
        }

        // check to make sure there is a return statement
        Iterator<ASTNode> iterator = this.body.childrenIter().iterator();
        boolean hasReturn = false;
       


        while(iterator.hasNext()) {
            ASTNode check = iterator.next();

            if(this.debugMode) {
                System.out.println("In funk: " + check.toString());
            }
            if(check.toString().equals("Return Statement")) {
                hasReturn = true;
                if(this.debugMode) {
                    System.out.println("FOUND RETURN STATEMENT!");
                }
                
                break;
            }
        }

        // run each line in body
        if(this.debugMode) {
            System.out.println("--running body");
        }
        
        Interpreter.runStatementList(symbolTableList, functionTable, this.body);

        if(hasReturn){
            Map<String, TypeExpressionPair> context = symbolTableList.get(symbolTableList.size()-1);
            return context.get("return").getValue();
        }   
        return null;
    }
}
