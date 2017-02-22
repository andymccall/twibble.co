package co.twibble.controller;

import co.twibble.model.*;
import co.twibble.service.ConfigurationService;
import co.twibble.service.PostService;
import co.twibble.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * The TwibbleController class is the controller for the home page
 *
 * @author  Andy McCall
 * @version 0.3
 * @since   2017-02-16
 */
@Controller
public class TwibbleController {

    Configuration configuration = new Configuration();
    User user = new User();

    ConfigurationService configurationService;
    UserService userService;
    PostService postService;

    @Autowired
    public void setConfigurationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
        configuration = configurationService.getConfiguration(1);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
        user = userService.getUserByUserName("andymccall");
    }

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }


    @RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
    public String homepage(Model model) {

        List<Post> posts;

        posts = postService.getRecentPosts(5);

        model.addAttribute("configuration", configuration);
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

    @RequestMapping(value = { "admin/post" }, method = RequestMethod.GET)
    public String adminPost(Model model) {

        Post post = new Post();
        post.setPostTitle("Enter the title here...");
        post.setPostContents("Enter the contents here...");

        model.addAttribute("configuration", configuration);
        model.addAttribute("post", post);

        return "admin/post";
    }

    @RequestMapping(value = "admin/post", method = RequestMethod.POST)
    public String saveAdminPost(@ModelAttribute("Post") Post newPost) {

        Post post = new Post();
        post.setPostTitle(newPost.getPostTitle());
        post.setPostContents(newPost.getPostContents());
        post.setPostUser(user);

        postService.addPost(post);

        return "redirect:/index";

    }

    @RequestMapping(value = { "admin/user" }, method = RequestMethod.GET)
    public String adminUser(Model model) {

        User newUser = new User();
        model.addAttribute("user", newUser);
        model.addAttribute("configuration", configuration);

        return "admin/user";
    }

    @RequestMapping(value = "admin/user", method = RequestMethod.POST)
    public String saveAdminUser(@ModelAttribute("User") User newUser) {

        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setUserName(newUser.getUserName());
        user.setDisplayName(newUser.getDisplayName());
        user.setEmailAddress(newUser.getEmailAddress());

        userService.addUser(user);

        return "redirect:/admin/user";

    }

    @RequestMapping(value = { "admin/general" }, method = RequestMethod.GET)
    public String adminGeneral(Model model) {

        model.addAttribute("configuration", configuration);

        return "admin/general";
    }

    @RequestMapping(value = "admin/general", method = RequestMethod.POST)
    public String saveAdminGeneral(@ModelAttribute("Configuration") Configuration newConfiguration) {

        configuration.setBlogTitle(newConfiguration.getBlogTitle());
        configuration.setBlogTagLine(newConfiguration.getBlogTagLine());
        configuration.setBlogBaseURL(newConfiguration.getBlogBaseURL());
        configuration.setNumberOfPostsToDisplay(newConfiguration.getNumberOfPostsToDisplay());

        configurationService.updateConfiguration(configuration);

        return "redirect:/admin/general";

    }

}
