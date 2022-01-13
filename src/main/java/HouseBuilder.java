import java.util.HashMap;
import java.util.Map;

public class HouseBuilder {
    static Map<String, Integer> elevators = new HashMap<>();

    public static Elevator elevator1;
    public static Elevator elevator2;
    public static Elevator elevator3;
    public static Elevator elevator4;

    HouseBuilder(){
        elevator1 = new Elevator("Лифт 1",1);
        elevator2 = new Elevator("Лифт 2",1);
        elevator3 = new Elevator("Лифт 3",1);
        elevator4 = new Elevator("Лифт 4",1);
    }
    public static void elevatorsMap(){

        HouseBuilder house = new HouseBuilder();

        elevators.put(elevator1.number, elevator1.position);
        elevators.put(elevator2.number, elevator2.position);
        elevators.put(elevator3.number, elevator3.position);
        elevators.put(elevator4.number, elevator4.position);

    }

}
