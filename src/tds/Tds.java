package tds;

import java.util.ArrayList;

public class Tds{
    ArrayList<Entry> rows;
    int numRegion;
    int numImbrication;
    public Tds(){
    }

    public void addEntry(Tds table, Entry e){
        table.rows.add(e);
    }

}
