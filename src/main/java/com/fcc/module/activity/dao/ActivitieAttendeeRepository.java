package com.fcc.module.activity.dao;

import com.fcc.module.activity.model.ActivitieAttendeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer on 2017/11/13.
 */
public interface ActivitieAttendeeRepository extends JpaRepository<ActivitieAttendeeEntity,Integer> {
}
