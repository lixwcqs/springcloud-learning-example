package org.spring.springcloud.web;


import java.io.Serializable;
import java.util.Date;

/**
 * 回复表
 * @author 
 */
public class Reply implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 评论Id
     */
    private Long commentId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 回复人
     */
    private Long fromUserId;

    /**
     * 回复对象
     */
    private Long toUserId;

    /**
     * 回复时间
     */
    private Date cTime;

    private static final long serialVersionUID = 1L;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}