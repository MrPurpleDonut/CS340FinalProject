import java_cup.runtime.*;
import java.util.*;


/**
 * This class represents a boolean literal (either true or false).
 *
 * @author Peter Ohmann
 */
public class BooleanLiteralExpressionNode extends PrimitiveExpressionNode {
    private boolean value;

    public BooleanLiteralExpressionNode(boolean val) {
        super();
        this.value = val;
    }

    public Boolean getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Boolean literal: " + this.value;
    }
    /**
     *This method evaluates this node and returns the expression after evaluating
     *@return ExpressionNode with the simplified expression
     */
    @Override
    public ExpressionNode evaluate(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        return this;
    }
}
