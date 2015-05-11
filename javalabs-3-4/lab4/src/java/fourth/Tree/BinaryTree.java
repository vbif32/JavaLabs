package fourth.Tree;

import labs.fourth.instrument.Tree;
import java.util.*;

/**
 * Created by Dartaan on 14.04.2015.
 */

public class BinaryTree<K extends Comparable<K>> implements Tree<K> {

    private int numberOfNodes = 0;
    protected Node root = null;
    protected Node deepestBalancedNode = null;
//    @Override
//    public Node insert(K var1) {
//
//        BinaryNode tmpNode = null;
//
//        if (root == null) // если элементов в дереве нет
//        {
//            BinaryNode newNode = new BinaryNode(var1); // то инициализируем новый элемент
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
//                        BinaryNode newNode = new BinaryNode(var1, tmpNode);	// то создаем новый элемент
//                        tmpNode.setLeft(newNode);
//                        return newNode;						// и успешно выходим из функции
//                    }
//                    else											// иначе спускаемся дальше
//                        tmpNode = (BinaryNode) tmpNode.getLeft();
//                }
//                else if (tmpNode.compareTo(var1) > 0)					// спускаемся в правое звено
//                {
//                    if (tmpNode.getRight() == null)						// если дерево кончилось
//                    {
//                        BinaryNode newNode = new BinaryNode(var1, tmpNode);   // то создаем новый элемент
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
    public Node insert(K var1) {
        Node newNode;
        if (root == null) {
            newNode = new BinaryNode(var1);
            root = newNode;
        } else
            newNode = insert(var1, root);
        numberOfNodes++;
        balance();
        return newNode;
    }

    @Override
    public Node delete(K var1) {
        if (root == null)
            return null;
        return delete(var1, root);
    }

    @Override
    public Node find(K var1) {
        if (root == null) {
            return null;
        } else
            return find(var1, root);
    }

    protected Node insert(K var1, Node root) {
        if (var1.compareTo((K) root.getKey()) < 0)                        // если рут больше вставляемого
            if (root.getLeft() != null)                              // и есть левый ребенок
                return insert(var1, root.getLeft());                    // идем в левое поддерево
            else {                                                 // иначе
                root.setLeft(new BinaryNode(var1, root));
                return root.getLeft();      // добавляем сюда элемент
            }
        else if (var1.compareTo((K) root.getKey()) > 0)                        // если рут меньше вставляемого
            if (root.getRight() != null)                             // и есть правый ребенок
                return insert(var1, root.getRight());                // идем в правое поддерево
            else {                                               // иначе
                root.setRight(new BinaryNode(var1, root));
                return root.getRight();      // добавляем сюда элемент
            }
        else                                                    // если равно
            return root;                                        // значит такой элемент уже есть
    }

