package pixel.academy.crud_app1.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixel.academy.crud_app1.entity.Student;

@Repository
public class StudentDAOImplimentation implements StudenDAO {

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
}
