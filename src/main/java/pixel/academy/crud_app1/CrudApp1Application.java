package pixel.academy.crud_app1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app1.dao.StudenDAO;
import pixel.academy.crud_app1.entity.Student;

@SpringBootApplication
public class CrudApp1Application {

    public static void main(String[] args) {
        SpringApplication.run(CrudApp1Application.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner(StudenDAO studenDAO) {
        return args -> {
          createStudent(studenDAO);
        };
    }

    private void createStudent(StudenDAO studenDAO) {
        //create object Student

        //save object Student in DB using DAO

        // display ID of saved student

    }

}
