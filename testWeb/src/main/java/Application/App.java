package Application;
import org.springframework.boot.*;  
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;  
import org.springframework.context.annotation.ComponentScan;  


@SpringBootApplication 
@EnableJpaRepositories
@EntityScan
//@EnableAutoConfiguration  
//
public class App {  
    public static void main(String[] args) { 
//    	cloudThread ct =new cloudThread();
//    	ct.start();
        SpringApplication.run(App.class, args);  
    }  
}  