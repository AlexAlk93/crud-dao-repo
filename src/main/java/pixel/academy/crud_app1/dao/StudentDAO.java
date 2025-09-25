package pixel.academy.crud_app1.dao;

import pixel.academy.crud_app1.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}

