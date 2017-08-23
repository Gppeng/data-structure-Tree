package com.pongjack.BinaryTree;

import java.util.HashSet;

public class BinarySearchTree<K extends Comparable<? super K>,V>{
    public K key;
    HashSet<V> attach=new HashSet<>();


    public BinarySearchTree(K key, Object o, Object o1) {

    }
    public BinarySearchTree<K,V> node;
    public BinarySearchTree<K,V> left;
    public BinarySearchTree<K,V> right;

    public BinarySearchTree(K key, V value, BinarySearchTree<K, V> left, BinarySearchTree<K, V> right) {
        this.key = key;
        this.attach.add(value);
        this.left = left;
        this.right = right;
    }
    /**
     * 添加二叉树元素
     */
    public void Add(K key,V value){
        node=Add(key,value,node);
    }

    private BinarySearchTree<K,V> Add(K key, V value, BinarySearchTree<K, V> node) {

        if (node == null) {
            node = new BinarySearchTree<>(key, value, null, null);
        }
        if ((node != null) && (key.compareTo(node.key)) < 0) {
            node = Add(key, value, node.left);
        }
        if ((node != null) && key.compareTo(node.key) > 0) {
            node = Add(key, value, node.right);
        }
        return node;
    }
    private BinarySearchTree findMin(K key,BinarySearchTree<K,V> node){
        if(node == null){
            return null;
        }else if(key.compareTo(node.key)<0){
            node.left=findMin(key,node.left);
        }
        return node;
    }
    public BinarySearchTree search(K key){
        BinarySearchTree<K,V> nod1;
        nod1 =search(key,node);
        return nod1;
    }
    private BinarySearchTree<K,V> search(K key,BinarySearchTree<K,V> node){
        if(node==null){
            return null;
        }else if(node.left!=null&&key.compareTo(node.key)<0){
            node.left=search(key,node.left);
        }else if(node.right!=null&&key.compareTo(node.key)>0){
            node.right = search(key,node.right);
        }else if(key.compareTo(node.key)==0){
            return node;
        }
        return node;
    }
    public Boolean insert(K key, V value){
        BinarySearchTree<K,V> nod1;
        nod1=insert(key,value,node);
        if(nod1!=null){
            return true;
        }else {
            return false;
        }
    }
    private BinarySearchTree<K,V> insert(K key,V value,BinarySearchTree<K,V> node){
        if(node==null){
            return new BinarySearchTree(key,value,null,null);
        }else if(node.left!=null&&key.compareTo(node.key)<0){
            node.left=insert(key,value,node.left);
        }else if(node.right!=null&&key.compareTo(node.key)>0){
            node.right=insert(key,value,node.right);
        }else if(node!=null&&key.compareTo(node.key)==0){
            this.attach.add(value);
        }
        return node;
    }
    public Boolean deleteNode(K key,V value){
        BinarySearchTree<K,V> nod1;
        nod1=deleteNode(key,value,node);
        if(nod1!=null){
            return true;
        }
        return false;
    }
    private BinarySearchTree<K,V> deleteNode(K key,V value,BinarySearchTree<K,V> node){
        if(node==null){
            return null;
        }else if((node.left != null) && (key.compareTo(node.key) < 0)){
            node = deleteNode(key,value,node.left);
        }else if(node.right!=null&&key.compareTo(node.key)>0){
            node = deleteNode(key,value,node.right);
        }else if(node!=null&&key.compareTo(node.key)==0){
            //实现惰性删除（存在重复数据就删除其中一个数据）
            if(node.attach.size()>1){
                this.attach.remove(value);

            } else if(node.left!=null&&node.right!=null){
                /**
                 * 当左右节点都不为空的时候
                 * 通常的做法就是利用右节点的最小的数来顶替
                 * 然后递归删除节点
                 */
                node.key = (K) findMin(key,node.right).key;
                node.right = deleteNode(node.key,value,node);
                /**
                 *
                 */

            }else {
                node=(node.right!=null)?node.right:node.left;
            }
        }
        return node;
    }

}
