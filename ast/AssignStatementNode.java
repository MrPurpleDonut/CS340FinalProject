import java_cup.runtime.*;
import java.util.*;

/**
 * This class represents an assignment statement in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class AssignStatementNode extends StatementNode {
    private String id;

    public AssignStatementNode(String id, ExpressionNode e) {
        super();
        this.id = id;
        this.children.add(e);
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Assignment statement: " + this.id;
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


        Iterator<ASTNode> iterator = this.childrenIter().iterator();
        ExpressionNode child = (ExpressionNode) iterator.next();
        child = child.evaluate(symbolTableList, functionTable);

        //Making sure variable already exists, else throw an exception
        //Also getting the specific context
        boolean exists = false;
        Map<String, TypeExpressionPair> context = symbolTableList.get(0);
        for(int i = symbolTableList.size()-1; i>=0; i--){
           context = symbolTableList.get(i);
           if(context.containsKey(this.id)){
            exists = true;
            break;
           }
        }

        if(!exists){
            throw new IllegalStateException("Error: variable "+this.id+" not intialized");
        }

        TypeExpressionPair variable = context.get(this.id);

        //Type Checking
        switch(variable.getType().getTypeName()) {

            case "num":
                if(!(child instanceof NumExpressionNode)){
                    throw new IllegalStateException("Error: variable "+this.id+"intialized as num");
                }
                break;

            case "text":
                if(!(child instanceof StringExpressionNode)){
                    throw new IllegalStateException("Error: variable "+this.id+"intialized as text");
                }
                break;

            case "bool":
                if(!(child instanceof BooleanLiteralExpressionNode)){
                    throw new IllegalStateException("Error: variable "+this.id+"intialized as bool");
                }
                break;

            case "list":
                throw new UnsupportedOperationException("List type not yet implemented");

            default:
                throw new IllegalStateException("Error: unrecongnized type");

        }
        variable.setValue(child);
    }
}
