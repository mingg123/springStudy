package com.example.apiExample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {
    
    private String name;
    private String email;
    private int age;

    //특정 이름에 대해서 매칭이 가능함. 스네이크 케이스, 카멜케이스 이런거나 특이한 케이스일경우 매핑할때 사용한다. (ex: OTP)
    @JsonProperty("name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name + " " + email + " " + age;
    }
}
