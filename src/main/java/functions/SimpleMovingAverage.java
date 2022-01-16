package functions;

import java.util.LinkedList;
import java.util.Queue;
import org.decimal4j.util.DoubleRounder;

public class SimpleMovingAverage extends Input {

    private final Queue<Double> numbers = new LinkedList<Double>();
    private double sum;
    private final int period;

    public SimpleMovingAverage(int period) {
        this.period = period;
    }
    public void DataInput(double value){
        sum += value;
        numbers.add(value);
        if(numbers.size() > period){
            sum -= numbers.remove();
        }
    }
    public double CalculateSMA(){return DoubleRounder.round(sum / period,2) ;}
}
