package co.twibble.dao;

import co.twibble.model.Post;
import co.twibble.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The PostDAO class
 *
 * @author  Andy McCall
 * @version 0.2
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

    public List<Post> getAllPosts() {
        Criteria criteria = getSession().createCriteria(Post.class);
        criteria.addOrder(Order.desc("postDate"));
        return(List<Post>) criteria.list();
    }

    public List<Post> getAllPosts(String userName) {
        Criteria criteria = getSession().createCriteria(Post.class);
        criteria.add(Restrictions.eq("userName",userName));
//        criteria.add(Restrictions.eq("userName",userName));
        criteria.addOrder(Order.desc("postDate"));
        return(List<Post>) criteria.list();
    }

    public List<Post> getPostByPath(int year, int month, int day, String postName) {
        Criteria criteria = getSession().createCriteria(Post.class);

        Date startDate = new Date();
        Date endDate;

        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(year + "-" + month + "-" + day);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DATE, 1);
        endDate = calendar.getTime();

        criteria.add(Restrictions.between("postDate", startDate, endDate));
        criteria.add(Restrictions.eq("postName",postName));
        criteria.setMaxResults(1);

        return (List<Post>) criteria.list();

    }



}
