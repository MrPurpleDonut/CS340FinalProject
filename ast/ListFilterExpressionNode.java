import java.util.*;

/**
 * This class represents a list filter operation (expression[? expression ?])
 * in the AST.
 *
 * @author Peter Ohmann
 */
public class ListFilterExpressionNode extends ExpressionNode {
    private ExpressionNode array;
    private ExpressionNode regex;

    public ListFilterExpressionNode(ExpressionNode array, ExpressionNode pos) {
        super();
        this.array = array;
        this.regex = pos;
        this.children.add(array);
        this.children.add(pos);
    }

    @Override
    public String toString() {
        return "List Filter";
    }

    /**
     *This method evaluates this node and returns the expression after evaluating
     *@return ExpressionNode with the simplified expression
     *@throws UnsupportedOperationException
     */
    @Override
    public ExpressionNode evaluate(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        this.array = array.evaluate(symbolTableList, functionTable);
        this.regex = regex.evaluate(symbolTableList, functionTable);
        if(!(this.array instanceof ListExpressionNode) || !(this.regex instanceof StringExpressionNode)){
            throw new IllegalStateException("Error with expressions passed in filter");
        }
        String pattern = (String) this.regex.getValue();
        ListExpressionNode<String> stringList = (ListExpressionNode<String>)this.array;
        List<String> matches = new ArrayList<String>();
        for(int i = 0; i < stringList.size(); i++){
            String s = stringList.get(i);
            if(s.matches(pattern)){
                matches.add(s);
            }
        }

        return new ListExpressionNode(matches);
    }
}
