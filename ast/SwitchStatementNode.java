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
}
