package org.wws.controller;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.wws.pojo.Post;
import org.wws.pojo.User;
import org.wws.service.CommentService;
import org.wws.service.PostService;
import org.wws.service.UserService;

/**
 * Created by weiweisu on 4/13/14.
 */
@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;


    @RequestMapping(method= RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("postList", postService.listPosts());

        return "user/post";
    }



    @RequestMapping(method= RequestMethod.POST)
    public String addPost(@Valid Post post, BindingResult result, HttpServletRequest request) throws IOException {
        if (result.hasErrors()) {
            return "user/post";
        }

        CommonsMultipartFile multiFile = post.getImage();
        Date date = new Date();
        if(multiFile.getSize() != 0) {
        	
            //File dest = new File("/Users/weiweisu/Documents/workspace-sts/Contact_HW/src/main/webapp/WEB-INF/uploads/", multiFile.getOriginalFilename() );
            File dest = new File("/Users/weiweisu/Documents/workspace-sts/WebFinalProject/src/main/webapp/WEB-INF/uploads/", date.toString());
            
            multiFile.transferTo(dest);
            //String url = dest.getAbsolutePath();
            String url = "../uploads/" + date.toString();
            System.out.println(url);
            post.setUrl(url);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

        User user = userService.getUserByUserName(username);
        post.setUsername(username);
        post.setAuthor(user);
        post.setLike(0);
        post.setPostDate(date);
        post.setCommentNum(0);
        
        postService.addPost(post);

        return "redirect:/posts";
    }

    






//    @RequestMapping(method= RequestMethod.GET)
//    public String listPosts(Model model) {
//        model.addAttribute("post", new Post());
//        model.addAttribute("postList", postService.findAll());
//
//        List posts = postService.findAll();
//        System.out.println("posts are : " + posts);
//
//        return "community/posts";
//    }
//
//
//
//    @RequestMapping(method= RequestMethod.POST)
//    public String addPost(@Valid Post post, BindingResult result) throws IOException {
//        System.out.println("Post info: " + post.getUser() + post.getDesc() + post.getDesc());
//
//        List posts = postService.findAll();
//        System.out.println("posts are : " + posts);
//
//        if (result.hasErrors()) {
//            return "community/posts";
//        }
//
//
//        CommonsMultipartFile multiFile = post.getImage();
//        File dest = new File("/Users/weiweisu/Documents/repository/finaluploads/", multiFile.getOriginalFilename());
//        multiFile.transferTo(dest);
//        String url = dest.getAbsolutePath();
//        post.setUrl(url);
//
//        User user = userService.findByUserName(post.getUser());
//        post.setAuthor(user);
//
//        post.setPostDate(new Date());
//
//        postService.create(post);
//
//        return "redirect:/community/posts";
//    }
//
//    @RequestMapping(value="/{postID}/detail", method= RequestMethod.GET)
//    public String listComments(@PathVariable Integer postID, Model model ) {
//        Post post = postService.findOne(postID);
//        List comments = post.getComments();
//
//
//        model.addAttribute("comment", new Comment());
//        model.addAttribute("post", post);
//        model.addAttribute("comments", comments);
//
//        return "community/postdetail";
//    }
//
//    @RequestMapping(value="/comment", method= RequestMethod.POST)
//    public String addBook(@Valid Comment comment, BindingResult result, @RequestParam("postID") String postID, Model model) throws IOException {
//        if (result.hasErrors()) {
//            return "community/postdetail";
//        }
//
//        Post post = postService.findOne(Integer.parseInt(postID));
//        comment.setCommentDate(new Date());
//        comment.setPost(post);
//        commentService.create(comment);
//
//        return listComments(Integer.parseInt(postID), model);
//    }


}
