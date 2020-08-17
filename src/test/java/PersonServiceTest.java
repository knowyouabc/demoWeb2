import com.company.demoWeb2.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = MyConfig.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@WebAppConfiguration
public class PersonServiceTest {

    @Resource
    private PersonService personService;

    @Test
    public void getPerson() throws SQLException, ExecutionException, InterruptedException {
        personService.getPerson();
    }
}
