/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

/**
 *
 * @author Akshay16
 */
public class Node {
    private String chara;
    private int va;
    private Node[] children;
    private boolean leaf;
    private boolean visited;
    private int idx;

    public int getIdx() {
        return idx;
    }

    public int getVa() {
        return va;
    }

    public void setVa(int va) {
        this.va = va;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
    
    public Node(String chara)
    {
        this.chara=chara;
        this.children=new Node[26];
    }
    public void setChild(int index,Node node)
    {
        //node.setVa(va);
        this.children[index]=node;
    }
    public Node getChild(int index)
    {
        return this.children[index];
    }

    public String getChara() {
        return chara;
    }

    public void setChara(String chara) {
        this.chara = chara;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    
}
