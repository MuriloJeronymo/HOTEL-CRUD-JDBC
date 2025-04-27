package Model;

public class Room {
    private int number;
    private Double pricePerDay;
    private RoomStatus status;

    public Room(int number, Double pricePerDay) {
        this.number = number;
        this.pricePerDay = pricePerDay;
    }


    public Room(int number, Double pricePerDay, RoomStatus status) {
        this.number = number;
        this.pricePerDay = pricePerDay;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }
    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    public RoomStatus getStatus() {
        return status;
    }
    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", pricePerDay=" + pricePerDay +
                '}';
    }

}
