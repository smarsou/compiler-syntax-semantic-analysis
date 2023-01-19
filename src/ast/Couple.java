package ast;

public class Couple<T,K>{
    T t;
    K k;
    public int line;

    public Couple(T t, K k, int line){
        this.t = t;
        this.k = k;
        this.line = line;
    }
}