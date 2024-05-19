package org.example.Pilas;

public class PilaLineal {
    private static final int TAMPILA=49;
    private int cima;
    private Object[]listaPila;

    public PilaLineal(){
        cima=-1;
        listaPila =new Object[TAMPILA];
    }

    public void insertar (Object elemento)throws Exception{
        if(pilaLlena ()){
            throw new Exception("Ups, StackOverflow");
        }
        listaPila[++cima]= elemento;
    }

    public boolean pilaLlena() {
        return cima == TAMPILA;
    }

    public Object quitar() throws Exception{
        Object aux;
        if(pilaVacia()){
            throw new Exception("Pila vacia (Underflow)");
        }
        aux = listaPila[cima];
        cima --;
        return aux;
    }

    public boolean pilaVacia(){
        return cima==-1;
    }

    public void limpiarPila() {

        cima = -1;
    }





}
