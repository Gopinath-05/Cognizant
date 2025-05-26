public class Car {
    String make, model;
    int year;
    Car(String make, String model, int year) {
        this.make = make; this.model = model; this.year = year;
    }
    void displayDetails() {
        System.out.println(year + " " + make + " " + model);
    }
    public static void main(String[] args) {
        Car c = new Car("Toyota", "Corolla", 2020);
        c.displayDetails();
    }
}
