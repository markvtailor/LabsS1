import java.util.ArrayList;

public class SimpleMovingAverage {
    static double sum = 0;
    static String output = "";
    static ArrayList<Double> numbers = new ArrayList<>();

    public static void daysInput(double value){
        numbers.add(value);
    }

    public static double calculateSMA(){

        for (Double number : numbers) {
            sum += number;
        }

        double sma = sum/ numbers.size();
        System.out.println(sma);
        sum = 0;

        return  sma;
    }

    public static String showInput(){
        output = "";
        for (Double number : numbers) {
            output += " " + number + ";";
        }
        return output;
    }

    public static int showInputSize(){
        return numbers.size();
    }

}