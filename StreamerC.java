import java.io.FileReader;
import java_cup.runtime.Symbol;

/**
 * This class is the primary Streamer compiler front-end.  Currently (for HW3)
 * it creates a Scanner and runs the Parser using that Scanner to get tokens.
 * It then prints out the abstract syntax tree produced by the Parser,
 * increasing the indent of printed nodes for each level of the tree.
 *
 * @author <your name here> based on a template by Peter Ohmann
 */
public class StreamerC {
    /**
     * Recursively print out the AST node provided.  External callers
     * should use the single-parameter version, unless they need an initial
     * indent other than "".
     *
     * @param node the AST node to (recursively) print out
     * @param indent the current indent to use (increases as we recurse down
     *               the tree)
     */
    private static void printAST(ASTNode node, String indent) {
        System.out.println(indent + node);
        for (ASTNode child : node.childrenIter()) {
            printAST(child, indent + "    ");
        }
    }

    /**
     * Recursively print out the AST node provided.  Assumes no indent
     * for the root of the tree.  External callers should pass the root of the
     * AST as node.
     *
     * @param node the AST node to (recursively) print out
     */
    private static void printAST(ASTNode node) {
        printAST(node, "");
    }

    public static void main(String argv[]) {    
        try {
            Yylex scanner = new Yylex(new FileReader(argv[0]));
            Parser parser = new Parser(scanner);

            try {
                // the parser returns a Symbol whose value instance variable
                // is the root nonterminal of the abstract syntax tree
                Symbol root = parser.parse();
                System.out.println("Program parsed correctly!");
                if (root.value instanceof ASTNode) {
                    System.out.println("---------------------------");
                    System.out.println("--------Printing AST-------");
                    System.out.println("---------------------------");
                    printAST((ASTNode)root.value);
                }
                else {
                    System.out.println("---------------------------");
                    System.out.println("Ignoring invalid AST for printing...");
                }
            }
            catch (Exception e) {
                System.err.println("Parsing threw an exception!");
                e.printStackTrace();
                System.exit(1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
