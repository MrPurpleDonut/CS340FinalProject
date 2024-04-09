/**
 * This class represents a function parameter in the AST.
 *
 * @author Peter Ohmann
 */
public class ParameterNode extends ASTNode {
    private TypeNode type;
    private String name;

    public ParameterNode(TypeNode paramType, String paramName) {
        super();
        this.type = paramType;
        this.name = paramName;
        this.children.add(paramType);
    }

    @Override
    public String toString() {
        return "Parameter: " + this.name;
    }
}
