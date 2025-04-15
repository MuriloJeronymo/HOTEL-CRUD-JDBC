package Model;

public class Room {
    private int number;
    private Double pricePerDay;

    public Room(int number, Double pricePerDay) {
        this.number = number;
        this.pricePerDay = pricePerDay;
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

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", pricePerDay=" + pricePerDay +
                '}';
    }

}
