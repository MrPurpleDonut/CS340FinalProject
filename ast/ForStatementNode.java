/**
 * This class represents a for-each statement in the AST.
 *
 * @author Peter Ohmann
 */
public class ForStatementNode extends StatementNode {
    private TypeNode loopVarType;
    private String loopVar;
    private ExpressionNode collection;
    private StatementListNode body;

    public ForStatementNode(TypeNode loopVarType, String loopVarName,
                            ExpressionNode collection,
                            StatementListNode body) {
        super();
        this.loopVarType = loopVarType;
        this.loopVar = loopVarName;
        this.collection = collection;
        this.body = body;
        this.children.add(loopVarType);
        this.children.add(collection);
        this.children.add(body);
    }

    @Override
    public String toString() {
        return "For Statement: " + this.loopVar;
    }
}
