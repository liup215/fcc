package com.fcc.module.activity.dao;

import com.fcc.module.activity.model.ActivitiesAttendeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer on 2017/11/13.
 */
public interface ActivitiesAttendeesRepository extends JpaRepository<ActivitiesAttendeesEntity,Integer> {
}
