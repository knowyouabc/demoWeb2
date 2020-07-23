import com.company.demoWeb2.entity.Person;
import com.company.demoWeb2.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appconfig.xml")
public class PersonServiceTest {

    @Resource
    private PersonService personService;

    @Test
    public void getPerson() {
        personService.getPerson();
    }
}
