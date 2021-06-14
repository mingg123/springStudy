package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDto {

    private String account;
    private String email;
    private String address;
    private String password;


    // @JsonProperty("OTP")
    // private String OTP;

	// public String getOTP() {
	// 	return this.OTP;
	// }

	// public void setOTP(String OTP) {
	// 	this.OTP = OTP;
	// }



    @JsonProperty("phone_number")  //특정 이름에 대해서 매칭이 가능함 
    private String phoneNumber;

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
 // phone_number
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    @Override
    public String toString() {
        return account + email + address + password + phoneNumber ;
        // return account + email + address + password + phoneNumber + OTP;
    }
}