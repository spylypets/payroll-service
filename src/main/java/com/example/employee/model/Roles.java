package com.example.employee.model;

public enum Roles {
	
	DEVELOPER(1, "Developer"),
	TESTER(2, "Tester"),
	ADMINISTRATOR(3, "Administrator");
	
	
	private Long id;
	
	private String name;
	
	Roles(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
