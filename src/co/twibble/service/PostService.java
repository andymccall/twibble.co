package co.twibble.service;

import co.twibble.model.Post;

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
    public List<Post> getRecentPosts(int numberOfPosts);
}
