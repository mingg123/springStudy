package com.example.client.dto;

public class Req<T> {


    private Header header;

    private T body;

	public Header getHeader() {
		return this.header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public T getBody() {
		return this.body;
	}

	public void setBody(T body) {
		this.body = body;
	}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "header : " + header + "body : " +  body;
    }
    
    public static class Header{
        private String responseCode;

	public String getResponseCode() {
		return this.responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return responseCode;
    }


    }
}
