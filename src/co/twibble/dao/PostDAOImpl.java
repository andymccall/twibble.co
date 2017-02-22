package co.twibble.dao;

import co.twibble.model.Post;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The PostDAO class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-22
 */
@Repository("postDAO")
public class PostDAOImpl extends AbstractDAO implements PostDAO {

    public void addPost(Post post) {
        persist(post);
    }

    public void updatePost(Post post) {
        update(post);
    }

    public Post getPostById(int postId) {
        Criteria criteria = getSession().createCriteria(Post.class);
        criteria.add(Restrictions.eq("postId",postId));
        return (Post) criteria.uniqueResult();
    }

    public List<Post> getRecentPosts(int numberOfPosts) {
        Criteria criteria = getSession().createCriteria(Post.class);
        criteria.setMaxResults(numberOfPosts);
        return (List<Post>) criteria.list();
    }


}
