package tds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rec {
    ArrayList<Object> values;
    ArrayList<String> names;
    int size;
    String type_id;
    Map<String, Object> dict;

    public Rec(){
        names = new ArrayList<>();
        values= new ArrayList<>();
        dict = new HashMap<String, Object>();
        size = 0;
    }
}
