package tds;

import java.util.ArrayList;

public class Rec {
    ArrayList<Object> values;
    ArrayList<String> names;
    int size;
    String type_id;

    public Rec(){
        names = new ArrayList<>();
        values= new ArrayList<>();
        size = 0;
    }
}
