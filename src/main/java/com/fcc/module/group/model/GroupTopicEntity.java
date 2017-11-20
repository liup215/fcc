package com.fcc.module.group.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by acer on 2017/11/13.
 */
@Entity
@Table(name = "group_topic", schema = "autosite", catalog = "")
public class GroupTopicEntity {
    private int id;
    private String title;
    private String content;
    private int replyCount;
    private int like;
    private int status;
    private Timestamp createAt;
    private Timestamp updateAt;
    private int authorId;
    private int groupId;
    private Integer lastReplyUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "reply_count")
    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
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
    @Column(name = "last_reply_user_id")
    public Integer getLastReplyUserId() {
        return lastReplyUserId;
    }

    public void setLastReplyUserId(Integer lastReplyUserId) {
        this.lastReplyUserId = lastReplyUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupTopicEntity that = (GroupTopicEntity) o;

        if (id != that.id) return false;
        if (replyCount != that.replyCount) return false;
        if (like != that.like) return false;
        if (status != that.status) return false;
        if (authorId != that.authorId) return false;
        if (groupId != that.groupId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;
        if (lastReplyUserId != null ? !lastReplyUserId.equals(that.lastReplyUserId) : that.lastReplyUserId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + replyCount;
        result = 31 * result + like;
        result = 31 * result + status;
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        result = 31 * result + authorId;
        result = 31 * result + groupId;
        result = 31 * result + (lastReplyUserId != null ? lastReplyUserId.hashCode() : 0);
        return result;
    }
}
