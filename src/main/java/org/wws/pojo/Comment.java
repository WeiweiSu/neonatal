package org.wws.pojo;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by weiweisu on 3/18/14.
 */
@Entity
@Table(name="COMMENT")
public class Comment{
    @Id
    @Column(name = "comment_id", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    
    @Field
    @Column(name="userName")
    private String username;
    
    @Column(name="commentDate")
    private Date commentDate;
    
    @Field
    @Column(name="content")
    @NotEmpty
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="fk_post", nullable = false)
    private Post post;

    public Comment() {}

    public Comment(String username, String content, Date commentDate, Post post) {
        this.content=content;
        this.username=username;
        this.commentDate=commentDate;
        this.post=post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
