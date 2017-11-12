package com.fcc.module.biz.model;

import javax.persistence.*;

/**
 * Created by acer on 2017/11/3.
 */
@Entity
@Table(name = "biz_biz_user_relation", schema = "autosite", catalog = "")
public class BizUserRelationEntity {
    private int id;
    private int bizId;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "biz_id")
    public int getBizId() {
        return bizId;
    }

    public void setBizId(int bizId) {
        this.bizId = bizId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BizUserRelationEntity that = (BizUserRelationEntity) o;

        if (id != that.id) return false;
        if (bizId != that.bizId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bizId;
        result = 31 * result + userId;
        return result;
    }
}
