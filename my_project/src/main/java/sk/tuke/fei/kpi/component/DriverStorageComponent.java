package sk.tuke.fei.kpi.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import sk.tuke.fei.kpi.dao.Customer;
import sk.tuke.fei.kpi.dao.DriverStorage;
import sk.tuke.fei.kpi.servises.DriverStorageServise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Configuration
@RestController
public class DriverStorageComponent {
    @Autowired
    DriverStorageServise driverStorageServise;
    private DriverStorage driverStorage;


    @PostMapping(value = "/storage/add")
    public void addDriver(@RequestBody DriverStorage driverStorage) {
        System.out.println("Customer " + driverStorage + " was added");
        driverStorageServise.save(driverStorage);
    }

    @GetMapping(value = "/storage/get")
    public Optional<DriverStorage> findCustomerByUserName(@RequestParam Long id){
        System.out.println("Customer " + id + " Get");
        return driverStorageServise.findById(id);
    }

    @PostMapping(value = "/storage/update")
    public void updateCustomer(@RequestBody DriverStorage driverStorage) {
        System.out.println("Customer " + driverStorage + " was added");
        driverStorageServise.deleteById(driverStorage.getId());
        this.driverStorage = new DriverStorage(Long.valueOf(0),driverStorage.getSizeOfStorage(),driverStorage.isState());
        driverStorageServise.save(this.driverStorage);
    }



    @DeleteMapping(value = "/storage/delete")
    public void deleteDriver(@RequestParam Long id){
        System.out.println("Customer with Id " + id + " was deleted");
        driverStorageServise.deleteById(id);
    }



//    public Iterable<DriverStorage> getDriverStorages() {
//        return driverStorages;
//    }

//    public void setDriverStorages(Iterable<DriverStorage> driverStorages) {
//        this.driverStorages = driverStorages;
//    }
}
