import com.pluralsight.service.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main (String[] args) {
        //To Load applicationContext.xml below lines need to be added
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //SpeakerService speakerService = new SpeakerServiceImpl();
        SpeakerService speakerService = appContext.getBean("speakerService", SpeakerService.class);

        System.out.println("XML Based Spring Application");
        System.out.println("Now integrated with applicationContext.xml");
        System.out.println("Used Constructor Injection here");

        System.out.println(speakerService.findAll().get(0).getFirstName());
    }
}
