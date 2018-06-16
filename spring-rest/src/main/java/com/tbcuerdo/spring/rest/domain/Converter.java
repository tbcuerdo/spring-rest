package com.tbcuerdo.spring.rest.domain;

public class Converter {
	private String token;
	public String convert(String string) {
		return string + token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
