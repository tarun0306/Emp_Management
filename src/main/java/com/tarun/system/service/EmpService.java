package com.tarun.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tarun.system.entity.Employee;
import com.tarun.system.repository.EmpRepo;

@Service
public class EmpService {
	@Autowired
	private EmpRepo repo;
	public void addEmp(Employee e) {
		repo.save(e);
	}
	public Employee getEmpById(int id) {
		Optional<Employee> e = repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	public void deleteEmp(int id) {
		
		repo.deleteById(id);
	}
	public List<Employee> getAllEmp(){
		return repo.findAll();
	}
	public Page<Employee> getEMpByPaginate(int currentPage, int size) {
		Pageable p = PageRequest.of(currentPage, size);
		return repo.findAll(p);
	}

	}

