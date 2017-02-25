package co.twibble.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * The Post class is the class that holds blog posts
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-17
 */

//** TODO: Document Post class with JavaDoc
//** TODO: Unit tests for Post class

@Entity
@Table(name = "tw_post")
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "postId")
    private int postId;

    @Column(name = "postTitle")
    private String postTitle;

    @Column(name = "postName")
    private String postName;

    @Column(name = "postContents")
    private String postContents;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="dd-MMM-yyyy HH:mm")
    private Date postDate;

    @ManyToOne
    @JoinColumn(name="userId")
    private User postUser;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;

        String fixedPostName = postTitle.replaceAll(" ", "-").toLowerCase();
        fixedPostName = fixedPostName.replaceAll("[^\\w-]", "");

        setPostName(fixedPostName);

    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostContents() {
        return postContents;
    }

    public void setPostContents(String postContents) {
        this.postContents = postContents;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public User getPostUser() {
        return postUser;
    }

    public void setPostUser(User postUser) {
        this.postUser = postUser;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postTitle='" + postTitle + '\'' +
                ", postName='" + postName + '\'' +
                ", postContents='" + postContents + '\'' +
                ", postDate=" + postDate +
                ", postUser=" + postUser +
                '}';
    }
}
