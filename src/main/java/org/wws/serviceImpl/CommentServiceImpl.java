package org.wws.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wws.dao.CommentDAO;
import org.wws.pojo.Comment;
import org.wws.pojo.Post;
import org.wws.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	
	@Override
	public void addComment(Comment comment) {
		commentDAO.addComment(comment);
	}

	@Override
	public List<Comment> listComments() {
		return commentDAO.listComments();
	}

	@Override
	public Comment getComment(Integer id) {
		return commentDAO.getComment(id);
	}

	@Override
	public void removeComment(Integer id) {
		commentDAO.removeComment(id);
	}

	@Override
	public List<Comment> listCommentsByPost(Post post) {
		return commentDAO.listCommentsByPost(post);
	}

}
