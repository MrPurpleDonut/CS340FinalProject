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


    }

}
