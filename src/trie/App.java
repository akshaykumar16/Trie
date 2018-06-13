/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Akshay16
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Trie trie=new Trie();
        trie.insert("geeksforgeeks");
        trie.insert("geeksqor");
        trie.insert("geeksk");
        
       
        
        
       List<String> p=trie.shortestUnique();
       
       for(String i:p)
       {
           System.out.println(i);
       }
      
       
        System.out.println(trie.longestCommonPrefix());
    }
    
}
