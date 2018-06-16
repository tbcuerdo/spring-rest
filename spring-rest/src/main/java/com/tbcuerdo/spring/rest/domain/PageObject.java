package com.tbcuerdo.spring.rest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageObject {
	
	private Converter converter;
	private Domain domain;
	
	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@JsonProperty("property1")
	public String displayProp1() {
		return converter.convert(domain.getProp1());
	}
	
	public void setConverter(Converter converter) {
		this.converter = converter;
	}

}
