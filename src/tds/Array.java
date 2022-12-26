package tds;

import java.util.ArrayList;

public class Array {
    
    Object[] values;
    int size;
    String type;
    public Array(int taille, String type, Object value){
        values = new Object[taille];
        size = taille;
        this.type = type;
    }

    public Array(){

    }
}
