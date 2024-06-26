import java.util.*;

/**
 * This class represents an Expression in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public abstract class ExpressionNode extends ASTNode {
    // There are more specific types of expressions, so see subclasses...
    

    public abstract ExpressionNode evaluate(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable);

    public Object getValue(){
        return null;
    }
}
