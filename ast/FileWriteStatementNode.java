
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * This class represents a file write statement in the AST.
 *
 * @author Peter Ohmann
 */
public class FileWriteStatementNode extends StatementNode {
    private ExpressionNode contents;
    private ExpressionNode filePath;

    public FileWriteStatementNode(ExpressionNode c, ExpressionNode path) {
        super();
        this.contents = c;
        this.filePath = path;
        this.children.add(c);
        this.children.add(path);
    }

    @Override
    public String toString() {
        return "File Write Statement";
    }
    
    /**
     *This method impliments the run method all statements need to
     *@param symbolTableList list with the symbol tables in order from least
     *to most specific
     *@param functionTable map with the functions
     */
    @Override
    public void run(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){
        //Not totally sure if we should call evaluate on the children of this statement or on the instance variables
	ExpressionNode c = contents.evaluate(symbolTableList, functionTable);
	ExpressionNode f = filePath.evaluate(symbolTableList, functionTable);
	if (!(c instanceof StringExpressionNode) || !(f instanceof StringExpressionNode)){
	    throw new IllegalArgumentException("Must provide valid String contents and File Path!");
	}
	String write = ((StringExpressionNode)c).getValue();
	String path = ((StringExpressionNode)f).getValue();
	try {
	    FileWriter out = new FileWriter(new File(path));
	    out.append(write);
        out.close();
	} catch (IOException e){
	    e.printStackTrace();
	}
    }
}
