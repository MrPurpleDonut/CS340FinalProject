/**
 * This class represents a Program in (i.e., the root of) the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class ProgramNode extends ASTNode {
    /**
     * A program is a list of function declarations followed by a list
     * of statements (for the "main" of the program).
     */
    public ProgramNode(FunctionListNode funcs, StatementListNode stmts) {
        super();
        this.children.add(funcs);
        this.children.add(stmts);
    }

    @Override
    public String toString() {
        return "Program";
    }
}
