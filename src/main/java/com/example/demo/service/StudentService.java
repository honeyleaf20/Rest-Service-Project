package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.beans.StudentWrapper;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;



@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public StudentWrapper saveStudent(StudentWrapper inputStudent)  {
		
		Student student= new Student();
		//student.setId(inputStudent.getId());
		student.setName(inputStudent.getName());
		
		student=repository.save(student);
		inputStudent.setId(student.getId());
		inputStudent.setName(student.getName());
		
		return inputStudent;
	}
	
	public StudentWrapper getStudentById(Long id)throws RecordNotFoundException{
		StudentWrapper studentWrapperOutput=null;
		
		Optional<Student> studentOptionalData= repository.findById(id);
		
		if(studentOptionalData.isPresent()) {
			studentWrapperOutput= new StudentWrapper();
			Student student=studentOptionalData.get();
			studentWrapperOutput.setId(student.getId());
			studentWrapperOutput.setName(student.getName());
		}
		else
			throw new RecordNotFoundException("Student record not found");
		
		return studentWrapperOutput;
		
	}
	public StudentWrapper updateStudentDetails(StudentWrapper inputStudent)throws RecordNotFoundException{
		
		
		Optional<Student> studentOptionalData= repository.findById(id);
		
		if(studentOptionalData.isPresent()) {
			Student student= studentOptionalData.get();
			
			//Update name
			student.setName(inputStudent.getName());
			repository.save(student);
			
			//Populate the updated details in output project
			StudentWrapper studentWrapper= new StudentWrapper();
			studentWrapper.setId(student.getId());
			studentWrapper.setName(student.getName());
			return studentWrapper;
		}
		else
			throw new RecordNotFoundException("Student record not found");
		
	}
	
	public void deleteById(Long id)throws RecordNotFoundException{
		Optional<Student> studentOptionalData= repository.findById(id);
		if(studentOptionalData.isPresent()) {
			Student student= studentOptionalData.get();
			repository.delete(student);
		
	}
		else
			throw new RecordNotFoundException("Student record not found");
	}

}
