package functions;

public class Elevator {
    private int number;
    private int position;
    private int wayToNew;


    protected Elevator(int number,int position, int wayToNew){
        this.number = number;
        this.position = position;
        this.wayToNew = wayToNew;
    }

    protected Elevator() {

    }

    public void moveElevator(int newPosition){
        this.position = newPosition;
    }

    public void setWayToNew(int way){
        this.wayToNew = way;
}
    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }

    public int getWayToNew() {
        return wayToNew;
    }


}
