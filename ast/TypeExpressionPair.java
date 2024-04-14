/**
     *Class for variables so we can have the type and
     *expression together in our map
     */
    public class TypeExpressionPair{
        private TypeNode type;
        private ExpressionNode node;
        
        /**
         *Constructor
         *@param type TypeNode with the type
         *@param node ExpressionNode with value
         */
        public TypeExpressionPair(TypeNode type, ExpressionNode node){
            this.type = type;
            this.node = node;
        }
        
        //Shouldn't need to change the type, so no setter
        //To update value of a variable, we can replace the node it contains

        public TypeNode getType(){
            return this.type;
        }

        public ExpressionNode getValue(){
            return this.node;
        }

        public void setValue(ExpressionNode node){
            this.node = node;
        }

    }

