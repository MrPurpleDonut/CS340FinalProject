/**
 *This is the class to actually run the interpreter
 *Pass in the file you want to interpret as an arg
 */

import java.util.*;

public class Interpreter{

    public static void main(String[] args){
        run(args[0]);
    }

    /**
     *This method controls and runs the Interpreter
     *@param file String with the name of the file to interpret
     */
    private static void run(String file){
        ProgramNode program = StreamerC.parseProgram(file);
        if(program == null){
            System.err.println("Error parsing program");
            System.exit(1);
        }
        
        Iterator<ASTNode> programChildren = program.childrenIter().iterator();
        FunctionListNode functionList = (FunctionListNode)programChildren.next();
        StatementListNode statementList = (StatementListNode)programChildren.next();
       
        //Functions: ID, Type, Params, StatementList
        //Everything is stored in node, so have that as value
        Map<String, FunctionNode> functionTable = new HashMap<String, FunctionNode>();
        Iterator<ASTNode> functionIter = functionList.childrenIter().iterator();
        while(functionIter.hasNext()){
            FunctionNode node = (FunctionNode)functionIter.next();
            if(functionTable.containsKey(node.getName())){
                System.err.println("Error: functions with duplicate name");
                System.exit(1);
            }
            functionTable.put(node.getName(), node);

        }
        //TypeExpressionPair is a class with a String for the type and ExpressionNode for the value
        Map<String, TypeExpressionPair> globalTable = new HashMap<String, TypeExpressionPair>();
        
        //List of Contexts:
        //Global Table always at index 0
        //Add context specific table to the end
        //Always start searching at the last table 
        //Always remove the table when the context is over
        List<Map<String, TypeExpressionPair>> symbolTableList = new ArrayList<Map<String, TypeExpressionPair>>();
        symbolTableList.add(0, globalTable);

        //TODO:Create run method for StatementNode - abstract method implimented by each specific one
        //TODO:For each specific node, have it throw UnsupportedOperationException so we know we haven't implimented
        //TODO:Create evaluate method for expression Node - no abstract method so we can return types
        //TODO:Iterate through Statement list calling run(symbolTableList, functionList) on each
    }
    
    

}
