import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;

public class Application {
    public static void main (String[] args) {
        SpeakerService speakerService = new SpeakerServiceImpl();
        System.out.println("Spring Configuration Using JAVA");
        System.out.println(speakerService.findAll().get(0).getFirstName());
    }
}
