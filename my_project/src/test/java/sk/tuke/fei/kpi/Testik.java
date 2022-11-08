package sk.tuke.fei.kpi;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import sk.tuke.fei.kpi.component.CustomerComponent;
import sk.tuke.fei.kpi.dao.Customer;
import sk.tuke.fei.kpi.servises.CustomerServise;

public class Testik {
//    private static CustomerServise customerServise() { return (CustomerServise) new CustomerComponent();}
    CustomerServise servise (){ return (CustomerServise) new CustomerComponent();}
    @Test
    public void testAddCustomer() {

        CustomerComponent component = new CustomerComponent();

        component.addCustomer(new Customer(Long.valueOf(0),"TestUserName","TestLastName",Long.valueOf(8)));
        component.addCustomer(new Customer(Long.valueOf(0),"TestUserName","TestLastName",Long.valueOf(8)));

    }
}