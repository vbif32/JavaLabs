package fourth.task;

import labs.fourth.instrument.Tree;

/**
 * Created by Dartaan on 14.04.2015.
 */
public class CTree implements Tree {

    @Override
    public Node insert(Comparable var1) {
        return null;
    }

    @Override
    public Node find(Comparable va1) {
        return null;
    }

    @Override
    public Node delete(Comparable var1) {
        return null;
    }

    public class CNode implements Node {

        private Comparable key;
        private Comparable value;
        private Node left;
        private Node right;
        private Node parent;

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Node getLeft() {
            return left;
        }

        @Override
        public Node getRight() {
            return right;
        }

        @Override
        public Node getParent() {
            return parent;
        }

        @Override
        public void setKey(Object o) {
            key = (Comparable) o;
        }

        @Override
        public void setLeft(Node node) {
            left = node;
        }

        @Override
        public void setRight(Node node) {
            right = node;
        }

        @Override
        public void setParent(Node node) {
            parent = node;
        }
    }
}
