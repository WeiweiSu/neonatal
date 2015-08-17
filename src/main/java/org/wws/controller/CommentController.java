package org.wws.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wws.pojo.Comment;
import org.wws.pojo.Post;
import org.wws.service.CommentService;
import org.wws.service.PostService;

@Controller
@RequestMapping("/comments")
public class CommentController {

	@Autowired
    private PostService postService;


    @Autowired
    private CommentService commentService;
	
	
	@RequestMapping(value="/{postID}", method= RequestMethod.GET)
    public String listComments(@PathVariable Integer postID, Model model ) {
        Post post = postService.getPost(postID);
        List<Comment> commentList = post.getComments();

        model.addAttribute("comment", new Comment());
        model.addAttribute("post", post);
        model.addAttribute("commentList", commentList);

        return "user/postdetail";
    }

    @RequestMapping(value="/{postID}", method= RequestMethod.POST)
    public String addBook(@Valid Comment comment, BindingResult result, @PathVariable Integer postID) throws IOException {
        if (result.hasErrors()) {
            return "user/postdetail";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
        System.out.println("username for comment is: " + username);
		
        Post post = postService.getPost(postID);
        comment.setUsername(username);
        comment.setCommentDate(new Date());
        comment.setPost(post);
        post.getComments().add(comment);
        commentService.addComment(comment);
        

        return "redirect:/comments/" + postID;
    }


    @RequestMapping(value="/{postID}/image", method=RequestMethod.GET)
    public @ResponseBody String getImage(@PathVariable Integer postID, HttpServletResponse response) throws IOException {
    	Post post = postService.getPost(postID);
    	String url = post.getUrl();
    	
    	if(url != null) {
    		File image = new File(url);
        	FileInputStream fis = new FileInputStream(image);
        	ServletOutputStream op = response.getOutputStream();
        	
        	response.setContentType("image/jpeg");
	    	response.setContentLength((int)image.length());
	    	response.setHeader("Content-Disposition",
	    			"attachment; filename=\"image" + post.getId() + ".jpg\"");
	
	    	byte[] bufferData = new byte[1024];
	    	        int read=0;
	    	        while((read = fis.read(bufferData))!= -1){
	    	            op.write(bufferData, 0, read);
	    	        }

	    	op.flush();
	    	op.close();
	    	fis.close();
	    	
    	}
    	
    	return "";
    }

	
}
