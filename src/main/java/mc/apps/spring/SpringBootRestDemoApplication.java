package mc.apps.spring;

import mc.apps.spring.model.User;
import mc.apps.spring.model.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootRestDemoApplication {
    private static final Logger logger = LogManager.getLogger(SpringBootRestDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository){
        return args -> {
            Stream.of("Homer", "Marge", "Bart", "Lisa").forEach(name->{
                User user = new User(name, name.toLowerCase() + "@simpson.com");
                userRepository.save(user);
            });

            userRepository.findAll().forEach(logger::info);

        };
    }
}
