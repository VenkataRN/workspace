import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main (String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //SpeakerService speakerService = new SpeakerServiceImpl();
        SpeakerService speakerService = applicationContext.getBean("speakerService", SpeakerService.class);
//        System.out.println("Bean address : " +speakerService);

        System.out.println("Spring Configuration Observe PostConstruct is coming imediately after the constructor is called");
        System.out.println( "getFirstName : " + speakerService.findAll().get(0).getFirstName());
        System.out.println( "getSeedNum: " + speakerService.findAll().get(0).getSeedNum());


//        SpeakerService speakerService2 = applicationContext.getBean("speakerService", SpeakerService.class);
//        System.out.println("Bean address : " + speakerService2);
    }
}

////Not sure why Calendar cal()  functionis not called
/*

Creating  CalenderFactory calFactoryMethod
Returning calender object
Constrcutor injection
Postconstrcut annotation initialize
Spring Configuration Observe PostConstruct is coming imediately after the constructor is called
Cal : Sun Jan 15 23:42:56 GMT 2023
getFirstName : Venkat
Cal : Sun Jan 15 23:42:56 GMT 2023
getSeedNum: 61.98189013632166
 */