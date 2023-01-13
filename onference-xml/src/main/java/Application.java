import com.pluralsight.service.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Application {
    public static void main (String[] args) {
        //To Load applicationContext.xml below lines need to be added
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //SpeakerService speakerService = new SpeakerServiceImpl();
        SpeakerService speakerService = appContext.getBean("speakerService", SpeakerService.class);

        System.out.println("XML Based Spring Application");
        System.out.println("Now integrated with applicationContext.xml");
        System.out.println("Used Constructor Injection (Setter is not called)  here but XML is autowired configuration");

        System.out.println(speakerService.findAll().get(0).getFirstName());
    }
}

/*
XML Based Spring Application
Now integrated with applicationContext.xml
Used Constructor Injection (Setter is not called)  here but XML is autowired configuration
Venkat
 */