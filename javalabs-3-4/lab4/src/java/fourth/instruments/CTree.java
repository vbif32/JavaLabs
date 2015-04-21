package fourth.instruments;

import labs.fourth.instrument.Tree;

import java.util.*;

/**
 * Created by Dartaan on 14.04.2015.
 */

public class CTree<K extends Comparable<K>> implements Tree {

    CNode root = null;

//    @Override
//    public Node insert(Comparable var1) {
//
//        CNode tmpNode = null;
//
//        if (root == null) // если элементов в дереве нет
//        {
//            CNode newNode = new CNode(var1); // то инициализируем новый элемент
//            root = newNode;                   // и делаем его корнем
//            return newNode;
//        }
//        else              // если в дереве уже есть элементы
//        {
//            tmpNode = root;// ставим указатель на начало
//            while (true)   // и проверяем элементы, пока не найдем подходящее место
//            {
//                if (tmpNode.compareTo(var1) < 0)							// спускаемся в левое звено
//                {
//                    if (tmpNode.getLeft() == null)						// если дерево кончилось
//                    {
//                        CNode newNode = new CNode(var1, tmpNode);	// то создаем новый элемент
//                        tmpNode.setLeft(newNode);
//                        return newNode;						// и успешно выходим из функции
//                    }
//                    else											// иначе спускаемся дальше
//                        tmpNode = (CNode) tmpNode.getLeft();
//                }
//                else if (tmpNode.compareTo(var1) > 0)					// спускаемся в правое звено
//                {
//                    if (tmpNode.getRight() == null)						// если дерево кончилось
//                    {
//                        CNode newNode = new CNode(var1, tmpNode);   // то создаем новый элемент
//                        tmpNode.setRight(newNode);
//                        return newNode;						// и успешно выходим из функции
//                    }
//                    else											// иначе спускаемся дальше
//                        tmpNode = tmpNode.getRight();
//                }
//                else				// если элементы оказались равно
//                    return null;	// с ошибкой выходим из функции
//            }
//        }
//    }

    @Override
    public Node insert(Comparable var1) {
        CNode newNode;
        if (root == null)
            root = newNode = new CNode(var1);
        else
            newNode = insert(var1, root);
        balance(newNode);
        return newNode;
    }

    @Override
    public Node delete(Comparable var1) {
        if (root == null)
            return null;
        return delete(var1, root);
    }

    @Override
    public Node find(Comparable var1) {
        if (root == null) {
            return null;
        }
        else
            return find(var1, root);
    }

    private CNode insert(Comparable var1, CNode root) {
        if (root == null)
            return null;
        if (root.compareTo(var1) < 0)   						// если меньше
            if (root.left != null)                              // и есть левый ребенок
                return insert(var1, root.left);			    	// идем в левое поддерево
            else                                                // иначе
                return root.left =  new CNode(var1, root);      // добавляем сюда элемент
        else if (root.compareTo(var1) > 0)						// если больше
            if (root.right != null)                             // и есть правый ребенок
                return insert(var1, root.right);				// идем в правое поддерево
            else                                                // иначе
                return root.right = new CNode(var1, root);      // добавляем сюда элемент
        else                                  					// если равно
            return root;                                        // значит такой элемент уже есть
    }

    private CNode delete(Comparable var1, CNode root) {
        if (root == null)
            return null;
        if (root.compareTo(var1) > 0)								// если больше
            return delete(var1, root.left);					// идем в левое поддерево
        else if (root.compareTo(var1) < 0)							// если меньше
            return delete(var1, root.right);					// идем в правое поддерево
        else if (root.compareTo(var1) == 0){      					// если равно

            if (root.left == root.right){						// если дочерних элементов нет
                if (root.parent == null)
                    this.root = null;
                else if (root.parent.left == root)
                    root.parent.left = null;
                else
                    root.parent.right = null;
            }
            else if (root.left == null)	{					// нет левого доч. элемента

                if (root.parent == null){
                    this.root = root.right;
                    root.right.parent = null;
                }
                else if (root.parent.left == root) {
                    root.parent.left = root.right;
                    root.right.parent = root.parent;
                }
                else {
                    root.parent.right = root.right;
                    root.right.parent = root.parent;
                }
            }
            else if (root.right == null){						// нет правого доч. элемента
                if (root.parent == null) {
                    this.root = root.left;
                    root.left.parent = null;
                }
                else if (root.parent.left == root){
                    root.parent.left = root.left;
                    root.left.parent = root.parent;
                }
                else {
                    root.parent.right = root.left;
                    root.left.parent = root.parent;
                }
            }
            else {												// есть оба доч. элемента
                if (root.right.left != null) {
                    if (root.parent == null) {
                        this.root = root.right;
                        root.right.parent = null;
                    }
                    else if (root.parent.left == root) {
                        root.parent.left = root.right;
                        root.right.parent = root.parent;
                    }
                    else {
                        root.parent.right = root.right;
                        root.right.parent = root.parent;
                    }
                }
                else {
                    if (root.parent == null) {
                        this.root = root.right;

                    }
                    else if (root.parent.left == root) {
                        CNode tmp = findLeftmostNode(root.right);
                        root.parent.left = tmp;
                        tmp.parent = root.parent;
                    }
                    else {
                        CNode tmp = findLeftmostNode(root.right);
                        root.parent.right = tmp;
                        tmp.parent = root.parent;
                    }
                }
            }
            balance(root);
            return root;
        }
        return null;
    }

