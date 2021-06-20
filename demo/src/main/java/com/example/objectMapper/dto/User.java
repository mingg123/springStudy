package com.example.objectMapper.dto;

import java.util.List;

public class User {
    private String name;
    private int age;

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

    private List<Car> cars;

	public List<Car> getCars() {
		return this.cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



    @Override
    public String toString() {
        return name + " " + age;
    }
}