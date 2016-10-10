import com.mallstore.domain.dao.CustomerRepository;
import com.mallstore.persistence.manager.PersistenceManager;
import com.mallstore.persistence.dao.customer.DefaultCustomerRepository;
import com.mallstore.persistence.manager.hibernate.HibernatePersistenceManager;
import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.customer.Credential;
import com.mallstore.domain.model.customer.Customer;
import com.mallstore.domain.model.customer.CustomerBuilder;
import com.mallstore.domain.model.customer.Name;
import com.mallstore.domain.service.CustomerService;
import com.mallstore.domain.service.impl.DefaultCustomerService;

/**
 * Created by DeKi on 4/25/2016.
 */
public class CategoryRepository {

  public static void main(String args[]) {
    PersistenceManager hibernatePersistenceManager = new HibernatePersistenceManager();
    CustomerRepository customerRepository = new DefaultCustomerRepository(hibernatePersistenceManager);
    CustomerService customerService = new DefaultCustomerService(customerRepository);
    Customer customers = customerService.getCustomerById(new EntityId("2"));
    customerService.registerNewCustomer(generateCustomer());

//    for(Customer customer : customers) {
//      System.out.print(customer.toString());
//    }
    /**
     Category category = hibernatePersistenceManager.getCategoryByName("books");
     List<Category> categories = hibernatePersistenceManager.getAll(Category.class);
     List<String> categoryPath = category.getPathList();
     **/

  }

  public static Customer generateCustomer() {
    EntityId id = new EntityId("2");
    Name name = new Name("First", "Last");
    Credential credential = new Credential("usernamez", "password123");
    Customer customer = new CustomerBuilder(id, name, credential).build();
    return customer;
  }
}
