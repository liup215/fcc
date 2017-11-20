package com.fcc.module.group.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by acer on 2017/11/13.
 */
@Entity
@Table(name = "groups_comment", schema = "autosite", catalog = "")
public class GroupsCommentEntity {
    private int id;
    private String content;
    private String quoteTxt;
    private int quoteId;
    private int like;
    private int status;
    private Timestamp createAt;
    private Timestamp updateAt;
    private int authorId;
    private int groupId;
    private int topicId;

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
    @Column(name = "quote_txt")
    public String getQuoteTxt() {
        return quoteTxt;
    }

    public void setQuoteTxt(String quoteTxt) {
        this.quoteTxt = quoteTxt;
    }

    @Basic
    @Column(name = "quote_id")
    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
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
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "create_at")
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "update_at")
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Basic
    @Column(name = "author_id")
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "topic_id")
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupsCommentEntity that = (GroupsCommentEntity) o;

        if (id != that.id) return false;
        if (quoteId != that.quoteId) return false;
        if (like != that.like) return false;
        if (status != that.status) return false;
        if (authorId != that.authorId) return false;
        if (groupId != that.groupId) return false;
        if (topicId != that.topicId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (quoteTxt != null ? !quoteTxt.equals(that.quoteTxt) : that.quoteTxt != null) return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (quoteTxt != null ? quoteTxt.hashCode() : 0);
        result = 31 * result + quoteId;
        result = 31 * result + like;
        result = 31 * result + status;
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        result = 31 * result + authorId;
        result = 31 * result + groupId;
        result = 31 * result + topicId;
        return result;
    }
}
