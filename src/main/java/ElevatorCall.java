
import java.util.*;

public class ElevatorCall {
    static Map<String, Integer> elevatorsLength = new HashMap<>();
    static List<String> elevatorsNumbers = new ArrayList<>(HouseBuilder.elevators.keySet());

    public static void moveElevator(int destination){
        for (String num:
             elevatorsNumbers) {
            int current = HouseBuilder.elevators.get(num);
            int length = Math.abs(destination - current);
            elevatorsLength.put(num,length);
            }
        if(elevatorsLength.values().stream().distinct().count() <= 1){
            HouseBuilder.elevators.put("Лифт 1",destination);
        }else {
            String key = Collections.min(elevatorsLength.entrySet(), Map.Entry.comparingByValue()).getKey();
            HouseBuilder.elevators.put(key,destination);

        }
        if(HouseBuilder.elevators.get("Лифт 4") != 1){
            HouseBuilder.elevators.put("Лифт 4",1);
        }
        System.out.println(elevatorsLength.values());

    }
}
