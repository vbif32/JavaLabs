package fourth.Tree;


/**
 * Created by Dartaan on 07.05.2015.
 */
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
        balance();
        return newNode;
    }

    @Override
    public Node delete(K var1) {
        if (root == null)
            return null;
        return
                delete(var1, root);
    }

    @Override
    public Node find(K var1) {
        if (root == null) {
            return null;
        } else
            return super.find(var1, root);
    }

    protected boolean balance(Node node){
        return false;
    }

    public class AVLNode<K extends Comparable<K>> extends BinaryNode<K> {

        private int height;

        public AVLNode() {
            super();
            height = 0;
        }

        public AVLNode(Node node){
            super((K)node.getKey(), node.getLeft(), node.getRight(), node.getParent());
            height = 0;
        }

        public AVLNode(Node node, int var1){
            super((K)node.getKey(), node.getLeft(), node.getRight(), node.getParent());
            height = var1;
        }

        public AVLNode(K var1) {
            super(var1);
            height = 0;
        }

        public AVLNode(K var1, Node var2) {
            super(var1, var2);
            height = 0;
        }

        public AVLNode(K var1, Node var2, Node var3) {
            super(var1, var2, var3);
            height = 0;
        }

        public AVLNode(K var1, Node var2, Node var3, Node var4) {
            super(var1, var2, var3, var4);
            height = 0;
        }

        public AVLNode(K var1, Node var2, Node var3, Node var4, int var5) {
            super(var1, var2, var3, var4);
            height = var5;
        }

        public int getHeight(){
            return height;
        }

        protected void fixRelations(){
            if(getParent() != null)
                if (isLeft—hild())
                    getParent().setLeft(this);
                else
                    getParent().setRight(this);
            if (getLeft() != null)
                getLeft().setParent(this);
            if (getRight() != null)
                getRight().setParent(this);
        }

        public void setHeight(int var1){
            height = var1;
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
