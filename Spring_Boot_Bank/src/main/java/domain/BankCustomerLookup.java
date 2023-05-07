package domain;

import java.util.HashMap;
import java.util.Map;

//zonder databank
public class BankCustomerLookup {

    private Map<String, BankCustomer> customers = new HashMap<>();

    public BankCustomerLookup()
    {
        customers.put("123", new BankCustomer("123", "An", "Devriendt", 2000));
        customers.put("456", new BankCustomer("456", "Jan", "Blondee", 150));
        customers.put("789", new BankCustomer("789", "Els", "Keters", -1000));
    }
    
    public BankCustomer getCustomer(String id) {
        return customers.get(id);
    }
}