package com.vishal.app.api;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.app.api.SpringRestAPI;
import com.vishal.app.constants.SpringRestConstant;
import com.vishal.app.model.SignUpModel;
import com.vishal.app.service.SpringRestAPIService;

@RestController
@RequestMapping(value = "/")
public class SpringRestAPIController implements SpringRestAPI,SpringRestConstant {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestAPIController.class);

	@Autowired
	SpringRestAPIService service;
	@Override
	public ResponseEntity<String> signUp(SignUpModel signUpModel) {
		// TODO Auto-generated method stub
		
		try {
			JSONObject respObj = new JSONObject();
			//signUpModel.setEmailId("");
			String resString = service.signUp(signUpModel);

			if (SUCCESS.equalsIgnoreCase(resString)) {

				return new ResponseEntity<String>(respObj.put(STATUS, resString).toString(), HttpStatus.OK);

			} else if (CONFLICT.equalsIgnoreCase(resString)) {

				return new ResponseEntity<String>(respObj.put(STATUS, resString).toString(), HttpStatus.CONFLICT);
			}

			else {
				return new ResponseEntity<String>(respObj.put(STATUS, resString).toString(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			LOGGER.error(" An Exception occured" + IN + SIGNUP + e);
			return new ResponseEntity<String>("{\"status\":\"" + INTERNAL_SERVER_ERROR + "\"}",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> signIn(SignUpModel signInModel) {
		// TODO Auto-generated method stub
		String serviceResp = service.signIn(signInModel);
		try {
			if (serviceResp.equals("SUCCESS")) {
				JSONObject resJson = new JSONObject();
				resJson.put("status", serviceResp);
				return new ResponseEntity<String>(resJson.put("status", serviceResp).toString(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("{\"status\":\"" + serviceResp + "\"}", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("{\"status\":\"" + serviceResp + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> getUser(String itprName) throws Exception {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		result.put("name", itprName);		
		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
	}

}
