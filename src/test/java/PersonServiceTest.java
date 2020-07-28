import com.company.demoWeb2.config.MyConfig;
import com.company.demoWeb2.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.sql.SQLException;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = MyConfig.class)
@ContextConfiguration(locations = {"classpath:app-config.xml"})
@WebAppConfiguration
public class PersonServiceTest {

    @Resource
    private PersonService personService;

    @Test
    public void getPerson() throws SQLException {
        personService.getPerson();
    }
}
