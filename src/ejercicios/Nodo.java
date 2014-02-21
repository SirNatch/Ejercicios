package ejercicios;


public class Nodo <T>{
    private int dato;
    private Nodo<T> liga;
    
    Nodo(){
        
    }
    
    Nodo(int num){
        this.dato=num;
        liga=null;
    }
    
    /**
     * @return the dato
     */
    public int getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * @return the liga
     */
    public Nodo<T> getLiga() {
        return liga;
    }

    /**
     * @param liga the liga to set
     */
    public void setLiga(Nodo<T> liga) {
        this.liga = liga;
    } 
}