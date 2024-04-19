import java_cup.runtime.*;
import java.util.*;
import java.io.*;
/**
 * This class represents a file read statement in the AST.
 *
 * @author Peter Ohmann
 */
public class FileReadStatementNode extends AssignStatementNode {
    private String id;
    private ExpressionNode path;
    public FileReadStatementNode(String id, ExpressionNode e) {
        super(id, e);
        this.id = id;
        this.path = e;
    }

    @Override
    public String toString() {
        return "File Read into variable: " + this.getId();
    }
    
    /**
     *This method impliments the run method all statements need to
     *@param symbolTableList list with the symbol tables in order from least
     *to most specific
     *@param functionTable map with the functions
     *@throws UnsupportedOperationException not yet implemented
     */
    @Override
    public void run(List<Map<String, TypeExpressionPair>> symbolTableList,
            Map<String, FunctionNode> functionTable){

        boolean exists = false;
        Map<String, TypeExpressionPair> context = symbolTableList.get(0);
        for(int i = symbolTableList.size()-1; i>=0; i--){
           context = symbolTableList.get(i);
           if(context.containsKey(this.id)){
            exists = true;
            break;
           }
        }

        if(!exists){
            throw new IllegalStateException("Error: variable "+this.id+" not intialized");
        }
        String inputString = "";
        try{
            FileReader input = new FileReader(((StringExpressionNode)
                    this.path.evaluate(symbolTableList,functionTable))
            .getValue());

            int inputChar = input.read();
            while(inputChar != -1){
                inputString += ((char)inputChar);
                inputChar = input.read();
            }
        }catch(IOException e){
            throw new IllegalArgumentException("Error reading file");
        }
        TypeExpressionPair variable = context.get(this.id); 
        if(!variable.getType().getTypeName().equals("text")){
            throw new IllegalArgumentException("File read returns type text");
        }
        variable.setValue(new StringExpressionNode(inputString));
    }
}
