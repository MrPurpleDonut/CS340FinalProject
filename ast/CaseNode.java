/**
 * This class represents a single "case" (part of a switch) in the AST.
 *
 * @author Peter Ohmann
 */
public class CaseNode extends ASTNode {
    private ExpressionNode valueExpression;
    private StatementNode runStatement;

    public CaseNode(ExpressionNode value, StatementNode run) {
        super();
        this.valueExpression = value;
        this.runStatement = run;
        if (value != null)
          this.children.add(value);
        this.children.add(run);
    }

    public StatementNode getStatement(){
        return this.runStatement;
    }

    public ExpressionNode getValue(){
        return this.valueExpression;
    }

    @Override
    public String toString() {
        if (this.valueExpression == null)
            return "Default Case";
        else
            return "Case";
    }
}
