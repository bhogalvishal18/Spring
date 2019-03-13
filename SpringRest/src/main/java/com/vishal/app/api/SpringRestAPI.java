package com.vishal.app.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vishal.app.model.SignUpModel;

public interface SpringRestAPI {
	@CrossOrigin
	@PostMapping(value = "/signUp", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<String> signUp(@RequestBody SignUpModel signUpModel);

	@CrossOrigin
	@PostMapping(value="/signIn", produces= {"application/json"}, consumes= {"application/json"})
	public ResponseEntity<String> signIn(@RequestBody SignUpModel signInModel);
	
	@CrossOrigin
	@GetMapping(value="/welcome/user/{itprName}", produces= {"application/json"})
	public ResponseEntity<String> getUser(@PathVariable String itprName) throws Exception;
	
	
	

}
