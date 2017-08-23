package com.pongjack.BinaryTree;

import java.util.Arrays;
import java.util.Stack;

/**
 * 深度优先搜索
 * 分别实现递归，非递归的前中后序遍历
 * @param <E>
 */
public  class ForEachBinaryTree<E> {


    public Node<E> initTree(String s) {
        char[] a= s.toCharArray();
        Node<E>[] node=new Node[s.length()];
        for(int i=0;i<s.length();i++){
            if(i<s.length()/2)
            node[i]=new Node(null,null,a[i]);
            else
                node[i] = new Node(Math.random(),Math.random(),a[i]);
        }
        return node[s.length()-1];
    }
    public void preOrder(Node<E> root) {
        this.printNode(root);
        if(root.leftChild!=null){
            this.preOrder(root.leftChild);
        }
        if(root.rightChild!=null){
            this.preOrder(root.rightChild);
        }
    }


    public void centerOrder(Node<E> root) {
        if(root.leftChild!=null){
            this.centerOrder(root.leftChild);
        }
        this.printNode(root);
        if(root.rightChild!=null){
            this.centerOrder(root.rightChild);
        }

    }
    public void lastOrder(Node<E> root) {
        if(root.leftChild!=null){
            this.lastOrder(root.leftChild);
        }
        if(root.rightChild!=null){
            this.lastOrder(root.rightChild);
        }
        this.printNode(root);
    }

    /**
     * 非递归实现二叉树遍历（深度优先遍历）
     * 采用栈的方式
     */
    /**
     * 前序遍历（非递归）
     * @param node
     */
    public void pre(Node<E> node) {
        Stack<Node> stack = new Stack<>();
        if(node!=null){
            stack.push(node);
        }
        while (!stack.isEmpty()){
                node=stack.pop();
            printNode(node);
            if(node.getRightChild()!=null){
                stack.push(node.rightChild);
            }
            if(node.getLeftChild()!=null)
                stack.push(node.leftChild);
        }
    }

    /**
     * 中序遍历（非递归）
     */
    public void center(Node<E> node) {
        Stack<Node> stack = new Stack<>();
        while(node!=null||!stack.isEmpty()){
            while(node.getRightChild()!=null){
                stack.push(node.getRightChild());
                node = node.getRightChild();
            }

            stack.push(node);
            while(node!=null&&node.getLeftChild()!=null){
                stack.push(node.getLeftChild());
                node=node.getLeftChild();
            }
            if(node!=null){
                node = stack.pop();
                printNode(node);
            }
        }
    }

    /**
     * 后序遍历（非递归）
     */
    public void last(Node<E> node) {
        Stack<Node> stack = new Stack<>();
        while(node!=null&&!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
            }
            while(node.getRightChild()!=null){
                stack.push(node.getRightChild());
                node = node.getRightChild();
            }
            while(node.getLeftChild()!=null){
                stack.push(node.getRightChild());
                node = node.getLeftChild();
            }
            while(node!=null){
                stack.pop();
            }
        }
    }
    private void printNode(Node<E> node){
        if(node!=null){
            System.out.print( node.getE()+" " );
        }
    }

    /**
     * @param <E>
     */
    static class Node<E>{
        private Node<E> leftChild ;
        private Node<E> rightChild ;
        private E e;

        public Node(double random, double v, int i) {
        }

        public Node(Node<E> leftChild, Node<E> rightChild, E e) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.e = e;
        }

        public Node<E> getLeftChild() {
            return leftChild;
        }

        public Node<E> getRightChild() {
            return rightChild;
        }

        public E getE() {
            return e;
        }

        public void setLeftChild(Node<E> leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node<E> rightChild) {
            this.rightChild = rightChild;
        }

        public void setE(E e) {
            this.e = e;
        }
    }
    public static void main(String[] args){
        String s="1234";
        ForEachBinaryTree forEachBinaryTree=new ForEachBinaryTree();
        Node root = forEachBinaryTree.initTree(s);
       // forEachBinaryTree.preOrder(root);
        forEachBinaryTree.lastOrder(root);
    }
}
