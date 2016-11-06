//Josué Alexis Ramírez Pérez 513622 4º Semestre
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author josuealexis96
 */
public class BinarioArbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        BinaryTree b = new BinaryTree();
        System.out.println("");
        b.insert(5);
        b.insert(10);
        b.insert(3);
        b.insert(4);
        b.insert(15);
        b.insert(40);
        b.insert(2);
        System.out.println("Ordenamiento InOrden");
        b.inorden(b.getRoot());
        System.out.println("");
        System.out.println("");
        System.out.println("Ordenamiento PostOrden");
        b.postorden(b.getRoot());
        System.out.println("");
        System.out.println("");
        System.out.println("Ordenamiento PreOrden");
        b.preorden(b.getRoot());
        System.out.println("");
        System.out.println("");
        //System.out.println("La altura del arbol es " + b.getHeight());
        System.out.println("El número de elementos que tiene el arbol es de " + b.getElements());
        System.out.println("");
        b.eNode(40);
        System.out.println("");
        System.out.println("");
        System.out.println("Se elimino un número");
        System.out.println("");
        System.out.println("Ordenamiento InOrden");
        b.inorden(b.getRoot());
        System.out.println("");
        System.out.println("");
        System.out.println("Ordenamiento PostOrden");
        b.postorden(b.getRoot());
        System.out.println("");
        System.out.println("");
        System.out.println("Ordenamiento PreOrden");
        b.preorden(b.getRoot());
        System.out.println("");
        System.out.println("");
        b.eNode(2);
        System.out.println("");
        System.out.println("Se elimino un número");
        System.out.println("");
        System.out.println("Ordenamiento InOrden");
        b.inorden(b.getRoot());
        System.out.println("");
        System.out.println("");
        System.out.println("Ordenamiento PostOrden");
        b.postorden(b.getRoot());
        System.out.println("");
        System.out.println("");
        System.out.println("Ordenamiento PreOrden");
        b.preorden(b.getRoot());
        System.out.println("");
        System.out.println("");
                
    }
}
