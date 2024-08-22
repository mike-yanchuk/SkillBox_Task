
public class Elevator {
    private int currentFloor = 1;
    private int maxFloor;
    private int minFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor - 1;
    }

    public void moveUp() {

        currentFloor = currentFloor + 1;

    }

    public void move(int floor) {
        if ( floor < maxFloor && floor > minFloor) {
            if (floor < currentFloor) {
                while (currentFloor > floor) {
                    moveDown();
                    System.out.println(getCurrentFloor());
                }
            } else if (floor > currentFloor) {
                while (currentFloor  < floor) {
                    moveUp();
                    System.out.println(getCurrentFloor());
                }

            }


        } else {
            System.out.println("Не правильно задан этаж");
        }

    }
}