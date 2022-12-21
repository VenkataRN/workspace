import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="speakerService")
    public SpeakerService getSpeakerService(){
        SpeakerServiceImpl speakerServiceImpl = new SpeakerServiceImpl(getSpeakerRepository()); //Constructor Injection
        //speakerServiceImpl.setSpeakerRepository(getSpeakerRepository()); Setter injection
        return speakerServiceImpl;
    }

    @Bean(name="speakerRepository")
    public SpeakerRepository getSpeakerRepository(){
        return new HibernateSpeakerRepositoryImpl();
    }
}
