/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author Personal
 */
public class BinaryNode  {
    private HuffmanInfo hInfo;
    private BinaryTree left;
    private BinaryTree right;
    
    public BinaryNode() {
        this(null, null, null);
    }

    public BinaryNode( HuffmanInfo hInfo) {
        this(hInfo, null, null);
    }

    public BinaryNode( HuffmanInfo hInfo, BinaryTree left, BinaryTree right) {
        this.hInfo = hInfo;
        this.left = left;
        this.right = right;
    }

    public HuffmanInfo getContent() {
        return hInfo;
    }

    public void setContent(HuffmanInfo content) {
        this.hInfo = content;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }
    
}
