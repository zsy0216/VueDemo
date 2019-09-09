import com.vue.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @PackageName:PACKAGE_NAME
 * @Date:2019/9/3 17:44
 * @Author: zsy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testController {

    @Autowired
    CustomerService customerService;

    @Test
    public void testFindAll(){
        System.out.println(customerService.findAll());
    }

    @Test
    public void testFindById(){
        System.out.println(customerService.findById(6));
    }
}
