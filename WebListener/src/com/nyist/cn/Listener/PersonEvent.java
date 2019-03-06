package com.nyist.cn.Listener;

import com.nyist.cn.Model.Person;

public class PersonEvent{
	private Person person;

	protected Person getPerson() {
		return person;
	}

	protected void setPerson(Person person) {
		this.person = person;
	}

	public PersonEvent(Person person) {
		super();
		this.person = person;
	}

	public PersonEvent() {
		super();
	}
}