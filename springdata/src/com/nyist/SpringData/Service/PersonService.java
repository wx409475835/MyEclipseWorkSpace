package com.nyist.SpringData.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nyist.SpringData.Entity.Person;
import com.nyist.SpringData.Repostiory.CRUDRepostory;
import com.nyist.SpringData.Repostiory.PersonRepostory;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepostory personRepostory;
	
	
	@Transactional
	public void updatePersonEmail(String email,Integer id){
		personRepostory.updatePersonEmail(id, email);
	}
}
