package com.example.apiExample.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

//JsonProperty는 하나의 Naming이고
//JsonNaming은 전체 클레스에서 적용 가능.
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PutRequestDto {
    
    private String name;
    private int age;

    private List<CarDto> carList;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<CarDto> getCarList() {
		return this.carList;
	}

	public void setCarList(List<CarDto> carList) {
		this.carList = carList;
	}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name + " " + age + " " + carList;
    }

}
