package com.angus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
public class Main {
    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    private final CustomerRepository customerRepository;


    @GetMapping
    private List<Customer> getCustomers(){return customerRepository.findAll();}

    record newCustomerRequest(String name, String email, Integer age){}

    @PostMapping
    public void addCustomer(@RequestBody newCustomerRequest newCustomer){
        Customer customer = new Customer();
        customer.setName(newCustomer.name());
        customer.setEmail(newCustomer.email());
        customer.setAge(newCustomer.age());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId){
        customerRepository.deleteById(customerId);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable Integer customerId, @RequestBody newCustomerRequest newCustomerRequest){
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        customer.setName(newCustomerRequest.name());
        customer.setEmail(newCustomerRequest.email());
        customer.setAge(newCustomerRequest.age());
        customerRepository.save(customer);
    }

    @GetMapping("/")
    public greetResponse greet(){
        return new greetResponse("Hello, World!");
    }

    record greetResponse(String greeting){}
}