    protected Node delete(K var1, Node root) {
        if (root == null)
            return null;
        if (var1.compareTo((K) root.getKey()) < 0)                                // если больше
            return delete(var1, root.getLeft());                    // идем в левое поддерево
        else if (var1.compareTo((K) root.getKey()) > 0)                            // если меньше
            return delete(var1, root.getRight());                    // идем в правое поддерево
        else if (var1.compareTo((K) root.getKey()) == 0) {                        // если равно

            if (root.getLeft() == root.getRight()) {                        // если дочерних элементов нет
                if (root.getParent() == null)
                    this.root = null;
                else if (root.getParent().getLeft() == root)
                    root.getParent().setLeft(null);
                else
                    root.getParent().setRight(null);
            } else if (root.getLeft() == null) {                    // нет левого доч. элемента

                if (root.getParent() == null) {
                    this.root = root.getRight();
                    root.getRight().setParent(null);
                } else if (root.getParent().getLeft() == root) {
                    root.getParent().setLeft(root.getRight());
                    root.getRight().setParent(root.getParent());
                } else {
                    root.getParent().setRight(root.getRight());
                    root.getRight().setParent(root.getParent());
                }
            } else if (root.getRight() == null) {                        // нет правого доч. элемента
                if (root.getParent() == null) {
                    this.root = root.getLeft();
                    root.getLeft().setParent(null);
                } else if (root.getParent().getLeft() == root) {
                    root.getParent().setLeft(root.getLeft());
                    root.getLeft().setParent(root.getParent());
                } else {
                    root.getParent().setRight(root.getLeft());
                    root.getLeft().setParent(root.getParent());
                }
            } else {                                                // есть оба доч. элемента
                if (root.getRight().getLeft() == null) {
                    root.getRight().setLeft(root.getLeft());
                    root.getLeft().setParent(root.getRight());
                    if (root.getParent() == null) {
                        this.root = root.getRight();

                        root.getLeft().setParent(root.getRight());
                        root.getRight().setLeft(root.getLeft());

                        root.getRight().setParent(null);
                    } else if (((BinaryNode)(root)).isLeftСhild()) {
                        root.getParent().setLeft(root.getRight());
                        root.getRight().setParent(root.getParent());
                    } else {
                        root.getParent().setRight(root.getRight());
                        root.getRight().setParent(root.getParent());
                    }
                } else {
                    Node tmp = findLeftmostNode(root.getRight());
                    tmp.setLeft(root.getLeft());
                    tmp.setRight(root.getRight());
                    tmp.setParent(root.getParent());
                    if (root.getParent() == null) {
                        this.root = tmp;
                    } else if (root.getParent().getLeft() == root) {
                        root.getParent().setLeft(tmp);
                        tmp.setParent(root.getParent());
                    } else {
                        root.getParent().setRight(tmp);
                        tmp.setParent(root.getParent());
                    }
                }
            }
            numberOfNodes--;
            balance();
            return root;
        }
        return null;
    }

    protected Node findLeftmostNode(Node root) { // вспомогательная функция для удаления
        if (root.getLeft() == null) {
            if (root.getRight() != null)
                root.getRight().setParent(root.getParent());
            if (root.getParent() != null)
                root.getParent().setLeft(root.getRight());
            root.setRight(null);
            return root;
        } else
            return findLeftmostNode(root.getLeft());
    }

    protected Node find(K var1, Node root) {
        if (root == null)
            return null;
        if (var1.compareTo((K) root.getKey()) < 0)                        // если меньше
            return find(var1, root.getLeft());                    // идем в левое поддерево
        else if (var1.compareTo((K) root.getKey()) > 0)                        // если больше
            return find(var1, root.getRight());                // идем в правое поддерево
        else                                                    // если равно
            return root;                                        // значит нашли
    }

    protected boolean balance() {
        if (allowedToBalance() && !check_balance()) {
            treeToVine(root);
            while (!check_balance()) {
                vineToBalancedTree(root);
            }
            deepestBalancedNode = null;
            return true;
        } else
            return false;
    }

    private boolean allowedToBalance() {
        for (int i = 0; i < numberOfNodes; i++) {
            if (numberOfNodes == Math.pow(2, i) - 1)
                return true;
        }
        return false;
    }

    private void treeToVine(Node root) {
        if (root.getRight() != null) {
            leftTurn(root);
            treeToVine(root.getParent());
        } else if (root.getLeft() != null) {
            treeToVine(root.getLeft());
        }
    }

    private void vineToBalancedTree(Node root) {
        if (root != null) {
            if (root.getLeft() != deepestBalancedNode) {
                rightTurn(root);
                vineToBalancedTree(root.getParent().getLeft());
            } else {
                deepestBalancedNode = root;
            }
        }
    }

    protected boolean check_balance() {
        return check_balance(this.root);
    }

    protected boolean check_balance(Node root) {
        if (root == null)
            return true;
        if (!check_balance(root.getLeft()))
            return false;
        if (!check_balance(root.getRight()))
            return false;
        int left = getHight(root.getLeft());
        int right = getHight(root.getRight());
        if (Math.abs(left - right) > 1)
            return false;
        return true;
    }

