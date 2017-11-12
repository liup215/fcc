package com.fcc.module.biz.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by acer on 2017/11/3.
 */
@Entity
@Table(name = "biz_comment", schema = "autosite", catalog = "")
public class BizCommentEntity {
    private int id;
    private String content;
    private int like;
    private int dislike;
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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "like")
    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Basic
    @Column(name = "dislike")
    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
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

        BizCommentEntity that = (BizCommentEntity) o;

        if (id != that.id) return false;
        if (like != that.like) return false;
        if (dislike != that.dislike) return false;
        if (bizId != that.bizId) return false;
        if (userId != that.userId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (editDate != null ? !editDate.equals(that.editDate) : that.editDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + like;
        result = 31 * result + dislike;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (editDate != null ? editDate.hashCode() : 0);
        result = 31 * result + bizId;
        result = 31 * result + userId;
        return result;
    }
}
