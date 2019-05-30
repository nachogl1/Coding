/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refreshing_project;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class Refreshing_Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BinarySortedTree BST = new BinarySortedTree();
        BST.addNode(30, "Pepe");
        BST.addNode(33, "Maria");
        BST.addNode(15, "Gon");
        BST.addNode(35, "Nacho");
        BST.addNode(32, "Nach2");
        BST.addNode(20, "Carmen");
        BST.addNode(18, "Jose");
        BST.addNode(10, "Celia");
        BST.addNode(10, "Celia2");
        BST.inOrderTraversing(BST.root);
        System.out.println("CHANGE TRAVERSING ALGORITHM");
        BST.preOrderTraversing(BST.root);
        System.out.println("CHANGE TRAVERSING ALGORITHM");
        BST.postOrderTraversing(BST.root);
        System.out.println("Search");
        System.out.println(BST.findNode(180));
    }
    
}