    protected int getHight(Node root) {
        if (root == null)
            return 0;
        int left = getHight(root.getLeft());
        int right = getHight(root.getRight());
        return Math.max(left, right) + 1;
    }

    protected void leftTurn(Node root) {
        if (root.getRight() != null) {
            if (root != this.root) {

                root.getParent().setLeft(root.getRight());
                root.getRight().setParent(root.getParent());

                root.setParent(root.getRight());
                root.setRight(root.getParent().getLeft());

                if (root.getRight() != null)
                    root.getRight().setParent(root);

                root.getParent().setLeft(root);
            } else {

                root.setParent(root.getRight());
                root.setRight(root.getParent().getLeft());
                if (root.getRight() != null)
                    root.getRight().setParent(root);

                root.getParent().setParent(null);
                root.getParent().setLeft(root);

                this.root = root.getParent();
            }
        }
    }

    protected void rightTurn(Node root) {
        if (root.getLeft() != null) {
            if (root != this.root) {
                root.getParent().setLeft(root.getLeft());
                root.getLeft().setParent(root.getParent());

                root.setParent(root.getLeft());
                root.setLeft(root.getParent().getRight());
                if (root.getLeft() != null)
                    root.getLeft().setParent(root);

                root.getParent().setRight(root);

            } else {

                root.setParent(root.getLeft());
                root.setLeft(root.getParent().getRight());
                if (root.getLeft() != null)
                    root.getLeft().setParent(root);

                root.getParent().setParent(null);
                root.getParent().setRight(root);

                this.root = root.getParent();
            }
        }
    }

    public Set returnKeys() {
        Set set = new HashSet();
        returnKeys(set, root);
        return set;
    }

    protected void returnKeys(Set set, Node root) {
        if (root == null)
            return;
        returnKeys(set, root.getRight());
        fourth.instruments.SortedMap.MapEntry tmp = (fourth.instruments.SortedMap.MapEntry) (root.getKey());
        set.add(tmp.getKey());
        returnKeys(set, root.getLeft());
    }

    public List returnValues() {
        List list = new ArrayList();
        returnValues(list, root);
        return list;
    }

    protected void returnValues(List list, Node root) {
        if (root == null)
            return;
        returnValues(list, root.getLeft());
        fourth.instruments.SortedMap.MapEntry tmp = (fourth.instruments.SortedMap.MapEntry) (root.getKey());
        list.add(tmp.getValue());
        returnValues(list, root.getRight());
    }


    public class BinaryNode<K extends Comparable<K>> implements Node<K> {

        protected K key;
        protected Node parent;
        protected Node left;
        protected Node right;

        public BinaryNode() {
            key = null;
            parent = null;
            left = null;
            right = null;
        }

        public BinaryNode(K var1) {
            key = var1;
            parent = null;
            left = null;
            right = null;
        }

        public BinaryNode(K var1, Node var2) {
            key = var1;
            parent = var2;
            left = null;
            right = null;
        }

        public BinaryNode(K var1, Node var2, Node var3) {
            key = var1;
            parent = var2;
            left = var3;
            right = null;
        }

        public BinaryNode(K var1, Node var2, Node var3, Node var4) {
            key = var1;
            parent = var2;
            left = var3;
            right = var4;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K var1) {
            key = var1;
        }

        @Override
        public Node getLeft() {
            return left;
        }

        @Override
        public void setLeft(Node node) {
            left = node;
        }

        @Override
        public Node getRight() {
            return right;
        }

        @Override
        public void setRight(Node node) {
            right = node;
        }

        @Override
        public Node getParent() {
            return parent;
        }

        @Override
        public void setParent(Node node) {
            parent = node;
        }

        protected boolean isLeftСhild() {
            if (parent == null)
                return false;
            if (parent.getLeft() == root)
                return true;
            else
                return false;
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

