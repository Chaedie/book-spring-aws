package chaedie.awsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AwsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsSpringApplication.class, args);
    }

}
