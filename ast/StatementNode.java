/**
 * This class represents a Statement in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
import java.util.*;

public abstract class StatementNode extends ASTNode {

    public abstract void run(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable);
    // There are more specific types of statements, so see subclasses...
}
