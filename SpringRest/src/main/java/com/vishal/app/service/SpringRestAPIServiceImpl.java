package com.vishal.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishal.app.entity.UserAuthEntity;
import com.vishal.app.dao.SpringRestDao;
import com.vishal.app.model.SignUpModel;
import com.vishal.app.service.SpringRestAPIService;
import com.vishal.app.constants.SpringRestConstant;

@Service
public class SpringRestAPIServiceImpl implements SpringRestAPIService,SpringRestConstant {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestAPIServiceImpl.class);

	
	@Autowired
	SpringRestDao springrestdao;
	
	//Register New user
	@Override
	public String signUp(SignUpModel signUpModel) throws Exception {
		// TODO Auto-generated method stub
		String STATUS = "FAILURE";
		try
		{
			UserAuthEntity entity = new UserAuthEntity();
			UserAuthEntity savedEntity;
			entity.setUserId(signUpModel.getUserId());
			entity.setPassword(signUpModel.getPassword());
			entity.setFirstName(signUpModel.getFirstName());
			entity.setLastName(signUpModel.getLastName());
			entity.setEmailId(signUpModel.getEmailId());
			if (springrestdao.findById(signUpModel.getUserId()).isPresent()) {

				STATUS = CONFLICT;
				return STATUS;

			} else {
				savedEntity = springrestdao.save(entity);

			}
			if (savedEntity != null) {
				STATUS = SUCCESS;
				LOGGER.info("User created sucessfully " + "user id:" + savedEntity.getUserId());
			}

		}catch(Exception e)
		{
			STATUS = FAILURE;
			throw new Exception(e);	
		}
		return STATUS;
	}

	@Override
	public String signIn(SignUpModel signInModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
