package nordic_motorhome_project.demo.utilities;

import nordic_motorhome_project.demo.models.Customer;
import nordic_motorhome_project.demo.models.Motorhome;

public class RentalHolder {
    private static Customer customer;
    private static Motorhome motorhome;

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        RentalHolder.customer = customer;
    }

    public static Motorhome getMotorhome() {
        return motorhome;
    }

    public static void setMotorhome(Motorhome motorhome) {
        RentalHolder.motorhome = motorhome;
    }
}
