package nogari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //JAVA 배치 때문에 넣음
public class NogariApplication {

    public static void main(String[] args) {
        SpringApplication.run(NogariApplication.class, args);
    }

}
