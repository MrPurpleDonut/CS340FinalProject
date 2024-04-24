/**
 * This class represents a Type in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class TypeNode extends ASTNode {
    private String typeName;

    /**
     * Rather than subtypes, we just use the String representation of
     * base (i.e., non-list) types.
     */
    public TypeNode(String type) {
        super();
        this.typeName = type;
    }

    public String getTypeName() {
        return this.typeName;
    }

    @Override
    public String toString() {
        return "Type: " + this.typeName;
    }

    @Override
    public boolean equals(Object o){
	if (!(o instanceof TypeNode)){
	    return false;   
	} else {
	    TypeNode other = (TypeNode) o;
	    if (this.getTypeName().equals( other.getTypeName())){
		return true;	
	    }
	    else{
		return false;
	    }
	}
    }
}
