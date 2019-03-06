package com.nyist.Ajax.day2.practice.case2.Service;

import java.util.List;

import com.nyist.Ajax.day2.practice.case2.entity.City;

public interface AjaxService {
	public List<City> queryCityByCountry(String country);
}
