package sk.tuke.fei.kpi.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.tuke.fei.kpi.component.DriverStorageComponent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Configuration
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String userName;
    private String lastName;
    private Long driverId;
//    private List<DriverStorage> driverStorages = new ArrayList<DriverStorage>();

    public Customer(Long id, String userName, String lastName, Long driverId) {
        this.id = id;
        this.userName = userName;
        this.lastName = lastName;
        this.driverId = driverId;
    }

    public Customer() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", driverId=" + driverId +
                '}';
    }
}
