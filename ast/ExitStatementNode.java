
import java.util.*;

/**
 * This class represents an exit statement in the AST.
 *
 * @author Peter Ohmann
 */
public class ExitStatementNode extends StatementNode {
    ExpressionNode e;

    public ExitStatementNode(ExpressionNode e) {
        super();
        this.e = e;
        this.children.add(e);
    }

    @Override
    public String toString() {
        return "Exit Statement";
    }
    
    /**
     *This method impliments the run method all statements need to
     *@param symbolTableList list with the symbol tables in order from least
     *to most specific
     *@param functionTable map with the functions
     *@throws UnsupportedOperationException not yet implemented
     */
    @Override
    public void run(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        try{ 
            int val = (int)(double)
                (((NumExpressionNode)this.e.evaluate(symbolTableList,functionTable)).getValue());
                System.exit(val);
        }catch(Exception e){
            System.exit(1);
        }

    }
}
