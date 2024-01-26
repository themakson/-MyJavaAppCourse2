package ru.ermakov.MyJavaAppCourse27.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ermakov.MyJavaAppCourse27.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}