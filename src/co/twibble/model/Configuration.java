package co.twibble.model;

import javax.persistence.*;

/**
 * The Configuration class is the class that holds options
 * about the blog, such as its Title and URL
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-02-18
 */

//** TODO: Document Configuration class with JavaDoc
//** TODO: Unit tests for Configuration class

@Entity
@Table(name = "tw_configuration")
public class Configuration {

    @Id
    @GeneratedValue
    @Column(name = "blogId")
    private int blogId;

    @Column(name = "blogTitle")
    private String blogTitle;

    @Column(name = "blogTagLine")
    private String blogTagLine;

    @Column(name = "blogBaseURL")
    private String blogBaseURL;

    @Column(name = "numberOfPostsToDisplay")
    private int numberOfPostsToDisplay;

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogBaseURL() {
        return blogBaseURL;
    }

    public String getBlogTagLine() {
        return blogTagLine;
    }

    public void setBlogTagLine(String blogTagLine) {
        this.blogTagLine = blogTagLine;
    }

    public void setBlogBaseURL(String blogBaseURL) {
        this.blogBaseURL = blogBaseURL;
    }

    public int getNumberOfPostsToDisplay() {
        return numberOfPostsToDisplay;
    }

    public void setNumberOfPostsToDisplay(int numberOfPostsToDisplay) {
        this.numberOfPostsToDisplay = numberOfPostsToDisplay;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogBaseURL='" + blogBaseURL + '\'' +
                ", numberOfPostsToDisplay='" + numberOfPostsToDisplay + '\'' +
                '}';
    }
}
