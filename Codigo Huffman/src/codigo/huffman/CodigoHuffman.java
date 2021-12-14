/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.huffman;

import static Arbol.BinaryTree.getFrequencies;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Personal
 */
public class CodigoHuffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Map<String,Integer> map = getFrequencies("ABACCDA");
        Set<String> keyset = map.keySet();
        Iterator<String> iterator =  keyset.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            Integer value = map.get(key);
            System.out.println(key + "  :  "+value);
        }
        
        
    }
    
}
