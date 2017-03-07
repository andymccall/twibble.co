package co.twibble.service;

import co.twibble.model.Post;

import java.awt.print.Pageable;
import java.util.List;

/**
 * The PostService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-20
 */
public interface PostService {
    public void addPost(Post post);

    public void updatePost(Post post);

    public Post getPostById(int postId);

    public List<Post> getAllPosts();

    public List<Post> getPostByUsername(String userName);

    public List<Post> getPostByPath(int year, int month, int day, String postName);

    public List<Post> getPostByYear(int year);

    public List<Post> getPostByYearMonth(int year, int month);

    public List<Post> getPostByYearMonthDay(int year, int month, int day);

    public List<Post> getPostByPage(int pageNumber, int numberOfPosts);

    public int getNumberOfPosts();
}