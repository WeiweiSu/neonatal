package org.wws.dao;

import java.util.List;

import org.wws.pojo.Comment;
import org.wws.pojo.Post;

public interface CommentDAO {

	public void addComment(Comment comment);
	public List<Comment> listComments();
	public Comment getComment(Integer id);
	public void removeComment(Integer id);
	
	public List<Comment> listCommentsByPost(Post post);
}
