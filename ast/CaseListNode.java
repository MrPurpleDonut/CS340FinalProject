/**
 * This class represents a list of Cases (part of a switch) in the AST.
 *
 * @author Peter Ohmann
 */
public class CaseListNode extends ASTNode {
    public CaseListNode() {
        super();
    }

    public void addCase(CaseNode c, int position) {
        this.children.add(position, c);
    }

    public void addCase(CaseNode c) {
        this.children.add(c);
    }

    @Override
    public String toString() {
        return "Case List";
    }
}
