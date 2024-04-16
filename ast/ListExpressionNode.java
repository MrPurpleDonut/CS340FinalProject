import java.util.*;

/**
 * This class represents a list (expression[expression]) in the
 * AST.
 *
 * @author Peter Ohmann
 */
public class ListExpressionNode<T> extends ExpressionNode {
    private List<T> list;

    public ListExpressionNode(List<T> list) {
        super();
        this.list = list;
    }

    public ListExpressionNode(ExpressionListNode e){
        List<T> list = new ArrayList<T>();
        Iterator<ASTNode> iter = e.childrenIter().iterator();
        while(iter.hasNext()){
            list.add((T) ((ExpressionNode)iter.next()).getValue());
        }
        this.list = list;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public int size(){
        return this.list.size();
    }

    public T get(int index){
        return this.list.get(index);
    }

    /**
     *This method evaluates this node and returns the expression after evaluating
     *@return ExpressionNode with the simplified expression
     *@throws UnsupportedOperationException
     */
    @Override
    public ExpressionNode evaluate(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        return this;
    }
}
