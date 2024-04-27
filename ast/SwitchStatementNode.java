
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
        this.switchVal = this.switchVal.evaluate(symbolTableList, functionTable);
        
        Iterator<ASTNode> caseIter = this.cases.childrenIter().iterator();
        while(caseIter.hasNext()){
            CaseNode currentCase = (CaseNode) caseIter.next();
            if(currentCase.toString().equals("Default Case")){
                currentCase.getStatement().run(symbolTableList, functionTable);
                return;
            }
            ExpressionNode caseValue = currentCase.getValue().evaluate(symbolTableList, functionTable);
            if(!(caseValue instanceof PrimitiveExpressionNode) || !(this.switchVal instanceof PrimitiveExpressionNode)){
                throw new UnsupportedOperationException("Comparison only implimented for primitive types");
            }
            if(((PrimitiveExpressionNode)caseValue).getValue().equals(
                ((PrimitiveExpressionNode)this.switchVal).getValue())){
                currentCase.getStatement().run(symbolTableList, functionTable);
                return;
            }
        }
    }
}
