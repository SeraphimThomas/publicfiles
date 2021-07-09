package com.example.exceptions;

public class EvenNumberExceptions extends Exception{
	@Override
	public String getMessage() {
		return "You cannot input an even number.";
	}
}
