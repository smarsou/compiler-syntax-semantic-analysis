package tds;

import java.util.ArrayList;

public class Tds{
    ArrayList<Entry> rows = new ArrayList<>();
    int numRegion;
    int numImbrication;
    int pere;
    String nameBlock;
    public Tds(int numRegion, int numImbrication, int pere){
        this.numRegion = numRegion;
        this.numImbrication = numImbrication;
        this.pere = pere;
    }


    public void addEntry(Entry e){
        this.rows.add(e);
    }


}
