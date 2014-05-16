package uai.crud;

import org.sormula.SormulaException;
import uai.model.Customer;
import uai.model.Gender;
import uai.repository.CustomerRepository;

public class Create extends AbstractCrud {
    public static void main(String[] args) throws SormulaException {
        Customer customer01 = new Customer(parseDate("01/01/2001"), "John", Gender.MALE, "111111111");
        Customer customer02 = new Customer(parseDate("02/02/2002"), "Mary", Gender.FEMALE, "222222222");
        Customer customer03 = new Customer(parseDate("03/03/2003"), "Peter", Gender.MALE, "333333333");

        CustomerRepository.create(customer01);
        CustomerRepository.create(customer02);
        CustomerRepository.create(customer03);
    }
}
