package com.lagrida.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named(value="user")
public class PrincipalBean {
	private String name = "Google";

	public PrincipalBean() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
