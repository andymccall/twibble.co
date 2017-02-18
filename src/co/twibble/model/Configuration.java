package co.twibble.model;

/**
 * The Configuration class is the class that holds options
 * about the blog, such as its Title and URL
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-18
 */

//** TODO: Document Configuration class with JavaDoc
//** TODO: Unit tests for Configuration class

public class Configuration {

    private int blogId;
    private String blogTitle;
    private String blogTagLine;
    private String blogBaseURL;

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

    @Override
    public String toString() {
        return "Configuration{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogBaseURL='" + blogBaseURL + '\'' +
                '}';
    }
}
