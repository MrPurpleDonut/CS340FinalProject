import java_cup.runtime.*;
import java.util.*;

/**
 * This class represents a quoted string (as an expression in the AST).
 *
 * @author Peter Ohmann
 */
public class StringExpressionNode extends ExpressionNode {
    private String value;

    public StringExpressionNode(String qstring) {
        super();
        this.value = qstring;
    }

    @Override
    public String toString() {
        return "Quoted string: " + this.value;
    }

    public String getValue(){
        return this.value;
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
