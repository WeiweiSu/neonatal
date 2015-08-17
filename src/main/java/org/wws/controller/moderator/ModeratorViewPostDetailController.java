package org.wws.controller.moderator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wws.pojo.Post;
import org.wws.service.CommentService;
import org.wws.service.PostService;

@Controller
@RequestMapping("/moderator/postdetail")
public class ModeratorViewPostDetailController {

	@Autowired
	private PostService postService;
	
	@Autowired 
	private CommentService commentService;
	
	@RequestMapping(value="/{postID}", method=RequestMethod.GET)
	public String showDetail(@PathVariable Integer postID, Model model) {
		Post post = postService.getPost(postID);
		List commentList = commentService.listComments();
		
		model.addAttribute("post", post);
		model.addAttribute("commentList", commentList);
		
		return "moderator/postDetail";
	}
}
