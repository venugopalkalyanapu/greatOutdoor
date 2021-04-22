package com.cg.go.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.go.entity.UserEntity;

@Repository

public interface UserDAOInterface extends JpaRepository<UserEntity, String> {

}
