package co.twibble.dao;

import co.twibble.model.Post;
import org.hibernate.Criteria;
import org.hibernate.Query;
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

        Query query = getSession().createQuery("from Post order by postDate desc");

        return(List<Post>) query.list();
    }

    public List<Post> getAllPosts(String userName) {

        Query query = getSession().createQuery("select p from Post as p join p.postUser as pu where pu.userName = :userName order by p.postDate desc ");
        query.setString("userName", userName);

        return(List<Post>) query.list();
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

    public List<Post> getPostByYear(int year) {

        Query query = getSession().createQuery("FROM Post WHERE year(postDate) = :year")
                .setParameter("year", year);

        return (List<Post>) query.list();

    }

    public List<Post> getPostByYearMonth(int year, int month) {

        Query query = getSession().createQuery("FROM Post WHERE year(postDate) = :year AND month(postDate) = :month")
                .setParameter("year", year)
                .setParameter("month", month);

        return (List<Post>) query.list();

    }

    public List<Post> getPostByYearMonthDay(int year, int month, int day) {

        Query query = getSession().createQuery("FROM Post WHERE year(postDate) = :year AND month(postDate) = :month AND day(postDate) = :day")
                .setParameter("year", year)
                .setParameter("month", month)
                .setParameter("day", day);

        return (List<Post>) query.list();

    }

}
