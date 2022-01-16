package functions;

import java.util.ArrayList;
import java.util.Collections;

public class MedianFilter extends Input{

    private final int period;

    public ArrayList<Double> getData(Input input){
        ArrayList<Double> toSort;
        toSort = input.getData();
        return toSort;
    }

    public MedianFilter(int period) {
            this.period = period;
    }

    public ArrayList<Double> DataFiltering(ArrayList<Double> data){
        ArrayList<Double> sortedNumbers = new ArrayList<Double>();
       Collections.sort(data);
        int counter = 0;
        while (counter < data.size()/period)
        for (int i = period/2; i < data.size(); i += period) {
            sortedNumbers.add(data.get(i));
            counter++;
            System.out.println(sortedNumbers);
        }
        return sortedNumbers;
    }
}
