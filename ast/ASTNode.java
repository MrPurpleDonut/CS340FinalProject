import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a node of the abstract syntax tree.
 * All nodes need a way to print it out (i.e., a toString()), and many will
 * have children.
 * Note that this is just an abstract superclass; there should be a subclass
 * for most types of non-terminal in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public abstract class ASTNode {
    // subclasses should put their child nodes here
    protected List<ASTNode> children;

    public ASTNode() {
        this.children = new ArrayList<ASTNode>();
    }

    /**
     * Return an Iterable over the children of this parse tree node.
     */
    public Iterable<ASTNode> childrenIter() {
        return Collections.unmodifiableList(this.children);
    }

    // force sub-classes to override toString
    // it's a bit hack-y and weird, but it should get the point across :)
    @Override
    public abstract String toString();
}
