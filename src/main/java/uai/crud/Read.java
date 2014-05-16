package uai.crud;

import org.sormula.SormulaException;
import uai.model.Customer;
import uai.repository.CustomerRepository;

import java.util.List;

public class Read {
    public static void main(String[] args) throws SormulaException {
        Customer customerFound = CustomerRepository.findById(2);
        System.out.println(customerFound);

        List<Customer> customerList = CustomerRepository.listAll();

        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}
