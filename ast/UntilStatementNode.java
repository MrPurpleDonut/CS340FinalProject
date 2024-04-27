
import java.util.*;

/**
 * This class represents an until statement in the AST.
 *
 * @author Peter Ohmann
 */
public class UntilStatementNode extends StatementNode {
    private StatementNode checkStatement;
    private StatementListNode loopBody;

    public UntilStatementNode(StatementNode s, StatementListNode body) {
        super();
        this.checkStatement = s;
        this.loopBody = body;
        this.children.add(s);
        this.children.add(body);
    }

    @Override
    public String toString() {
        return "Until Statement";
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
        boolean crash = true;
        List<Map<String, TypeExpressionPair>> duplicate = null;
        while(crash){
            duplicate = deepCopy(symbolTableList);
            try{
                this.checkStatement.run(duplicate, functionTable);
                crash = false;
            }catch(Exception e){
                Interpreter.runStatementList(symbolTableList, functionTable, this.loopBody);
            }
        }
        for(int i = 0; i < symbolTableList.size(); i++){
            symbolTableList.set(i, duplicate.get(i));
        }   

    }

    private List<Map<String, TypeExpressionPair>> deepCopy(List<Map<String, TypeExpressionPair>> toBeCopied){
        List<Map<String, TypeExpressionPair>> newList = new ArrayList<Map<String, TypeExpressionPair>>();
        for(int i = 0; i < toBeCopied.size(); i++){
            newList.add(deepEnoughCopy(toBeCopied.get(i)));
        }
        return newList;
    }

    private Map<String, TypeExpressionPair> deepEnoughCopy(Map<String, TypeExpressionPair> toBeCopied){
        Map<String, TypeExpressionPair> newMap = new HashMap<String, TypeExpressionPair>();
        for(String key: toBeCopied.keySet()){
            newMap.put(key, toBeCopied.get(key));
        }
        return newMap;
    }
}
