import java.util.*;

/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class BinaryOpExpressionNode extends ExpressionNode {
    private ExpressionNode left;
    private ExpressionNode right;
    private String operator;

    /**
     * Represent an infix binary operator; that is "left op right".
     */
    public BinaryOpExpressionNode(ExpressionNode left,
                                  ExpressionNode right, String op) {
        super();
        this.left = left;
        this.right = right;
        this.operator = op;
        this.children.add(left);
        this.children.add(right);
    }

    @Override
    public String toString() {
        return "Binary operator '" + this.operator + "'";
    }
    /**
     *This method evaluates this node and returns the expression after evaluating
     *@return ExpressionNode with the simplified expression
     *@throws UnsupportedOperationException
     */
    @Override
    public ExpressionNode evaluate(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        //TODO: Add supported for more binary operations
        ExpressionNode leftOp = left.evaluate(symbolTableList, functionTable);
        ExpressionNode rightOp = right.evaluate(symbolTableList, functionTable);

        switch(this.operator){
            case "+":
               if(leftOp instanceof NumExpressionNode && rightOp instanceof NumExpressionNode){
                double plusVal = ((NumExpressionNode)leftOp).getValue() + ((NumExpressionNode)rightOp).getValue();
                return new NumExpressionNode(plusVal);
               }
               if(leftOp instanceof StringExpressionNode && rightOp instanceof StringExpressionNode){
                String plusVal = ((StringExpressionNode)leftOp).getValue() + ((StringExpressionNode)rightOp).getValue();
                return new StringExpressionNode(plusVal);
               }
               if(leftOp instanceof NumExpressionNode && rightOp instanceof StringExpressionNode){
                String plusVal = ((NumExpressionNode)leftOp).getValue() + ((StringExpressionNode)rightOp).getValue();
                return new StringExpressionNode(plusVal);
               }
               if(leftOp instanceof StringExpressionNode && rightOp instanceof NumExpressionNode){
                String plusVal = ((StringExpressionNode)leftOp).getValue() + ((NumExpressionNode)rightOp).getValue();
                return new StringExpressionNode(plusVal);
               }
                throw new IllegalArgumentException("Plus expected types num and num");
            case "-":
               if(leftOp instanceof NumExpressionNode && rightOp instanceof NumExpressionNode){
                double minusVal = ((NumExpressionNode)leftOp).getValue() - ((NumExpressionNode)rightOp).getValue();
                return new NumExpressionNode(minusVal);
               }
                throw new IllegalArgumentException("Minus expected types num and num");
            case "*":
                throw new IllegalArgumentException("Times expected types num and num");
            case "/":
               if(leftOp instanceof NumExpressionNode && rightOp instanceof NumExpressionNode){
                double divVal = ((NumExpressionNode)leftOp).getValue() / ((NumExpressionNode)rightOp).getValue();
                return new NumExpressionNode(divVal);
               }
               if(leftOp instanceof StringExpressionNode && rightOp instanceof StringExpressionNode){
                String[] stringList = ((StringExpressionNode)leftOp).getValue().split(
                        ((StringExpressionNode)rightOp).getValue());

                return new ListExpressionNode<String>(Arrays.asList(stringList));
               }
                throw new IllegalArgumentException("Divide expected types num and num");
            case "||":
               if(leftOp instanceof BooleanLiteralExpressionNode && rightOp instanceof BooleanLiteralExpressionNode){
                boolean orVal = ((BooleanLiteralExpressionNode)leftOp).getValue() || ((BooleanLiteralExpressionNode)rightOp).getValue();
                return new BooleanLiteralExpressionNode(orVal);
               }
                throw new IllegalArgumentException("Or expected types bool and bool");
            case "&&":
               if(leftOp instanceof BooleanLiteralExpressionNode && rightOp instanceof BooleanLiteralExpressionNode){
                boolean andVal = ((BooleanLiteralExpressionNode)leftOp).getValue() && ((BooleanLiteralExpressionNode)rightOp).getValue();
                return new BooleanLiteralExpressionNode(andVal);
               }
                throw new IllegalArgumentException("And expected types bool and bool");
            case "==":
                if(leftOp instanceof PrimitiveExpressionNode && rightOp instanceof PrimitiveExpressionNode){
                boolean equalVal = ((PrimitiveExpressionNode)leftOp).getValue().equals(((PrimitiveExpressionNode)rightOp).getValue());
                return new BooleanLiteralExpressionNode(equalVal);
                }
                throw new UnsupportedOperationException("Equality not yet implimented for lists");
            default:
                throw new UnsupportedOperationException("Not yet implemented");
        }
    }
}
