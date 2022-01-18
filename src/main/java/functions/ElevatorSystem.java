package functions;

import java.util.*;

public class ElevatorSystem extends Elevator {

    ArrayList<Elevator> elevators = new ArrayList<>();
    protected ElevatorSystem(){
        for (int i = 0; i < 3; i++) {
            elevators.add(new Elevator(i+1,1,0));
        }
    }

    @Override
    public void moveElevator(int newPosition) {
        calculateWayToNew(newPosition);
        Collections.min(elevators, Comparator.comparingInt(Elevator::getWayToNew)).moveElevator(newPosition);
    }

    public void calculateWayToNew(int newPosition) {
        for (Elevator elevator:
             elevators) {
            elevator.setWayToNew(Math.abs(newPosition - elevator.getPosition()));
        }
    }

    public void keepFreeElevatorOnFirstFloor(){
        if(elevators.stream().noneMatch(elevator -> elevator.getPosition() == 1)){
            moveElevator(1);
        }
    }


}
