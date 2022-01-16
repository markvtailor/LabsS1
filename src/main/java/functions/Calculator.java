package functions;

import java.util.ArrayList;

public class Calculator extends Input{

    int per = 3;

    public void setPeriod(int period){
        if(period%2 == 0 || period < 1){
            System.out.println("Период медианного фильтра не может быть четным. Установлено значение по умолчанию - 3");
            per = 3;
        }else{
            per = period;
        }
    }

    public  ArrayList<Double> getSMA(ArrayList<Double> numbersArray){
        ArrayList<Double> smaArray = new ArrayList<>();
        SimpleMovingAverage sma = new SimpleMovingAverage(per);
        if (numbersArray.size() < per){
            return null;
        }else{
            for (double number:
                    numbersArray) {
                sma.DataInput(number);
                smaArray.add(sma.CalculateSMA());
            }
            return smaArray;
        }
    }

    public ArrayList<Double> useMedianFilter(Input input){
        ArrayList<Double> filterArray;
        MedianFilter filter = new MedianFilter(per);
        ArrayList<Double> toSort = new ArrayList<>(filter.getData(input));
        if (toSort.size() < per){
            return null;
        }else{
            filterArray = filter.DataFiltering(toSort);
            return filterArray;
        }

    }
}
