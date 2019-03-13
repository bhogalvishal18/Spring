package com.vishal.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishal.app.entity.UserAuthEntity;

public interface SpringRestDao extends JpaRepository<UserAuthEntity, String> {

}
