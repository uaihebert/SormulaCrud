package uai.crud;

import org.sormula.SormulaException;
import uai.model.Customer;
import uai.model.Gender;
import uai.repository.CustomerRepository;

public class Update extends AbstractCrud {
    public static void main(String[] args) throws SormulaException {
        Customer customer01 = new Customer(1, parseDate("01/01/2001"), "Updated John", Gender.MALE, "111111111");
        Customer customer02 = new Customer(2, parseDate("02/02/2002"), "Updated Mary", Gender.FEMALE, "222222222");
        Customer customer03 = new Customer(3, parseDate("03/03/2003"), "Updated Peter", Gender.MALE, "333333333");

        CustomerRepository.update(customer01);
        CustomerRepository.update(customer02);
        CustomerRepository.update(customer03);
    }
}
