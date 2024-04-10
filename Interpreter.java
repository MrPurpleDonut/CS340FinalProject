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
    }

}
