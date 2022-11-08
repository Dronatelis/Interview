package sk.tuke.fei.kpi.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import sk.tuke.fei.kpi.dao.Customer;
import sk.tuke.fei.kpi.dao.DriverStorage;
import sk.tuke.fei.kpi.servises.CustomerServise;
import sk.tuke.fei.kpi.servises.DriverStorageServise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@RestController
public class CustomerComponent {

    @Autowired
    CustomerServise customerServise;
    @Autowired
    DriverStorageServise driverStorageServise;
    private List<DriverStorage> actualList = new ArrayList<DriverStorage>();
    private Iterable<DriverStorage> driverStorages;
    private DriverStorage driverStorage;
    private Customer customer;

    @PostMapping(value = "/customer/add")
    public void addCustomer(@RequestBody Customer customer) {
        System.out.println("Customer " + customer + " was added");
        customerServise.save(new Customer(Long.valueOf(0),customer.getUserName(),customer.getLastName(),Long.valueOf(2)));
        driverStorageServise.save(new DriverStorage(Long.valueOf(9), 8,false));
    }

    @GetMapping(value = "/customer/get")
    public Optional<Customer> findCustomerByUserName(@RequestParam Long id){
        return customerServise.findById(id);
    }


    @PostMapping(value = "/customer/update")
    public void updateCustomer(@RequestBody Customer customer) {
        System.out.println("Customer " + customer + " was added");
        customerServise.deleteById(customer.getId());
        int tempStorage;
        if (customer.getDriverId() == 8) { tempStorage = 10;
        } else if (customer.getDriverId() == 9) { tempStorage = 8;
        } else if (customer.getDriverId() == 10) { tempStorage = 6;
        } else if (customer.getDriverId() == 11) { tempStorage = 4;
        } else  { tempStorage = 2;
        }

        driverStorageServise.save(new DriverStorage(customer.getDriverId(), tempStorage,false));
        customerServise.save(new Customer(Long.valueOf(0),customer.getUserName(),customer.getLastName(),customer.getDriverId()));
    }

//    @Bean
//    public Iterable<DriverStorage> getAllDrivers(){
//        this.driverStorages = driverStorageServise.findAll();
//        this.driverStorages.forEach(actualList::add);
//        this.driverStorage = actualList.get(1);
//        System.out.println(this.driverStorage);
//        return driverStorages;
//    }

    @DeleteMapping(value = "/customer/delete")
    public void deleteCustomer(@RequestParam Long id){
        System.out.println("Customer with Id " + id + " was deleted");
        customerServise.deleteById(id);
    }
}
