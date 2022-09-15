package service;

import model.Customer;
import java.util.HashMap;
import java.util.Map;


public class CustomerService {
    static Map<String, Customer> customerCollection=new HashMap<>();

    public static CustomerService customerService=null;

    public static CustomerService getInstance(){
        if(customerService==null) {
            customerService = new CustomerService();
        }
        return(customerService);

    }

    public  void addCustomer(String Email,String FirstName,String LastName){
        Customer add=new Customer(FirstName,LastName,Email);
        customerCollection.put(add.getEmail(),add);
    }

    public Customer getCustomer(String Email){
        return(customerCollection.get(Email));
    }

    public void getAllCustomer(){
        for(String Email:customerCollection.keySet()){
            getCustomer(Email);
        }
    }

    public Map getCustomerCollection(){
        return customerCollection;
    }

}
