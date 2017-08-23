package com.pongjack.BinaryTree;

public class Btree<T extends  Comparable<? super T>> {
    /**
     * 构建二叉树搜索树
     * @param <T>
     */
    static class BinaryTreeSearch<T>{
        BinaryTreeSearch<T> node;
        BinaryTreeSearch<T> left;
        BinaryTreeSearch<T>  right;
        T data;
        public BinaryTreeSearch() {
            data=null;
            this.left = left;
            this.right = right;
        }

        public BinaryTreeSearch(T data) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public BinaryTreeSearch(BinaryTreeSearch<T> left, BinaryTreeSearch<T> right, T data) {
            this.left = left;
            this.right = right;
            this.data = data;

        }

    }
    private BinaryTreeSearch<T> treeRoot ;

    private Boolean isEmpty(){
        return treeRoot == null;
    }

    public Btree() {

    }

    public Btree(BinaryTreeSearch<T> treeRoot) {
        this.treeRoot = treeRoot;
    }
    public void remove(T t){
        treeRoot = delete(t,treeRoot);
    }
    private void clear(){
        if(isEmpty()){
            System.out.println( "二叉搜索树已经被清除干净！");
        }
        else{
            System.out.println( "二叉树清除失败，请重试" );
        }
    }
    public T search(T t,BinaryTreeSearch<T> node){
        if(node ==null){
            System.out.println( "节点为空，没有该数据，请重试！" );
            return null;
        }else if(t.compareTo(node.data)<0){
            return search(t,node.left);
        }else if(t.compareTo(node.data)>0){
            return search(t,node.right);
        }
        return t;
    }
    public BinaryTreeSearch<T> insert(T t,BinaryTreeSearch<T> newnode){
        if(newnode ==null){
            return new BinaryTreeSearch(null,null,t);
        }
        if(t.compareTo(newnode.data)<0){
            newnode.left = insert(t,newnode.left);
        }
        if(t.compareTo(newnode.data)>0){
            newnode.right = insert(t,newnode.right);
        }
        else ;
        return newnode;
    }
    public BinaryTreeSearch<T> delete(T t,BinaryTreeSearch<T> node){
        if(node == null){
            return node;
        }
        if(t.compareTo(node.data)<0){
            node.left = delete(t,node.left);
        }
        if(t.compareTo(node.data)>0){
            node.right = delete(t,node.right);
        }
        else if(node.right!=null && node.left !=null){
            node.data = findMin(node.right) .data;
            node.right= delete(node.data,node.right);
        }
        else node=(node.left!=null)?node.left:node.right;
        return node;
    }
    public BinaryTreeSearch<T> findMin(BinaryTreeSearch<T> node){
        if(node == null){
            return  null;
        }
        if(node.left ==null){
            return node;
        }
        return findMin(node.left);
    }
    public BinaryTreeSearch<Integer> init(){
        BinaryTreeSearch<Integer> node1=new BinaryTreeSearch<>(3);
        BinaryTreeSearch<Integer> node2=new BinaryTreeSearch<>(1);
        BinaryTreeSearch<Integer> node3=new BinaryTreeSearch<>(node1,null,4);
        BinaryTreeSearch<Integer> node4=new BinaryTreeSearch<>(node1,node2,2);
        BinaryTreeSearch<Integer> node5=new BinaryTreeSearch<>(8);
        BinaryTreeSearch<Integer> root=new BinaryTreeSearch<>(node4,node5,6);
        return root;
    }
    public void preOrder(BinaryTreeSearch node){
        if(node!=null){
            System.out.print(node.data + " ");
        }
        if(node.left!=null)
        preOrder(node.left);
        if(node.right!=null)
        preOrder(node.right);
    }
    public void MidOrder(BinaryTreeSearch node){
        if(node!=null){
            if(node.left!=null){
                MidOrder(node.left);
            }
            System.out.print( node.data+ "  " );
            if(node.right!=null){
                MidOrder(node.right);
            }
        }
    }
    public static void main(String[] args){
        Btree btree=new Btree();
        BinaryTreeSearch<Integer> search=btree.init();
        btree.treeRoot =search;
        btree.MidOrder(btree.treeRoot);
        btree.remove(4);
        btree.preOrder(btree.treeRoot);
    }
}
