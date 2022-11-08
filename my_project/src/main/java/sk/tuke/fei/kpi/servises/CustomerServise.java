package sk.tuke.fei.kpi.servises;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import sk.tuke.fei.kpi.dao.Customer;


public interface CustomerServise extends PagingAndSortingRepository<Customer, Long> {
    Customer findCustomerByUserName(String customerName);


}
