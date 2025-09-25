package pixel.academy.crud_app1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app1.dao.StudentDAO;
import pixel.academy.crud_app1.entity.Student;

@SpringBootApplication
public class CrudApp1Application {

    public static void main(String[] args) {
        SpringApplication.run(CrudApp1Application.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return args -> {
          createStudent(studentDAO);
          createMultipleStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        //create object Student

        //save object Student in DB using DAO

        // display ID of saved student

        //creating new student object
        System.out.println("Creating new student object ...");
        Student newstudent = new Student("John", "Doe", "john@pixelacademy.md");

        //save object Student in database
        System.out.println("Saving the student ...");
        studentDAO.save(newstudent);

        //afisam ID-ul studentului salvat
        System.out.println("Saved student. Generated id:" + newstudent.getId());

    }
    private void createMultipleStudent(StudentDAO studentDAO) {
        //cream mai
        System.out.println("Creating multiple student ...");
        Student newStudent1 = new Student("Andrei","Munteanu", "andrei@pixelacademy.md" );
        Student newStudent2 = new Student("Iulian","Vataman", "iulic@pixelacademy.md" );
        Student newStudent3 = new Student("Maria","Mirabela", "mira@pixelacademy.md" );


        System.out.println("Saving the student ...");
        studentDAO.save(newStudent1);
        studentDAO.save(newStudent2);
        studentDAO.save(newStudent3);


    }

}
