package com.tarun.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarun.system.entity.Employee;
@Repository
public interface EmpRepo  extends JpaRepository<Employee,Integer>{

}
