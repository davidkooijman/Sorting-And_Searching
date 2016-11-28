package com.hva.assignments.advancedsorting.sort;

import java.util.ArrayList;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;
    private int rankCounter = 0;

    private class Node {

        private Key key;
        private Value val;
        private Node left, right, identical;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public ArrayList<Value> get(Key key) {
        ArrayList<Value> studentnumbers = new ArrayList();
        return get(root, key, studentnumbers);
    }

    private ArrayList<Value> get(Node x, Key key, ArrayList<Value> studentnumbers) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key, studentnumbers);
        } else if (cmp > 0) {
            return get(x.right, key, studentnumbers);
        } else {
            studentnumbers.add(x.val);
            while (x.identical != null) {
                x = x.identical;
                studentnumbers.add(x.val);
            }
            return studentnumbers;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.identical = put(x.identical, key, x.val);
            x.val = val;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public int rank(Key grade) {
        this.rankCounter = 0;
        int count = rank(root, grade);
        return count;
    }

    public int rank(Node root, Key grade) {
        if (root.key.compareTo(grade) < 0) {
            this.rankCounter++; // Lager cijfer gevonden
        }

        if (root.left != null) {
            rank(root.left, grade);
        }
        if (root.right != null) {
            rank(root.right, grade);
        }

        if (root.identical != null) {
            rank(root.identical, grade);
        }

        return this.rankCounter;
    }
}