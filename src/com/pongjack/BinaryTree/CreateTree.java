package com.pongjack.BinaryTree;

public interface CreateTree<E> {
    ForEachBinaryTree.Node initTree(String s);
    void   preOrder(ForEachBinaryTree.Node Root);
    void   centerOrder(ForEachBinaryTree.Node root);
    void   lastOrder(ForEachBinaryTree.Node root);
    void   pre(ForEachBinaryTree.Node root);
    void   center(ForEachBinaryTree.Node root);
    void   last(ForEachBinaryTree.Node root);
}
