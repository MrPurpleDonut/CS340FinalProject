/**
 * This class represents a Function List in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class FunctionListNode extends ASTNode {
    /**
     * An empty function list.
     */
    public FunctionListNode() {
        super();
    }

    public void addFunction(FunctionNode f, int position) {
        this.children.add(position, f);
    }

    public void addFunction(FunctionNode f) {
        this.children.add(f);
    }

    @Override
    public String toString() {
        return "Function List";
    }
}
