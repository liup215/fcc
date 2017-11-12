package com.fcc.module.biz.model;

import javax.persistence.*;

/**
 * Created by acer on 2017/11/3.
 */
@Entity
@Table(name = "biz_biz_type_relation", schema = "autosite", catalog = "")
public class BizTypeRelationEntity {
    private int id;
    private int bizId;
    private int typeId;

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
    @Column(name = "type_id")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BizTypeRelationEntity that = (BizTypeRelationEntity) o;

        if (id != that.id) return false;
        if (bizId != that.bizId) return false;
        if (typeId != that.typeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bizId;
        result = 31 * result + typeId;
        return result;
    }
}
