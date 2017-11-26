package com.fcc.module.auth.dao;

import com.fcc.module.auth.model.AuthUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer on 2017/11/1.
 */
public interface AuthUserRepository extends JpaRepository<AuthUserEntity,Integer> {
    public AuthUserEntity findByUsername(String username);
}
