/**
 * This class represents a Parameter List in the AST.
 *
 * @author Peter Ohmann
 */
public class ParameterListNode extends ASTNode {
    /**
     * An empty parameter list.
     */
    public ParameterListNode() {
        super();
    }

    /**
     * A parameter list with just a single element.
     */
    public ParameterListNode(ParameterNode p) {
        super();
        this.children.add(p);
    }

    public void addParameter(ParameterNode p, int position) {
        this.children.add(position, p);
    }

    public void addParameter(ParameterNode p) {
        this.children.add(p);
    }

    @Override
    public String toString() {
        return "Parameter List";
    }
}
