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

    ArrayList<Post> posts = new ArrayList();

    ConfigurationService configurationService;
    UserService userService;
    PostService postService;

    @Autowired
    public void setConfigurationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
        configuration = configurationService.getConfiguration(1);
    }

// TODO: Uncomment once UserService/DAO and PostService/DAO are implemented
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
//
//    @Autowired
//    public void setPostService(PostService postService) {
//        this.postService = postService;
//    }

    public TwibbleController() {

        user.setFirstName("Andy");
        user.setLastName("McCall");
        user.setUserName("andymccall");
        user.setEmailAddress("mailme@andymccall.co.uk");
        user.setDisplayName("Andy McCall");
        user.setUserStatus(UserStatus.ACTIVE);
        user.setUserType(UserType.ADMINISTRATOR);

        Post post = new Post();
        post.setPostTitle("Very Berry Smoothie");
        post.setPostContents("<p>The recipe for the smoothie I've been having most mornings is:</p>" +
                "<ul>" +
                "<li>Half a cup of blueberries</li>" +
                "<li>Half a cup of raspberries</li>" +
                "<li>Half a cup of strawberries</li>" +
                "<li>Half a cup of curly kale</li>" +
                "<li>Two desert spoons of plain yoghurt</li>" +
                "<li>A cup of almond milk</li>" +
                "</ul>" +
                "<p>Blend in blender or smoothie maker for 60 seconds.  Chill before drinking.  Watch out for kale and strawberry seeds in-between your teeth after drinking!</p>");
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

    }

    @RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
    public String homepage(Model model) {

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

        posts.add(post);

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

        configurationService.addConfiguration(configuration);

        return "redirect:/admin/general";

    }

}
