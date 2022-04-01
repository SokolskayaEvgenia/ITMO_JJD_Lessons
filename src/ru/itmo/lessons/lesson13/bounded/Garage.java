package ru.itmo.lessons.lesson13.bounded;

/* T extends Vehicle - Т может быть Vehicle и его наследники */
/* в классе у vehicle можно вызвать методы Vehicle*/
/* Vehicle & Repair - и ТС, и интерфейс */
/* в классе у vehicle можно вызвать методы Vehicle и repair*/
public class Garage<T extends Vehicle & Repair> {
    private T vehicle;

    public T getVehicle() {
        return vehicle;
    }

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }
}