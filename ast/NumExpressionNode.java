import java_cup.runtime.*;
import java.util.*;

/**
 * This class represents a number (as an expression in the AST).
 *
 * @author Peter Ohmann + <your name here>
 */
public class NumExpressionNode extends PrimitiveExpressionNode {
    private double value;

    public NumExpressionNode(String text) {
        super();
        try {
            double val = Double.parseDouble(text);
            this.value = val;
        }
        catch (Exception e) {
            // this exception should never happen, so we'll have the parser
            // crash brutally
            System.err.println("Compilation error: invalid Num '" + text + "'");
            System.exit(1);
        }
    }

    public NumExpressionNode(double value){
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "" + this.value;
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
