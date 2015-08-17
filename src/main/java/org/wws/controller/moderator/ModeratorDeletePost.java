package org.wws.controller.moderator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wws.service.PostService;

@Controller
@RequestMapping("/moderator/deletePost")
public class ModeratorDeletePost {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value="{postID}", method=RequestMethod.GET)
	public String delete(@PathVariable Integer postID) {
		postService.removePost(postID);
		
		return "moderator/deleteSuccess";
	}
}
