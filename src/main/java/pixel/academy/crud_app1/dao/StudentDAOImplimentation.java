package pixel.academy.crud_app1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixel.academy.crud_app1.entity.Student;

import java.util.List;

@Repository
public class StudentDAOImplimentation implements StudentDAO {

    // Camp pentru EntityManager (va fi utilizat pentru interactiunea cu baza de date)
    private EntityManager entityManager;

    //Injectarea EntityManager prin constructor
    @Autowired
    public StudentDAOImplimentation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //Implimentarea metodei save pentru salvarea unui obiect Student in baza de date
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        //create query
        TypedQuery <Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        //set parametry for query
        theQuery.setParameter("theData", theLastName);

        //return result for query
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        //get student from database.
        Student theStudent = entityManager.find(Student.class, id);

        //delete student.
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
