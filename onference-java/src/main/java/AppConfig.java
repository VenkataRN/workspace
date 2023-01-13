import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import com.pluralsight.util.CalenderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.invoke.CallSite;
import java.util.Calendar;

@Configuration
public class AppConfig {

    @Bean(name="cal")
    public CalenderFactory calFactory(){
        System.out.println("Creating  CalenderFactory calFactoryMethod");
        CalenderFactory factory = new CalenderFactory();
        factory.addDays(2);
        return factory;
    }

    //Not sure why Calendar cal()  functionis not called
    @Bean
    public Calendar cal() throws Exception {
        System.out.println("Calling  cal function calFactory().getObject();");
        return calFactory().getObject();
    }

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
