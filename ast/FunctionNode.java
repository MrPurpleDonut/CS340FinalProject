/**
 * This class represents a function in the AST.
 *
 * @author Peter Ohmann
 */
public class FunctionNode extends ASTNode {
    private TypeNode type;
    private String name;
    private ParameterListNode params;
    private StatementListNode body;

    public FunctionNode(TypeNode type, String name,
                        ParameterListNode params, StatementListNode body) {
        super();
        this.type = type;
        this.name = name;
        this.params = params;
        this.body = body;

        this.children.add(type);
        this.children.add(params);
        this.children.add(body);
    }
    
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Function declaration: " + this.name;
    }
}
