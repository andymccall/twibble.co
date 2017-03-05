package co.twibble.model;

import javax.persistence.*;

/**
 * The Tag class is the class that stores
 * user generated tags
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-03-05
 */

//** TODO: Document User class with JavaDoc

@Entity
@Table(name = "tw_tag")
public class Tag {

    @Id
    @GeneratedValue
    @Column(name = "tagId")
    private int tagId;

    @Column(name = "tagName")
    private String tagName;

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
