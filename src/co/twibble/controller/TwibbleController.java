package co.twibble.controller;

import co.twibble.model.Configuration;
import co.twibble.model.Post;
import co.twibble.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * The TwibbleController class is the controller for the home page
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-02-16
 */
@Controller
public class TwibbleController {

    @RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
    public String homepage(Model model) {

        Configuration configuration = new Configuration();

        configuration.setBlogTitle("Twibble");
        configuration.setBlogTagLine("A blogging platform written in Java");
        configuration.setBlogBaseURL("http://localhost:8080/index.html");
        model.addAttribute("configuration", configuration);

        User user = new User();
        user.setFirstName("Andy");
        user.setLastName("McCall");
        user.setUserName("andymccall");
        user.setEmailAddress("mailme@andymccall.co.uk");

        ArrayList<Post> posts = new ArrayList();

        Post post = new Post();
        post.setPostTitle("Test Blog Post 1");
        post.setPostContents("This is the first blog post, within Twibble.");
        post.setPostUser(user);
        posts.add(post);

        Post post2 = new Post();
        post2.setPostTitle("Test Blog Post 2");
        post2.setPostContents("This is the second blog post, within Twibble.");
        post2.setPostUser(user);
        posts.add(post2);

        Post post3 = new Post();
        post3.setPostTitle("Test Blog Post 3");
        post3.setPostContents("This is the third blog post, within Twibble.");
        post3.setPostUser(user);
        posts.add(post3);

        model.addAttribute("posts", posts);

        return "index";
    }

    @RequestMapping(value = { "about" }, method = RequestMethod.GET)
    public String about(Model model) {

        return "about";
    }

    @RequestMapping(value = { "contact" }, method = RequestMethod.GET)
    public String contact(Model model) {

        return "contact";
    }

    @RequestMapping(value = { "post" }, method = RequestMethod.GET)
    public String post(Model model) {

        return "post";
    }

}
