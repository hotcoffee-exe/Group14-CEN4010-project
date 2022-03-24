package com.example.demo.customer;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "api/")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @PostMapping("/newcustomer")
//    public void createCustomer(@RequestBody Customer customer){
//        this.customerRepository.save(customer);
//        System.out.println(customer);
//    }


    @GetMapping("/customers")
    //@RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers(){
        return this.customerRepository.findAll();
    }

    @GetMapping(value = "/customers/{email}")
    public List<Customer> getCustomerByEmail(@PathVariable String email){
        return customerRepository.findByEmail(email);
    }


    @PutMapping
    @RequestMapping(path = "/customers/{email}", method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody Customer customer, @PathVariable String email){
        this.customerRepository.save(customer);
        System.out.println("UPDATES TO CUSTOMER PROFILE SAVED.");
    }


}
