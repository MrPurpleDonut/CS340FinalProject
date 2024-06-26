
import java.util.*;

/**
 * This class represents an if (or an if-else) statement in the AST.
 *
 * @author Peter Ohmann
 */
public class IfStatementNode extends StatementNode {
    private ExpressionNode condition;
    private StatementListNode ifBody;
    private StatementListNode elseBody;

    public IfStatementNode(ExpressionNode cond, StatementListNode ifBody) {
        super();
        this.condition = cond;
        this.ifBody = ifBody;
        this.elseBody = null;
        this.children.add(cond);
        this.children.add(ifBody);
    }

    public IfStatementNode(ExpressionNode cond, StatementListNode ifBody,
                           StatementListNode elseBody) {
        this(cond, ifBody);
        this.elseBody = elseBody;
        this.children.add(elseBody);
    }

    @Override
    public String toString() {
        return "If Statement";
    }

    /**
     *This method impliments the run method all statements need to
     *@param symbolTableList list with the symbol tables in order from least
     *to most specific
     *@param functionTable map with the functions
     */
    @Override
    public void run(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
	ExpressionNode bool = condition.evaluate(symbolTableList, functionTable);
	if (!(bool instanceof BooleanLiteralExpressionNode)){
	    throw new IllegalArgumentException("Provide valid Boolean Expression for if conditional");
	}
	if ( ((BooleanLiteralExpressionNode)bool).getValue() ){
	    // the StatementListNode class doesn't have a run method, not totally sure how to continue to execute the statements in the body of the condition
	    //ifBody.run();
        Interpreter.runStatementList(symbolTableList, functionTable, ifBody);
	} else{
	    //elseBody.run();
        if(this.elseBody == null){
            return;
        }
        Interpreter.runStatementList(symbolTableList, functionTable, elseBody);
	}
    }
}
