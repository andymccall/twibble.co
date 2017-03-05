package co.twibble.model;

import javax.persistence.*;

/**
 * The Category class is the class that stores
 * user generated categories
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-03-05
 */

//** TODO: Document User class with JavaDoc

@Entity
@Table(name = "tw_category")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "categoryId")
    private int categoryId;

    @Column(name = "parentId")
    private int parentId;

    @Column(name = "categoryName")
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", parentId=" + parentId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
