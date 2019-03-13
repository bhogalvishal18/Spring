package com.vishal.app.service;

import com.vishal.app.model.SignUpModel;

public interface SpringRestAPIService {
	String signUp(SignUpModel signUpModel) throws Exception;

	String signIn(SignUpModel signInModel);
}
