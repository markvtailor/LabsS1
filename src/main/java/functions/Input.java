package functions;

import java.util.ArrayList;

public class Input {
    private final ArrayList<Double> dataList = new ArrayList<>();

    public Input(){
    }

    public void addToData(Double value){
        dataList.add(value);
    }

    public ArrayList<Double> getData(){
        return dataList;
    }
}
