package com.digi.service;

public interface RandomService {

	String validCharacters ();

	String generateCode ();

	String customizeCode (String code);
}
