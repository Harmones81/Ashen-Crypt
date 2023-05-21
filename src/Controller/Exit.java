package Controller;

public class Exit
{
    private int destination;
    private String direction;

    public Exit(int destination, String direction)
    {
        this.destination = destination;
        this.direction = direction;
    }

    public int getDestination() { return destination; }
    public void setDestination(int destination) { this.destination = destination; }
    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }
}
