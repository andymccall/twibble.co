package co.twibble.dao;

import co.twibble.model.Post;

import java.awt.print.Pageable;
import java.util.List;

/**
 * The UserDAO class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-22
 */
public interface PostDAO {
    public void addPost(Post post);
    public void updatePost(Post post);
    public List<Post> getAllPosts();
    public List<Post> getAllPosts(String userName);
    public List<Post> getPostByPath(int year, int month, int day, String postName);
}
