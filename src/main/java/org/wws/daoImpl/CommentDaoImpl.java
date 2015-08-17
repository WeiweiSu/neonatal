package org.wws.daoImpl;

import java.util.List;





import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wws.dao.CommentDAO;
import org.wws.pojo.Comment;
import org.wws.pojo.Post;

@Repository
public class CommentDaoImpl implements CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addComment(Comment comment) {
		sessionFactory.getCurrentSession().save(comment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> listComments() {
		return sessionFactory.getCurrentSession().createQuery("from Comment").list();
	}

	@Override
	public Comment getComment(Integer id) {
		return (Comment) sessionFactory.getCurrentSession().load(Comment.class, id);
	}

	@Override
	public void removeComment(Integer id) {
		Comment comment = (Comment) sessionFactory.getCurrentSession().get(Comment.class, id);
        if (null != comment) {
        	try {
        		sessionFactory.getCurrentSession().delete(comment);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> listCommentsByPost(Post post) {
		Query q = sessionFactory.getCurrentSession().createQuery("From Comment as c Where c.post = :post");
		q.setParameter("post", post);
		List list = q.list();
		
		return list;
	}

}
