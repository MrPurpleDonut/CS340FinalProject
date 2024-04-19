import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class represents a Statement List in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class StatementListNode extends ASTNode {
    /**
     * An empty statement list.
     */
    public StatementListNode() {
        super();
    }

    public void addStatement(StatementNode s, int position) {
        this.children.add(position, s);
    }

    public void addStatement(StatementNode s) {
        this.children.add(s);
    }

    @Override
    public String toString() {
        return "Statement List";
    }
    
    public void run(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable) {
        System.out.println("running lines");

        Iterator<ASTNode> iterator = this.childrenIter().iterator();
        
        while(iterator.hasNext()) {
            StatementNode currentLine = (StatementNode) (iterator.next());
            
            // System.out.println("runing line " + currentLine.toString());
            
            currentLine.run(symbolTableList, functionTable);
        }
    }
}
