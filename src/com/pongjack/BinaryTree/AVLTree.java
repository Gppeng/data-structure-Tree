package com.pongjack.BinaryTree;

import java.util.HashSet;

/**
 * AVl树的原理：父节点的左子树和右子树的高度差不能超过【1】
 * 时间复杂度只是log(n)
 * 常见的旋转是左左旋转，右右旋转，左右旋转（左子树的右节点），右左旋转（右子树的左节点）
 * 性能是防止二叉查找树（B树）形成链表，导致时间复杂度变成O(n)
 * 但是与复杂度相同的红黑树的性能相比，较弱
 * @param <K>
 * @param <V>
 */
public class AVLTree<K extends Comparable<? super K>,V> {
    /**
     * 定义平衡二叉树
     */
        public K key;
        public V value;
        public int height;
        public AVLTree<K,V> left;
        public AVLTree<K,V> right;
    /**
     * 定义一个hashset用来存放
     * 重复添加的值，在删除中可以使用懒惰删除
     */
        HashSet<V> attach =new HashSet<>();
            public AVLTree() {
        }

        public AVLTree(K key) {
             this.key = key;
        }

        public AVLTree(K key, V value, AVLTree<K, V> left, AVLTree<K, V> right) {
            this.key = key;
            this.attach.add(value);
            this.left = left;
            this.right = right;
        }
        public AVLTree<K,V> tree;
    /**
     * 左左旋转
     */
        private AVLTree<K,V> LLRotate(AVLTree<K,V> tree){
            /**node是将要旋转为父节点，是当前节点的左子树**/
            AVLTree<K,V> node=tree.left;
            /**将node的右子树变为node的左子树**/
            tree.left = node.right;
            /**将node的右节点变成当前节点**/
            node.right = tree;
            /**重新两个节点树高**/
            tree.height = Math.max(Height(tree.left),Height(tree.right))+1;
            node.height=Math.max(Height(node.left),Height(node.right))+1;
            /**返回新的节点**/
            return node;
        }

        private int Height(AVLTree<K, V> right) {
            return right==null?0:right.height;
        }
    /**
     * 右右旋转（和左左旋转如出一辙）
     */
        private AVLTree<K,V> RRRotate(AVLTree<K,V> tree){
            AVLTree<K,V> node = tree.right;
            tree.right = node.left;
            node.left =tree;
            tree.height = Math.max(Height(tree.left),Height(tree.right))+1;
            node.height = Math.max(Height(tree.left),Height(tree.right))+1;
            return node;
        }
    /**
     * 左右旋转
     * 先将需要旋转的当前节点的左节点右右旋转
     * 然后在将当前节点左左旋转
     */
        private AVLTree<K,V> LRRotate(AVLTree<K,V> tree){
            /**
             * 先进行当前冲突的节点左节点右右旋转
             */
            tree.left = RRRotate(tree.left);
            /**
             * 然后进行左左旋转
             */
            return LLRotate(tree);
        }
    /**
     * 右左旋转
     * 先进行左左旋转（当前节点的右节点）
     */
        private AVLTree<K,V> RLRotate(AVLTree<K,V> tree){
            tree.right = LLRotate(tree.right);

            return RRRotate(tree);
        }
    /**
     * 添加数据如平衡二叉树AVL
     */
        public void add(){
            if(add(key,value,tree)!=null){
                System.out.println( "添加数据成功" );
            }else{
                System.out.println( "添加数据失败，请重试！" );
            }
        }
        private AVLTree<K,V> add(K key,V value,AVLTree<K,V> tree){
            if(tree==null){
                return new AVLTree<K,V>(key,value,null,null);
            }else if(tree.left!=null&&key.compareTo(tree.key)<0){
                tree.add(key,value,tree.left);
                if(Height(tree.left)-Height(tree.right)==2){
                    if(key.compareTo(tree.left.key)<0){
                        tree = LLRotate(tree);
                    }else {
                        tree = LRRotate(tree);
                    }
                }
            }else if(tree.right!=null&&key.compareTo(tree.key)>0){
                tree.add(key, value, tree.right);
                if(Height(tree.right)-Height(tree.left)==2){
                    if(key.compareTo(tree.right.key)>0){
                        tree = RRRotate(tree);
                    }else {
                        tree = RLRotate(tree);
                    }
                }
            }else if(tree!=null&&key.compareTo(tree.key)==0){
                this.attach.add(value);
            }
            tree.height = Math.max(Height(tree.left),Height(tree.right))+1;
            return tree;
        }
    /**
     * 删除数据和添加数据基本一致，就是附加值要判断一下，其他一些都一样和二叉查找树
     */
        public AVLTree<K,V> remove(K key,V value){
            AVLTree<K,V> tem;
            tem = remove(key,value,tree);
            return tem;
        }
        private AVLTree<K,V> remove(K key,V value,AVLTree<K,V> tree1){
            if(tree1 == null){
                return null;
            }else if(key.compareTo(tree1.key)<0){
                tree1.left = remove(key,value,tree1.left);
                    if(Height(tree1.left)-Height(tree1.right)==2){
                        if(key.compareTo(tree1.left.key)<0){
                            tree1=LLRotate(tree1);
                        }else{
                            tree1 = LRRotate(tree1);
                        }
                    }
            }else if(key.compareTo(tree1.key)>0){
                tree1.right = remove(key,value,tree1.right);
                if(Height(tree1.right)-Height(tree1.left)==2){
                    if(key.compareTo(tree1.right.key)>0){
                        tree1=RRRotate(tree1);
                    }else {
                        tree1 =RLRotate(tree1);
                    }
                }
            }else if(key.compareTo(tree1.key)==0) {
                if(tree1.attach.size()>1){
                   remove(key,value);
                }
                else if (tree1.right != null || tree1.left != null) {
                    tree1.key = findMin(tree1).key;
                    tree1.right = remove(key,value,tree1.right);
                }else {
                    tree1 = (tree1.right==null)?tree1.left:tree1.right;
                }
            }
            tree1.height = Math.max(Height(tree1.left),Height(tree1.right))+1;
            return tree1;
        }

        private AVLTree<K,V> findMin( AVLTree<K, V> tree1) {
            if(tree1==null){
                return null;
            }else if(tree1.left!=null){
                return findMin(tree1.left);
            }else return tree1;
        }
}
