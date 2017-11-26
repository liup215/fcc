package com.fcc.module.auth.dao;

import com.fcc.module.auth.model.AuthUserGroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer on 2017/11/24.
 */
public interface AuthUserGroupsRepository extends JpaRepository<AuthUserGroupsEntity,Integer> {
}
