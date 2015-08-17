package org.wws.controller;

import java.util.List;

import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wws.pojo.Post;

@Controller
@RequestMapping("/hsearch")
public class HibernateSearchController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping(method=RequestMethod.POST)
	public String hibernateSearch(@RequestParam("keyword") String keyword, Model model) throws InterruptedException {
		
		if(keyword == null || "".equals(keyword)) {
			return "searchwarn";
		}
		
		
		//searching
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		
		
		//indexing at the first time
		//fullTextSession.createIndexer().startAndWait();
		
		
		
		QueryBuilder qb = fullTextSession.getSearchFactory()
			    .buildQueryBuilder().forEntity(Post.class).get();
		
		Query luceneQuery = qb.keyword().onFields("title", "desc", "comments.content", "author.username")
				.matching(keyword).createQuery();
		org.hibernate.Query query = fullTextSession.createFullTextQuery(luceneQuery, Post.class);
		
		@SuppressWarnings("unchecked")
		List<Post> result = query.list();
		for(Post p : result) {
			System.out.println(p.getTitle());
		}
		
		
		tx.commit();
		session.close();
		
		model.addAttribute("result", result);
		
		return "hsearch/result";
		
	}
	
}
