package com.me.database.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.database.pojo.User;
import com.me.database.pojo.Person;
@Component
public class PersonValidator implements Validator {

	
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(Person.class);
	}

	
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Person patient = (Person) obj;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personName", "error.invalid.personName", "Patient Name Required");
	}

}
