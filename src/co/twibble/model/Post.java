package co.twibble.model;

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

public class Post {

    private String postTitle;
    private String postContents;
    private Date postDate;
    private User postUser;

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
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
                ", postContents='" + postContents + '\'' +
                ", postDate=" + postDate +
                ", postUser=" + postUser +
                '}';
    }
}
