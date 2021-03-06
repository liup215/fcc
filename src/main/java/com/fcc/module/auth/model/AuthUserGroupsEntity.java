package com.fcc.module.auth.model;

import javax.persistence.*;

/**
 * Created by acer on 2017/11/1.
 */
@Entity
@Table(name = "auth_user_groups", schema = "autosite", catalog = "")
public class AuthUserGroupsEntity {
    private int id;
    private int userId;
    private int groupId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthUserGroupsEntity that = (AuthUserGroupsEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (groupId != that.groupId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + groupId;
        return result;
    }
}
