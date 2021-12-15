/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Personal
 * @param <T>
 */
public class BinaryTree{
    private BinaryNode root;

    public BinaryTree() {
        this.root = new BinaryNode();
    }
    
    public BinaryTree(BinaryNode root) {
        this.root = root;
    }

    public BinaryTree (HuffmanInfo content) {
        this.root = new BinaryNode(content);
    }

    public BinaryNode getRoot() {
        return root;
    }
    
    public HuffmanInfo gethInfo() {
        return root.getContent();
    }


    
    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    public void setLeft(BinaryTree tree) {
        this.root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        this.root.setRight(tree);
    }

    public BinaryTree getLeft() {
        return this.root.getLeft();
    }

    public BinaryTree getRight() {
        return this.root.getRight();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isLeaf() {
        return this.root.getLeft() == null && this.root.getRight() == null;
    }

    public int countLeavesRecursive() {
        if (this.isEmpty()) {
            return 0;
        } else if (this.isLeaf()) {
            return 1;
        } else {
            int leavesLeft = 0;
            int leavesRight = 0;
            if (this.root.getLeft() != null) {
                leavesLeft = this.root.getLeft().countLeavesRecursive();
            }
            if (this.root.getRight() != null) {
                leavesRight = this.root.getRight().countLeavesRecursive();
            }
            return leavesLeft + leavesRight;
        }
    }

   
    /*Pregunta 1*/
    
    public static Map<String,Integer> getFrequencies(String cadena){
        if(cadena.isEmpty()){
            return null;
        }else{
            String[] valores = cadena.split("");
            Map<String,Integer> dic = new HashMap<>();
            for(String caracter: valores){
                if(dic.get(caracter)==null){
                    dic.put(caracter,1);
                }else{
                    int frecuencia = dic.get(caracter)+1;
                    dic.remove(caracter);
                    dic.put(caracter,frecuencia);
                }
            }
            return dic;
        }
    }
    
    /*Pregunta 2*/

    public BinaryTree buildHuffmanTree(Map<String,Integer> dic){
        if(dic==null){
            return null;
        }else{
            PriorityQueue<BinaryTree> cola = new PriorityQueue<>(
                    (r1,r2)->{
                        return r2.getRoot().getContent().getFrecuencia() 
                                - r1.getRoot().getContent().getFrecuencia() ;});
            //Recorremos el diccionario 
            Set<String> keyset = dic.keySet();
            Iterator<String> iterator =  keyset.iterator();
            while(iterator.hasNext()){
                String key = iterator.next();
                Integer value = dic.get(key);
                HuffmanInfo hf = new HuffmanInfo(key,value);
                BinaryTree bt = new BinaryTree(hf);
                cola.offer(bt);
            }
            
            while(cola.size()>=2){
                BinaryTree tree1 = cola.poll();
                BinaryTree tree2 = cola.poll();
                HuffmanInfo huffman = new HuffmanInfo(
                        tree1.getRoot().getContent().getSimbolo()+
                                tree2.getRoot().getContent().getSimbolo()
                        ,tree1.getRoot().getContent().getFrecuencia()+
                                tree2.getRoot().getContent().getFrecuencia());
                BinaryTree arbol = new BinaryTree(huffman);
                arbol.getRoot().setLeft(tree1);
                tree1.getRoot().getContent().setBit(0);
                arbol.getRoot().setRight(tree2);
                tree2.getRoot().getContent().setBit(1);
                cola.offer(arbol);
            }
            return cola.poll();
        }
    }
    /*Pregunta 3*/
    
    public void getHuffmanCodes(Map<String,Integer> mapaPrincipal,
            List<Character> lista,Map<Character,String> dic1,
            Map<String,Character> dic2, BinaryTree TreeHuffman){
        if(mapaPrincipal==null ||lista==null || dic1==null || dic2 ==null ){
            
        }else{
            Stack<BinaryTree> stack = new Stack<>();
            if(TreeHuffman.getLeft()!=null){
                stack.push(TreeHuffman.getLeft());
            }
            if(TreeHuffman.getRight()!=null){
                stack.push(TreeHuffman.getRight());
            }
            for(Character caracter: lista){
                String codigo = "";
                while(!stack.isEmpty()){
                    BinaryTree t = stack.pop();
                    if(t.getRoot().getContent().getSimbolo().compareTo(caracter.toString())==0){
                        codigo = codigo +t.getRoot().getContent().getBit();
                        dic1.put(caracter, codigo);
                        dic2.put(codigo, caracter);
                        break;
                    }else{
                        String[] listCaracteres = t.getRoot().getContent().getSimbolo().split("");
                        for(String elem:listCaracteres ){
                            if(caracter.toString().compareTo(elem)==0){
                                codigo = codigo +t.getRoot().getContent().getBit();
                                if(t.getLeft()!=null){
                                    stack.push(t.getLeft());
                                }if(t.getRight()!=null){
                                    stack.push(t.getRight());
                                }
                            }
                        }
                    }
                }
            }  
        }
    }
    
    /*Pregunta 4*/
    
    public String encode(String caracteres,Map<Character,String> dic1 ){
        if(caracteres==null || dic1==null){
            return null;
        }else{
            String[] cadenachar = caracteres.split("");
            String codigoSalida ="";
            for(String elem: cadenachar){
                Set<Character> keydic = dic1.keySet();
                Iterator<Character> iterator = keydic.iterator();
                while(iterator.hasNext()){
                    Character key = iterator.next();
                    String codigo = dic1.get(key);
                    if(elem.compareTo(key.toString())==0){
                        codigoSalida = codigoSalida + codigo;
                        break;
                    }
                }   
            }
            return codigoSalida;
        }
    }
}
