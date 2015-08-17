package org.wws.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wws.dao.PostDAO;
import org.wws.pojo.Post;

@Repository
public class PostDaoImpl implements PostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addPost(Post post) {
		sessionFactory.getCurrentSession().save(post);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> listPosts() {
		return sessionFactory.getCurrentSession().createQuery("From Post").setCacheable(true).list();
	}

	@Override
	public Post getPost(Integer id) {
		return (Post) sessionFactory.getCurrentSession().get(Post.class, id);
	}

	@Override
	public void removePost(Integer id) {
		Post post = (Post) sessionFactory.getCurrentSession().get(Post.class, id);
        if (null != post) {
        	try {
        		sessionFactory.getCurrentSession().delete(post);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> listPostsByUserName(String username) {
		Query query =  sessionFactory.getCurrentSession().createQuery("from Post where username = :username");
		query.setParameter("username", username);
		return query.list();
	}

}
