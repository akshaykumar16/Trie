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
 * @author AKshay16
 */
public class Trie {
    
    private Node root;
    private int singleChild;
    public Trie()
    {
        this.root=new Node("");
    }
    
    public void insert(String key)
    {
        Node temp=this.root;
        int k=0;
         
           
           
        for(int i=0;i<key.length();++i)
        {
            
            char c=key.charAt(i);
            int ascii=c-'a';
            if(temp.getChild(ascii)==null)
            {
                Node node=new Node(String.valueOf(c));
                temp.setChild(ascii, node);
                temp=node;
            }
            else
            {
                temp=temp.getChild(ascii);
            }
        }
        temp.setLeaf(true);
        temp.setIdx(k);
            //System.out.println(temp.getIdx());
       
        
    }
    
    public boolean search(String key)
    {
        Node temp=this.root;
        for(int i=0;i<key.length();i++)
        {
            char c=key.charAt(i);
            int ascii=c-'a';
            if(temp.getChild(ascii)==null)
            {
                return false;
            }
            else
            {
                temp=temp.getChild(ascii);
            }
            
        }
        System.out.println(temp.getIdx());
        return true;
    }
    
    public int searchAsMap(String key)
    {
        Node temp=this.root;
        
        for(int i=0;i<key.length();++i)
        {
            char c=key.charAt(i);
            int ascii=c-'a';
            if(temp.getChild(ascii)==null)
            {
                return -1;
            }
            else
            {
                temp=temp.getChild(ascii);
            }
        }
        if(!temp.isLeaf())
        {
            return -1;
        }
        return temp.getVa();
    }
    
    public List<String> autoComplete(String key)
    {
        Node temp=this.root;
        List<String> x=new ArrayList<>();
        for(int i=0;i<key.length();++i)
        {
            char c=key.charAt(i);
            int ascii=c-'a';
            temp=temp.getChild(ascii);
        }
        collect(temp,key,x);
        return x;
    }

    private void collect(Node temp, String key, List<String> x) {
        if(temp==null)
        {
            return;
        }
        if(temp.isLeaf())
        {
            x.add(key);
        }
        else
        {
        
        for(Node child:temp.getChildren())
        {
            if(child==null) continue;
            String ch=child.getChara();
            collect(child,key+ch,x);
            
        }
        }
        
        
        
        
    }
    
    
    public List<String> shortestUnique()
    {
        Node temp=this.root;
        List<String> x=new ArrayList<>();
        for(Node child:temp.getChildren())
        {
            if(child!=null)
            {
                String p=child.getChara();
                String p1=child.getChara();
                collect1(child,p,p1,x);
            }
        }
        return x;
    }

    private void collect1(Node temp, String p,String p1, List<String> x) {
        int count=0;
       
        String ta="";
        Node opt=null;
        //p+=temp.getChara();
   
        for(Node child:temp.getChildren())
        {
            if(child!=null)
            {
                count=count+1;
            }
            if(count==1 && child!=null)
            {
               opt=child;
               ta+=opt.getChara();
   
               
            }
            if(count>1 && child!=null)
            {
                
                
                
                //System.out.println("p is"+p);
                if(count<=2)
                {
                  //p1="";
                 
                 collect1(opt,p+ta,p+ta,x);
                    
                }
                //p1="";
                collect1(child,p+child.getChara(),p+child.getChara(),x);
                
                
                
            }
        }
        if(count==1)
        {
            
            collect1(opt,p+ta,p1,x);
        }
        if(temp.isLeaf())
        {
            x.add(p1);
        }
    }
    
    public String longestCommonPrefix()
    {
        String lcp="";
        Node trieNode=this.root;
        while(countNoOfChild(trieNode)==1&& !trieNode.isLeaf())
        {
            trieNode=trieNode.getChild(singleChild);
            lcp=lcp+String.valueOf((char)(singleChild+'a'));
        }
        return lcp;
    }

    private int countNoOfChild(Node trieNode) {
        int idx=0;
        
        for(int i=0;i<trieNode.getChildren().length;i++)
        {
            if(trieNode.getChild(i)!=null)
            {
                idx++;
                singleChild=i;
            }
        }
        return idx;
    }
    
    
    
    
}
    
    
    