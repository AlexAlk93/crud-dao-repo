package pixel.academy.crud_app1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app1.dao.StudentDAO;
import pixel.academy.crud_app1.entity.Student;

import java.util.List;

@SpringBootApplication
public class CrudApp1Application {

    public static void main(String[] args) {
        SpringApplication.run(CrudApp1Application.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return args -> {
          //createStudent(studentDAO);
          //createMultipleStudents(studentDAO);
           // readStudent(studentDAO);
            queryForStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO) {
        //create an object the type Student

        System.out.println("Creating new Student object ...");
        Student newStudent = new Student("Mircea", "Popescu", "mircea@pixelacademy.md");

        //save student in database
        System.out.println("Saving the student ...");
        studentDAO.save(newStudent);

        //show id student save
        int theId = newStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        //get student by ID (Primary Key)
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        //display details of the student
        System.out.println("Found the student: " + myStudent);
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
    private void createMultipleStudents(StudentDAO studentDAO) {
        //create more students
        System.out.println("Creating multiple student ...");
        Student newStudent1 = new Student("Andrei","Munteanu", "andrei@pixelacademy.md" );
        Student newStudent2 = new Student("Iulian","Vataman", "iulic@pixelacademy.md" );
        Student newStudent3 = new Student("Maria","Mirabela", "mira@pixelacademy.md" );


        System.out.println("Saving the student ...");
        studentDAO.save(newStudent1);
        studentDAO.save(newStudent2);
        studentDAO.save(newStudent3);


    }
    private void queryForStudent(StudentDAO studentDAO) {

        //obtine lista de studenti
        List<Student> theStudents = studentDAO.findAll();

        //afiseaza lista de studenti
        for (Student newStudent : theStudents) {
            System.out.println(newStudent);
        }
    }

}
