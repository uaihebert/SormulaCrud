package uai.crud;

import org.sormula.SormulaException;
import uai.repository.CustomerRepository;

public class Delete {
    public static void main(String[] args) throws SormulaException {
        CustomerRepository.delete(2);
    }
}
