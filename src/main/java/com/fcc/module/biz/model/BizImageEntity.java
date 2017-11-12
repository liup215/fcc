package com.fcc.module.biz.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by acer on 2017/11/3.
 */
@Entity
@Table(name = "biz_image", schema = "autosite", catalog = "")
public class BizImageEntity {
    private int id;
    private String url;
    private int type;
    private Timestamp createDate;
    private Timestamp editDate;
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "edit_date")
    public Timestamp getEditDate() {
        return editDate;
    }

    public void setEditDate(Timestamp editDate) {
        this.editDate = editDate;
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

        BizImageEntity that = (BizImageEntity) o;

        if (id != that.id) return false;
        if (type != that.type) return false;
        if (bizId != that.bizId) return false;
        if (userId != that.userId) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (editDate != null ? !editDate.equals(that.editDate) : that.editDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (editDate != null ? editDate.hashCode() : 0);
        result = 31 * result + bizId;
        result = 31 * result + userId;
        return result;
    }
}
