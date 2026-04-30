package cesde.domain;

public class Classroom {
    private int id;
    private String room;
    private int floor;
    private int capacity;
    private boolean status;

    public Classroom() {}

    public Classroom(int id, String room, int floor, int capacity, boolean status) {
        this.id = id;
        this.room = room;
        this.floor = floor;
        this.capacity = capacity;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getRoom() { return room; }
    public void setRoom(String room) { this.room = room; }
    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}
// Todas las clases, aparte de student quize que estuvieran mas organizadas, y con la menor lineas de codigo posibles
