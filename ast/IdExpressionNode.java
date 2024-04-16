import java_cup.runtime.*;
import java.util.*;

/**
 * This class represents an identifier (as an expression in the AST).
 *
 * @author Peter Ohmann + <your name here>
 */
public class IdExpressionNode extends ExpressionNode {
    private String value;

    public IdExpressionNode(String id) {
        super();
        this.value = id;
    }

    @Override
    public String toString() {
        return this.value;
    }
    /**
     *This method evaluates this node and returns the expression after evaluating
     *@return ExpressionNode with the simplified expression
     *@throws UnsupportedOperationException
     */
    @Override
    public ExpressionNode evaluate(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        
        boolean exists = false;
        Map<String, TypeExpressionPair> context = symbolTableList.get(0);
        for(int i = symbolTableList.size()-1; i>=0; i--){
           context = symbolTableList.get(i);
           if(context.containsKey(this.value)){
            exists = true;
            break;
           }
        }
        if(!exists){
            throw new IllegalStateException("Error: id "+this.value+" doesn't exist");
        }
        return context.get(this.value).getValue();

    }
}
