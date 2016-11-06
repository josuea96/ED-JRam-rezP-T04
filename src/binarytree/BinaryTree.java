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
public class BinaryTree {
    
    NodeTree root;
    int height;
    int elements;
    
    /**
     * Constuctor
     */
    public BinaryTree () {
        this.root = null;
        this.height = -1;
        this.elements = 0;
    }
    
    
    public BinaryTree (int data) {
        this.root = new NodeTree(data);
    }
    
    public BinaryTree (NodeTree root){
        this.root = root;
    }
    
    public NodeTree getRoot() {
        return root;
    }
    public int getHeight() {
        return height;
    }
    
    public int getElements() {
        return this.elements;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public boolean isEmpty(NodeTree root){
        return root.left == null && root.right == null;
    }
    
    NodeTree node = new NodeTree();
    
    /**
     * Método para insertar elementos en el arbol binario
     * @param data 
     */
    public void insert(int data){
        node = new NodeTree(data);
        if(isEmpty()) {
            root = node;//Se coloca en la parte de la raiz el nodo que se creo
            this.elements++;//Se suma elementos + 1 ya que se agrego uno mientras
            //el arbol se encontraba vacio
        } else {
            this.insert(node, this.root);//Utilizamos recursividad para insertar
            //el nodo en el lugar indicado
            this.elements++;//Se van aumentando la cantidad de elementos ya que
            //se desplegara su respectiva cantidad
        }
    }
    
    /**
     * 
     * @param node
     * @param root 
     */
    public void insert(NodeTree node, NodeTree root){
        if(node.data == root.data) {//Si el dato que se ingreso anteriormente es el mismo que
            //la raíz, el dato no se insertara en el nodo
            System.out.println("Ingresa otro número que no este repetido");
        } else if(node.data < root.data) {//Se verifica en un ciclo si el dato dado
            //es menor que el número que se encuentra en la raíz
            if(root.left == null) {//Como es menor tiene que ser implementado en la derecha de
                //la raíz, y si la derecha de la raíz es igual a null
                root.left = node;//en donde se esta el null se va a colocar el nodo
            } else {
                insert(node, root.left);
            }
        } else {//Si el ciclo anterior no se cumple, es porque el dato es mayor y se
            //colocara en la derecha de la raiz
            if(root.right == null){
                root.right = node;
            } else {
                insert(node, root.right);
            }
        }
    }
    
    /*protected int height(NodeTree root){
        if(!root){
            return 0;
        }
    }
    */
    
    /**
     * Método para recorrer el arbol en InOrden
     * @param root 
     */
    public void inorden(NodeTree root){//Metodo para hacer el inorden
        if(root != null){
            inorden(root.left);//El puntero raiz se movera por la izquierda hasta encontrar un nulo
            System.out.print(root.data + " ");
            //Se imprime lo que se encuentra en la raiz
            inorden(root.right);//El puntero raiz se movera por la derecha hasta encontrar un nulo
        }
    }
    
    public void postorden(NodeTree root){//Metodo para hacer el inorden
        if(root != null){
            inorden(root.left);//El puntero raiz se movera por la izquierda hasta encontrar un nulo
            inorden(root.right);//El puntero raiz se movera por la derecha hasta encontrar un nulo
            System.out.print(root.data + " ");
            //Se imprime lo que se encuentra en la raiz
        }
    }
    
    public void preorden(NodeTree root){//Metodo para hacer el inorden
        if(root != null){
            System.out.print(root.data + " ");
            inorden(root.left);//El puntero raiz se movera por la izquierda hasta encontrar un nulo
            inorden(root.right);//El puntero raiz se movera por la derecha hasta encontrar un nulo
            //Se imprime lo que se encuentra en la raiz
        }
    }
    
    /**
     * Método para eliminar un nodo del arbol
     * @param data
     * @return un valor boolean 
     */
    public boolean eNode(int data){
        if(!isEmpty()){//Se verifica si el arbol no se encuentra vacio
            NodeTree aux = root;
            NodeTree Dad = root;
            boolean Left = true;
            while(aux.data != data){//Si el dato que esta en auxiliar es diferente
                //al dato pedido
                Dad = aux;//Se iguala padre a auxiliar
                if(aux.data > data){//Si el dato del auxiliar es mayor que el dato
                    //pedido
                    aux = aux.left;//Se recorre el auxiliar a la izquierda
                }
                else{//Auxiliar sera igual a lo que se encuentra a la derecha
                    //del mismo
                    aux = aux.right;
                    Left = false;//Y por esta razón izquierda se iguala a falso ya
                    //que no se encuentra de el lado izquierdo
                }
                if(aux == null){
                    return false;
                }
            }
            if(aux.left == null && aux.right == null){//Se verifica si no se encuentra
                //nada de el lado derecho y izquierdo de el nodo
                if(root == aux){
                    root = null;
                }
                else{
                    if(Left){
                        Dad.left = null;
                    }
                    else{
                        Dad.right = null;
                    }
                }
            //Nodo de la izquierda
            }else if (aux.right == null){
                if(aux == root){
                    root = aux.left;
                }
                else if (Left){
                    Dad.right = aux.right;//Lo que esta a la derecha del apuntador padre
                    //Sera igual a lo que se encuentra a la derecha del apuntador auxiliar
                }
                else{
                    Dad.left = aux.right;
                }
            //Nodo de la derecha
            }else if(aux.left == null){//Si la condición anterior no se cumple, se hace una
                //comparación de el nodo que se encuentra a la izquierda, verificando
                //si tiene un valor null
                if(aux == root){//De ser así se enctra en un ciclo comparando los valores
                    //que tiene el auxiliar y la raiz
                    root = aux.right;//Si es así, se iguala raiz a lo que se encuentra a la derecha
                    //del puntero auxiliar
                }
                else if (Left){
                    Dad.left = aux.right;//Lo que esta a la izquierda del apuntador padre
                    //Sera igual a lo que se encuentra a la derecha del apuntador auxiliar
                }
                else{
                    Dad.right = aux.left;//Lo que esta a la derecha del apuntador padre
                    //Sera igual a lo que se encuentra a la izquierda del apuntador auxiliar
                }
            }
            return true;
        }
        else{//Si no se cumple la condicion anterior quiere decir que el arbol esta vacio
            //por lo tanto se regresa un falso
            return false;
        }
    }
}