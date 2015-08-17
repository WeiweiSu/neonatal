package org.wws.controller.moderator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wws.service.PostService;

@Controller
@RequestMapping("/moderator")
public class ModeratorController {

	@Autowired
	private PostService postService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showPage(Model model) {
		model.addAttribute("postList", postService.listPosts());
		
		return "moderator/posts";
	}
	
	@RequestMapping(value="/{postID}", method=RequestMethod.DELETE)
	@ResponseBody
	public String deletePost(@PathVariable Integer postID) {
		postService.removePost(postID);
		
		return "";
	}
	
	
}
