package org.wws.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by weiweisu on 3/18/14.
 */
@Entity
@Table(name="POST")
@Indexed
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="post")
public class Post implements Serializable {

    @Id
    @Column(name = "post_id", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="title",nullable = false, length=50)
    @NotEmpty
    @Size(min=1, max=255)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String title;

    @Column(name="postDate")
    @Field(index=Index.YES, analyze=Analyze.NO, store=Store.YES)
    @DateBridge(resolution=Resolution.DAY)
    private Date postDate;

    @Column(name="likes")
    private int like;

    @Column(name="commentNum")
    private int commentNum;

    @IndexedEmbedded
    @OneToMany(mappedBy="post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList();

//    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<PhotoUrl> photosUrl = new ArrayList();

    @Column(name="description")
    @NotEmpty
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String desc;

    @IndexedEmbedded
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="fk_user", nullable = false)
    private User author;

    @Transient
    private String username;

    @Column(name="url")
    private String url;

    @Transient
    private CommonsMultipartFile image;









    public Post() {}

    public Post(String title, Date postDate, String desc) {
        this.desc=desc;
        this.postDate=postDate;
    }



    

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CommonsMultipartFile getImage() {
        return image;
    }

    public void setImage(CommonsMultipartFile image) {
        this.image = image;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

//    public List<PhotoUrl> getPhotosUrl() {
//        return photosUrl;
//    }
//
//    public void setPhotosUrl(List<PhotoUrl> photosUrl) {
//        this.photosUrl = photosUrl;
//    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
