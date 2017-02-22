package co.twibble.service;

import co.twibble.dao.PostDAO;
import co.twibble.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Post> getRecentPosts(int numberOfPosts) {
        return postDAO.getRecentPosts(numberOfPosts);
    }

}
