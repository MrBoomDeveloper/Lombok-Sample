package com.mrboomdev.androididelombok;

import lombok.*;

@NoArgsConstructor //Generates empty constructor
@AllArgsConstructor
@Builder //Generates a builder class
public class LombokSample {
	@Setter @Getter private String message;
	@Getter @Builder.Default public int age = 14; //If not specified in the builder, use this value
	@Getter(AccessLevel.PRIVATE) public int level;
	
	private LombokSample(SuperSecretThing secret) {}
	
	public LombokSample build() {
		//Lombok generates a setter with a value argument, which changes the variable!
		this.getLevel(); // Getter is only available in this class
		setMessage("Hello, World!");
		return this;
	}
	
	private class SuperSecretThing {}
}