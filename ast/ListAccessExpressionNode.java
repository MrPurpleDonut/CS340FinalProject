import java.util.*;

/**
 * This class represents a list access (expression[expression]) in the
 * AST.
 *
 * @author Peter Ohmann
 */
public class ListAccessExpressionNode extends ExpressionNode {
    private ExpressionNode array;
    private ExpressionNode position;

    public ListAccessExpressionNode(ExpressionNode array, ExpressionNode pos) {
        super();
        this.array = array;
        this.position = pos;
        this.children.add(array);
        this.children.add(pos);
    }

    @Override
    public String toString() {
        return "List Access";
    }
    /**
     *This method evaluates this node and returns the expression after evaluating
     *@return ExpressionNode with the simplified expression
     *@throws IllegalArgumentException
     */
    @Override
    public ExpressionNode evaluate(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        ExpressionNode pos = this.position.evaluate(symbolTableList, functionTable);
        if(!(this.array instanceof IdExpressionNode &&
                    pos instanceof NumExpressionNode)){
            throw new IllegalArgumentException("Invalid arguments for List access");
                    }
        
        String id = this.array.toString();
        boolean exists = false;
        Map<String, TypeExpressionPair> context = symbolTableList.get(0);
        for(int i = symbolTableList.size()-1; i>=0; i--){
           context = symbolTableList.get(i);
           if(context.containsKey(id)){
            exists = true;
            break;
           }
        }
        if(!exists){
            throw new IllegalStateException("Error: id "+id+" doesn't exist");
        }


        TypeExpressionPair variable = context.get(id);
        TypeNode listTypeParent = variable.getType();
        

        Iterator<ASTNode> iter = listTypeParent.childrenIter().iterator();
        if(!iter.hasNext()){
            throw new IllegalStateException("Error accessing type of list");
        }
        TypeNode listType = (TypeNode)iter.next();

        int index = (int) ((NumExpressionNode) pos).getValue();

        switch(listType.getTypeName()){

            case "text":
                String val = ((ListExpressionNode<String>) (variable.getValue())).get(index);
                return new StringExpressionNode(val);
            case "num":
                double doubleVal = ((ListExpressionNode<Double>) (variable.getValue())).get(index);
                return new NumExpressionNode(doubleVal);
            case "bool":
                boolean boolVal = ((ListExpressionNode<Boolean>) (variable.getValue())).get(index);
                return new BooleanLiteralExpressionNode(boolVal);
            default:
                throw new IllegalArgumentException("Invalid type");

        }



    }
}
