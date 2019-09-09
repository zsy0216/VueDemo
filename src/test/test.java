import com.vue.dao.CustomerDao;
import com.vue.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @Date:2019/9/3 16:13
 * @Author: zsy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindAll() {
        List<Customer> customers = customerDao.findAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void testFindById(){
        System.out.println(customerDao.findById(6));
    }

    @Test
    public void testInsertOne(){
        Customer customer = new Customer();
        customer.setName("test");
        customer.setEmail("test");
        customer.setPhone("test");
//        customer.setEducation("test");
//        customer.setGraduationschool("test");
//        customer.setProfession("test");
//        customer.setProfile("test");
        System.out.println(customerDao.insertOne(customer));
    }


    @Test
    public void testDelete(){
        System.out.println(customerDao.delete(13 ));
    }

}
