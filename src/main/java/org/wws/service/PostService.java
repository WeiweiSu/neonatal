package org.wws.service;

import java.util.List;

import org.wws.pojo.Post;

public interface PostService {

	public void addPost(Post post);
	public List<Post> listPosts();
	public Post getPost(Integer id);
	public void removePost(Integer id);
	
	public List<Post> listPostsByUserName(String username);
	
}
