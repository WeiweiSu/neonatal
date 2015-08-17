package org.wws.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wws.dao.PostDAO;
import org.wws.pojo.Post;
import org.wws.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO postDAO;
	
	@Override
	public void addPost(Post post) {
		postDAO.addPost(post);
	}

	@Override
	public List<Post> listPosts() {
		return postDAO.listPosts();
	}

	@Override
	public Post getPost(Integer id) {
		return postDAO.getPost(id);
	}

	@Override
	public void removePost(Integer id) {
		postDAO.removePost(id);
	}

	@Override
	public List<Post> listPostsByUserName(String username) {
		return postDAO.listPostsByUserName(username);
	}

}
