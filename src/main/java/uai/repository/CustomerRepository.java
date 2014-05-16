package uai.repository;

import org.sormula.Database;
import org.sormula.SormulaException;
import org.sormula.Table;
import uai.model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CustomerRepository {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("could not jdbc load driver: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static Connection createConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/CRUD", "root", "root");
        } catch (SQLException e) {
            System.err.println("could not create connection: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void closeQuietly(Connection connection) {
        try{
            if(!connection.isClosed()){
                connection.close();
            }
        } catch (Exception ex){
            System.out.println("Error closing the connection");
        }
    }

    private static Database getDatabase() {
        Connection connection = createConnection();
        return new Database(connection);
    }

    public static List<Customer> listAll() throws SormulaException {
        Database database = getDatabase();

        try{
            Table<Customer> customerTable = database.getTable(Customer.class);
            return customerTable.selectAll();
        } finally {
            closeQuietly(database.getConnection());
        }
    }

    public static Customer findById(Integer customerId) throws SormulaException {
        Database database = getDatabase();

        try{
            Table<Customer> customerTable = database.getTable(Customer.class);
            return customerTable.select(customerId);
        } finally {
            closeQuietly(database.getConnection());
        }
    }

    public static void create(Customer customer) throws SormulaException {
        Database database = getDatabase();

        try{
            Table<Customer> customerTable = database.getTable(Customer.class);
            customerTable.insert(customer);
        } finally {
            closeQuietly(database.getConnection());
        }
    }

    public static void update(Customer customer) throws SormulaException {
        Database database = getDatabase();

        try{
            Table<Customer> customerTable = database.getTable(Customer.class);
            customerTable.update(customer);
        } finally {
            closeQuietly(database.getConnection());
        }
    }

    public static void delete(int customerId) throws SormulaException {
        Database database = getDatabase();

        try{
            Table<Customer> customerTable = database.getTable(Customer.class);
            customerTable.delete(customerId);
        } finally {
            closeQuietly(database.getConnection());
        }
    }
}
