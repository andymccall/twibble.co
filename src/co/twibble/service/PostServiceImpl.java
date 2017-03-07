package co.twibble.service;

import co.twibble.dao.PostDAO;
import co.twibble.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

/**
 * The PostServiceImpl class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-18
 */

//** TODO: Document PostServiceImpl class with JavaDoc
//** TODO: Unit tests for PostServiceImpl class
@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDAO postDAO;

    public void setPostDAO(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public void addPost(Post post) {
        postDAO.addPost(post);
    }

    public void updatePost(Post post) {
        postDAO.updatePost(post);

    }

    public Post getPostById(int postId) {
        return postDAO.getPostById(postId);
    }

    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }

    public List<Post> getPostByUsername(String userName) {
        return postDAO.getPostByUsername(userName);
    }

    public List<Post> getPostByPath(int year, int month, int day, String postName) {
        return postDAO.getPostByPath(year, month, day, postName);
    }

    public List<Post> getPostByYear(int year) {
        return postDAO.getPostByYear(year);
    }

    public List<Post> getPostByYearMonth(int year, int month) {
        return postDAO.getPostByYearMonth(year, month);
    }

    public List<Post> getPostByYearMonthDay(int year, int month, int day) {
        return postDAO.getPostByYearMonthDay(year, month, day);
    }

    public List<Post> getPostByPage(int pageNumber, int numberOfPosts) {
        return postDAO.getPostByPage(pageNumber, numberOfPosts);

    }

    public int getNumberOfPosts() {
        return postDAO.getNumberOfPosts();
    }

}
