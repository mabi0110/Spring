package com.example.company;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

interface EmployeeRepository extends CrudRepository<Employee, Long> {
    //SELECT * FROM EMPLOYEE WHERE LAST_NAME = 'Kowalski' AND SALARY > 3000
    //SELECT e FROM Employee e WHERE e.lastName = 'Kowalski' AND e.salary > 3000;
    //UPDATE Employee e SET e.salary = e.salary + 100;
    //DELETE FROM Employee e WHERE e.id = 5;

    @Query("SELECT e FROM Employee e WHERE e.salary > 10000")
    List<Employee> findRichEmployees();


//    @Query(value = "UPDATE employee e SET e.salary = e.salary + 100", nativeQuery=true)    //SQL
    @Query("UPDATE Employee e SET e.salary = e.salary + 100")    //JPQL
    @Modifying
    @Transactional
    void giveRaiseToAll();

    @Query("SELECT e FROM Employee e WHERE e.salary > :min AND e.salary < :max")
    List<Employee> findBySalaryInRange(double min, double max);
}