    private Node find(Comparable var1, CNode root) {
        if (root == null)
            return null;
        if (root.compareTo(var1) < 0)   						// если меньше
            return insert(var1, root.left);			    	// идем в левое поддерево
        else if (root.compareTo(var1) > 0)						// если больше
            return insert(var1, root.right);				// идем в правое поддерево
        else                                  					// если равно
            return root;                                        // значит нашли
    }

    private CNode findLeftmostNode(CNode root){ // вспомогательная функция для удаления
        if (root.left == null) {
            root.right.parent = root.parent;
            if (root.parent != null)
                root.parent.left = root.right;
            root.right = null;
            return root;
        }
        else
            return findLeftmostNode(root.left);
    }

    private void balance(CNode node) {
            fixHeight(node);
            if (balanceFactor(node) == 2) {
                if (balanceFactor(node.right) < 0 )
                    rightTurn(node.right);
                leftTurn(node);
                return;
            }
            if (balanceFactor(node)== -2) {
                if (balanceFactor(node.left) > 0)
                    leftTurn(node.left);
                rightTurn(node);
                return;
            }
    }

    int balanceFactor(CNode node) {
        if (node.left == null && node.right == null)
            return 0;
        else if (node.left == null)
            return node.right.height ;
        else if (node.right == null)
            return node.left.height;
        else
            return node.right.height - node.left.height;
    }

    void fixHeight( CNode node) {
        if (node.left == null && node.right == null)
            node.height = 0;
        else if (node.left == null)
            node.height = (byte)(node.right.height + 1);
        else if (node.right == null)
            node.height = (byte)(node.left.height + 1);
        else
            node.height = (byte)(Math.max(node.left.height, node.right.height) + 1);
    }

    private void leftTurn(CNode root) {
        if (root.right != null) {
            if (root != this.root) {

                if (root.isLeftСhild())
                    root.parent.left = root.right;
                else
                    root.parent.right = root.right;

                root.right.parent = root.parent;
                root.parent = root.right;

                root.right = root.parent.left;
                if (root.right != null)
                    root.right.parent = root;

                root.parent.left = root;
            }
            else {
                root.parent = root.right;
                root.right = root.parent.left;
                if (root.right != null)
                    root.right.parent = root;

                root.parent.parent = null;
                root.parent.left = root;

                this.root = root.parent;
            }
        }
        fixHeight(root.left);
        fixHeight(root);
    }

    private void rightTurn(CNode root) {
        if (root.left != null) {
            if (root != this.root){
                if (root.isLeftСhild())
                    root.parent.left = root.left;
                else
                    root.parent.right = root.left;

                root.left.parent = root.parent;

                root.parent = root.left;

                root.left = root.parent.right;
                if (root.left != null)
                    root.left.parent = root;

                root.parent.right = root;
            }
            else {
                root.parent = root.left;
                root.left = root.parent.right;
                if (root.left != null)
                    root.left.parent = root;

                root.parent.parent = null;
                root.parent.right = root;

                this.root = root.parent;
            }
        }
        fixHeight(root.left);
        fixHeight(root);
    }

    public Set returnKeys(){
        Set set = new TreeSet();
        returnKeys(set, root);
        return set;
    }

    private void returnKeys(Set set, CNode root){
        if (root == null)
            return;
        returnKeys(set, root.left);
        SortedMap.MapEntry tmp = (SortedMap.MapEntry)(root.key);
        set.add(tmp.getKey());
        returnKeys(set, root.right);
    }

    public List returnValues(){
        List list = new ArrayList();
        returnValues(list, root);
        Collections.reverse(list);
        return list;
    }

    private void returnValues(List list, CNode root){
        if (root == null)
            return;
        returnValues(list, root.left);
        SortedMap.MapEntry tmp = (SortedMap.MapEntry)(root.key);
        list.add(tmp.getValue());
        returnValues(list, root.right);
    }


    public class CNode implements Node, Comparable<CNode> {

        private Comparable key;
        private CNode parent;
        private CNode left;
        private CNode right;
        private byte height;

        public CNode(){
            key = null;
            parent = null;
            left = null;
            right = null;
            height = 0;
        }

        public CNode(Comparable var1){
            key = var1;
            parent = null;
            left = null;
            right = null;
            height = 0;
        }

        public CNode(Comparable var1, CNode var2){
            key = var1;
            parent = var2;
            left = null;
            right = null;
            height = 0;
        }

        public CNode(Comparable var1, CNode var2, CNode var3){
            key = var1;
            parent = var2;
            left = var3;
            right = null;
            height = 0;
        }

        public CNode(Comparable var1, CNode var2, CNode var3, CNode var4){
            key = var1;
            parent = var2;
            left = var3;
            right = var4;
            height = 0;
        }

        @Override
        public Comparable getKey() {
            return key;
        }

        @Override
        public void setKey(Object var1) {
            key = (Comparable)(var1);
        }

        @Override
        public CNode getLeft() {
            return left;
        }

        @Override
        public void setLeft(Node node) {
            left = (CNode) node;
        }

        @Override
        public CNode getRight() {
            return right;
        }

        @Override
        public void setRight(Node node) {
            right = (CNode) node;
        }

        @Override
        public CNode getParent() {
            return parent;
        }

        @Override
        public void setParent(Node node) {
            parent = (CNode) node;
        }

        private boolean isLeftСhild(){
            if (parent == null)
                return false;
            if (parent.left == root)
                return true;
            else
                return false;
        }

        @Override
        public int compareTo(CNode Node) {
            return this.key.compareTo(Node.key);
        }

        public int compareTo(Comparable o) {
            return this.getKey().compareTo(o);
        }
    }
}

