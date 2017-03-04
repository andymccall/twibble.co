package co.twibble.model;

/**
 * The PostStatus enum contains details
 * about a post status, such as if it is
 * a draft, published
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-03-01
 */
public enum PostStatus {
    PUBLISHED("Published"),
    NOT_PUBLISHED("Not Published"),
    DRAFT("Draft"),
    DELETED("Deleted");

    private final String displayName;

    PostStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}