/**
     *Class for variables so we can have the type and
     *expression together in our map
     */
    public class TypeExpressionPair{
        private String type;
        private ExpressionNode node;
        
        /**
         *Constructor
         *@param type String with the type
         *@param node ExpressionNode with value
         */
        public TypeExpressionPair(String type, ExpressionNode node){
            this.type = type;
            this.node = node;
        }
        
        //Shouldn't need to change the type, so no setter
        //To update value of a variable, we can replace the node it contains

        public String getType(){
            return this.type;
        }

        public ExpressionNode getNode(){
            return this.node;
        }

        public void setNode(ExpressionNode node){
            this.node = node;
        }

    }

