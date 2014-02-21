package ejercicios;

import java.util.Scanner;

public class ListaSimple<T> {
    private Nodo<T> p= new Nodo<>();
    Scanner teclado = new Scanner(System.in);
    
    public void crea_inicio(int dato){
        p.setDato(dato);
        p.setLiga(null);
        System.out.println("¿Desea ingresar a la lista? Si:1, No:0");
        int res = teclado.nextInt();
        
        while(res == 1){
            Nodo<T> q = new Nodo<>();
            
            //System.out.println("Ingrese el dato");
            //dato =(T) teclado.next();
            
            q.setDato(dato);
            q.setLiga(p);
            p = q;
            
            System.out.println("¿Desea ingresar a la lista? Si:1, No:0");
            res = teclado.nextInt();
        }
    }
        
    public void crea_final(int dato){
         p.setDato(dato);
         p.setLiga(null);
         Nodo<T> t = p;
         
        
         System.out.println("¿Desea ingresar a la lista? Si:1, No:0");
         int res = teclado.nextInt();
         
         while(res == 1){
             Nodo<T> q = new Nodo<>();
 
            //System.out.println("Ingrese el dato");
            //dato =(T) teclado.next();
             
             q.setDato(dato);
             
             q.setLiga(null);
             t.setLiga(q);
             t=q;
             
         System.out.println("¿Desea ingresar a la lista? Si:1, No:0");
         res = teclado.nextInt();             
         }
         
         p=t;//aseguramos p este al inicio
    }
         
     public void recorre_iterativo(Nodo<T> aux){
         Nodo<T> q = aux;
         
         while(q!=null){
             System.out.print(q.getDato()+", ");
             q = q.getLiga();
         }
     }
     
     public void recorre_recursivo(Nodo<T> p){
         if(p != null){
             System.out.print(p.getDato());
         }
         recorre_recursivo(p.getLiga());
     }
         
     public void inserta_inicio(Nodo<T> p, int dato){
         Nodo<T> q = new Nodo<>();
         q.setDato(dato);
         q.setLiga(p);
         p = q;
     }
        
     public void inserta_final(Nodo<T> p, int dato){
         Nodo<T> t = p;
         
         while(t.getLiga() != null){
             t=t.getLiga();   
         }
         
         Nodo<T> q= new Nodo<>();
         q.setDato(dato);
         q.setLiga(null);
         t.setLiga(q);
     }
     
     public void insertar_antes_X(Nodo<T> p, int dato){
         Nodo<T> q = new Nodo<>();
         q=p;
         int BAND=1;
         Nodo<T> t =new Nodo<>();
         
         while(q.getDato()!=dato && BAND ==1){
             if(q.getLiga()!=null){
                 t=q;
                 q = q.getLiga();
             }else{
                 BAND = 0;
             }       
         }
         if(BAND == 1){
             Nodo<T> x = new Nodo<>();
             x.setDato(dato);
             if(p.equals(q)){
                 x.setLiga(p);
                 p=x;
             }else{
                 t.setLiga(x);
                 x.setLiga(q);
             }
         }else{
             System.out.println("El nodo dado como referencia no"
                     + "se encuentra en la lista");
         }
             
     }
     
     public void inserta_despues_X(Nodo<T> p, int ingresa, int busca){
         Nodo<T> q = new Nodo<>();
         q = p;
         int BAND = 1;
         
         while(q.getDato()!=busca && BAND ==1){
             if(q.getLiga() != null)
                 q=q.getLiga();
             else
                 BAND = 0;
         }
         if(BAND == 1){
             Nodo<T> t = new Nodo<>();
             t.setDato(ingresa);
             t.setLiga(q.getLiga());
             q.setLiga(t);
         }else
             System.out.println("El nodo dado como referencia no se encuentra"
                     + "en la lista");
     }
     
     //ELIMINAR
     
     public void eliminar_inicio(Nodo<T> p){
         Nodo<T> q =p ;
         p = q.getLiga();
         q = null;
     }
     
     public void elimina_ultimo(Nodo p){
         Nodo<T> q = p;
         Nodo<T> t = new Nodo<>();
         
         if(p.getLiga()==null)
             p=null;
         else{
             while(q.getLiga()!=null){
                 t=q;
                 q=q.getLiga();
             }
            t.setLiga(null);
         }
         q=null;
     }
          
    public void elimina_x(Nodo<T> p, int x){
        Nodo<T> q = p;
        Nodo<T> t = new Nodo<>();
        int BAND = 1;
        
        while(q.getDato()!=x && BAND ==1){
            if(q.getLiga()!=null){
                t=q;
                q=q.getLiga();
            }else
                BAND=0;
        }
        
        if(BAND == 0){
            System.out.println("El elemenco con "+x+"no se encontro en"
                    + "la lista");
        }else{
            if(p.equals(q))
                p=q.getLiga();
            else
                t.setLiga(q.getLiga());
            q=null;
        }
    }
    
    public void eliminar_antes_x(Nodo p, int x){
        Nodo<T> q = new Nodo<>();
        Nodo<T> t = new Nodo<>();
        Nodo<T> r = new Nodo<>();
        int BAND=0;
        
        if(p.getDato()==x){
            System.out.println("No existe un nodo que preceda al que contiene a X");
        }else{
            q = p;
            t = p;
            BAND=1;
            while(q.getDato()!=x && BAND ==1){
                if(q.getLiga()!=null){
                    r=t;
                    t=q;
                    q=q.getLiga();
                }else
                    BAND=0;
            }
        
            if(BAND == 0)
                System.out.println("El elemento no se encuentra en la lista");
            else{
                if(p.getLiga()==q)
                    p=q;
                else
                    r.setLiga(q);
            t=null;
            }   
        }
    }
    
    public void busqueda_desordenada(Nodo<T> p, int x){
        Nodo<T> q = p;
        while(q!=null && q.getDato()!=x){
            q=q.getLiga();
        }
        if(q == null)
            System.out.println("El elemento no se encuentra en la lista");
        else
            System.out.println("El elemento se encuentra en la lista"); 
    }
    
    public void busqueda_ordenada(Nodo<T> p, int x){
        Nodo<T> q = p;
        while(q!=null && q.getDato()<x){
            q=q.getLiga();
        }
        if(q==null || q.getDato()>x)
            System.out.println("El elemento no se encuentra en la lista");
        else
            System.out.println("El elemento se encuentra en la lista");     
    }
    
    public void busqueda_recursiva(Nodo<T> p, int x){
        if(p!= null)
            if(p.getDato()==x)
                System.out.println("El elemento se encuentra en la lista");
            else
                busqueda_recursiva(p.getLiga(), x);
        else
                System.out.println("El elemento no se encuentra en la lista");
    }
    
    
    
    public static void main(String []args){
        ListaSimple nodos = new ListaSimple();
        Scanner teclado = new Scanner(System.in);
        boolean bandera = true;
        do{
            System.out.println("--Prueba--");
            
        }while(bandera);
    } 
}
