package com.example.validaion.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class User {
    

    // 공백으로 request를 보내면 공백일 수 없습니다 로 뜬다.
    @NotBlank
    private String name;


    //0을 넣으면 0 이상이어야 합니다 이라 뜬다.
    @Min(value = 1)
    private int age;

    @Email
    private String email;

    //해당 정규식과 알맞지 않은 값이 들어올 경우 message ["^\d{2,3}-\d{3,4}-\d{4}$"와 일치해야 합니다 가옴
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. xxx-xxxx-xxxx")
    private String phoneNumber;

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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


    @Override
    public String toString() {
        return name + " " + age + " " + email +" " + phoneNumber;
    }
}
