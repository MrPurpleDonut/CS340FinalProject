
import java.util.*;

/**
 * This class represents a switch statement in the AST.
 *
 * @author Peter Ohmann
 */
public class SwitchStatementNode extends StatementNode {
    private ExpressionNode switchVal;
    private CaseListNode cases;

    public SwitchStatementNode(ExpressionNode val, CaseListNode caseList) {
        super();
        this.switchVal = val;
        this.cases = caseList;
        this.children.add(val);
        this.children.add(caseList);
    }

    @Override
    public String toString() {
        return "Switch Statement";
    }

    /**
     *This method impliments the run method all statements need to
     *@param symbolTableList list with the symbol tables in order from least
     *to most specific
     *@param functionTable map with the functions
     *@throws UnsupportedOperationException not yet implemented
     */
    @Override
    public void run (List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        //TODO: Implement run
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
