package fourth.Tree;

public class AVLTree<K extends Comparable<K>> extends BinaryTree<K> {

    @Override
    public Node insert(K var1) {
        Node newNode;
        if (root == null) {
            newNode = new AVLNode(var1);
            root = newNode;
        } else {
            newNode = new AVLNode(insert(var1, root));
            ((AVLNode)newNode).fixRelations();
        }
        balance(newNode);
        return newNode;
    }

    @Override
    public Node delete(K var1) {
        if (root == null)
            return null;
        Node tmpNode = new AVLNode(delete(var1, root));
        ((AVLNode)tmpNode).fixRelations();
        balance(tmpNode);
        return tmpNode;
    }

    @Override
    public Node find(K var1) {
        if (root == null) {
            return null;
        } else
            return super.find(var1, root);
    }

    protected void balance(Node node) {
        ((AVLNode) node).fixBalanceFactor();
        if (((AVLNode) node).getBalanceFactor() == 2) {

            if ( node.getRight() != null && ((AVLNode) node.getRight()).getBalanceFactor() < 0) {
                rightTurn(node.getRight());
            }
            leftTurn(node);
            return;
        }
        if ( ((AVLNode) node).getBalanceFactor() == -2) {

            if ( node.getLeft() != null && ((AVLNode) node.getLeft()).getBalanceFactor() > 0) {
                leftTurn(node.getLeft());
            }
            rightTurn(node);
            return;
        }
        return;
    }

    public class AVLNode<K extends Comparable<K>> extends BinaryNode<K> {

        private int balanceFactor;

        public AVLNode(Node node){
            super((K)node.getKey(), node.getLeft(), node.getRight(), node.getParent());
            balanceFactor = 0;
        }

        public AVLNode(K var1) {
            super(var1);
            balanceFactor = 0;
        }

        protected void fixRelations(){
            if(getParent() != null)
                if (isLeftСhild())
                    getParent().setLeft(this);
                else
                    getParent().setRight(this);
            if (getLeft() != null)
                getLeft().setParent(this);
            if (getRight() != null)
                getRight().setParent(this);
            fixBalanceFactor();
        }

        private int getBalanceFactor(){
            return balanceFactor;
        }

        public void fixBalanceFactor(){
            balanceFactor = getHeight(right)- getHeight(left);
        }

        public int compareTo(Node Node) {
            return this.key.compareTo((K) Node.getKey());
        }

        public int compareTo(K o) {
            return this.getKey().compareTo(o);
        }

        @Override
        public String toString() {
            return (this.key.toString());
        }
    }
}
