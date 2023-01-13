import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main (String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //SpeakerService speakerService = new SpeakerServiceImpl();
        SpeakerService speakerService = applicationContext.getBean("speakerService", SpeakerService.class);
        System.out.println("Bean address : " +speakerService);

        System.out.println("Spring Configuration Observe PostConstruct is coming imediately after the constructor is called");
        System.out.println( speakerService.findAll().get(0).getFirstName());

        SpeakerService speakerService2 = applicationContext.getBean("speakerService", SpeakerService.class);
        System.out.println("Bean address : " + speakerService2);
    }
}


/*

Constrcutor injection
Postconstrcut annotation initialize
Bean address : com.pluralsight.service.SpeakerServiceImpl@47e2e487
Spring Configuration Observe PostConstruct is coming imediately after the constructor is called
Venkat
Bean address : com.pluralsight.service.SpeakerServiceImpl@47e2e487
 */