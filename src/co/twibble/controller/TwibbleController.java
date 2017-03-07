package co.twibble.controller;

import co.twibble.model.*;
import co.twibble.service.ConfigurationService;
import co.twibble.service.PostService;
import co.twibble.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * The TwibbleController class is the controller for the home page
 *
 * @author  Andy McCall
 * @version 0.4
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
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }


    @RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
    public String homepage(Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        Pager<Post> pager = new Pager<>(postService.getAllPosts(),configuration.getNumberOfPostsToDisplay());

        model.addAttribute("beginIndex", pager.getPage(1).getFirstPage());
        model.addAttribute("endIndex", pager.getPage(1).getLastPage());
        model.addAttribute("currentIndex", 1);
        model.addAttribute("totalPageCount", pager.getNumberOfPages());
        model.addAttribute("posts", pager.getPage(1).getContents());

        return "index";
    }

    @RequestMapping(value = { "post/{year}/{month}/{day}/{postName}" }, method = RequestMethod.GET)
    public String singlePost(@PathVariable Integer year,
                         @PathVariable Integer month,
                         @PathVariable Integer day,
                         @PathVariable String postName, Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        List<Post> posts;

        posts = postService.getPostByPath(year, month, day, postName);

        model.addAttribute("posts", posts.get(0));

        return "index";
    }

    @RequestMapping(value = { "post/{year}" }, method = RequestMethod.GET)
    public String yearPost(@PathVariable Integer year, Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        List<Post> posts;

        posts = postService.getPostByYear(year);

        model.addAttribute("posts", posts);

        return "index";
    }

    @RequestMapping(value = { "post/page/{page}" }, method = RequestMethod.GET)
    public String pagePost(@PathVariable Integer page, Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        Pager<Post> pager = new Pager<>(postService.getAllPosts(),configuration.getNumberOfPostsToDisplay());

        model.addAttribute("beginIndex", pager.getPage(page).getFirstPage());
        model.addAttribute("endIndex", pager.getPage(page).getLastPage());
        model.addAttribute("currentIndex", page);
        model.addAttribute("totalPageCount", pager.getNumberOfPages());
        model.addAttribute("posts", pager.getPage(page).getContents());

        return "index";
    }

    @RequestMapping(value = { "post/{year}/{month}" }, method = RequestMethod.GET)
    public String yearAndMonthPost(@PathVariable Integer year,
                           @PathVariable Integer month,
                           Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        List<Post> posts;

        posts = postService.getPostByYearMonth(year, month);

        model.addAttribute("posts", posts);

        return "index";
    }

    @RequestMapping(value = { "post/{year}/{month}/{day}" }, method = RequestMethod.GET)
    public String yearAndMonthAndDayPost(@PathVariable Integer year,
                           @PathVariable Integer month,
                           @PathVariable Integer day,
                           Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        List<Post> posts;

        posts = postService.getPostByYearMonthDay(year, month, day);

        model.addAttribute("posts", posts);

        return "index";
    }

    @RequestMapping(value = { "user/{username}" }, method = RequestMethod.GET)
    public String single(@PathVariable String username, Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        List<Post> posts;

        posts = postService.getPostByUsername(username);

        model.addAttribute("posts", posts);

        return "index";
    }

    @RequestMapping(value = { "login" }, method = RequestMethod.GET)
    public String login(Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        return "login";
    }

    @RequestMapping(value = { "logout" }, method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:login";
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
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        Post post = new Post();
        post.setPostTitle("Enter the title here...");
        post.setPostContents("Enter the contents here...");
        post.setPostDate(new Date());

        model.addAttribute("post", post);

        return "admin/post";
    }

    @RequestMapping(value = { "admin/listpost" }, method = RequestMethod.GET)
    public String adminListPost(Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        List<Post> posts;

        posts = postService.getPostByPage(1, configuration.getNumberOfPostsToDisplay());

        model.addAttribute("posts", posts);

        return "admin/listpost";
    }

    @RequestMapping(value = { "admin/post/{year}/{month}/{day}/{postName}" }, method = RequestMethod.GET)
    public String adminEditPost(@PathVariable Integer year,
                             @PathVariable Integer month,
                             @PathVariable Integer day,
                             @PathVariable String postName, Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        List<Post> posts;

        posts = postService.getPostByPath(year, month, day, postName);

        model.addAttribute("post", posts.get(0));

        return "admin/editpost";
    }

    @RequestMapping(value = "admin/post", method = RequestMethod.POST)
    public String saveAdminPost(@ModelAttribute("Post") Post newPost) {

        Post post = new Post();
        post.setPostTitle(newPost.getPostTitle());
        post.setPostContents(newPost.getPostContents());
        post.setPostDate(newPost.getPostDate());
        post.setPostStatus(newPost.getPostStatus());
        post.setPostUser(user);

        postService.addPost(post);

        return "redirect:" + configuration.getBlogBaseURL();

    }

    @RequestMapping(value = "admin/editpost", method = RequestMethod.POST)
    public String saveAdminEditPost(@ModelAttribute("Post") Post editedPost,
                                    final RedirectAttributes redirectAttributes) {

        Post post = editedPost;
        Post originalPost = postService.getPostById(post.getPostId());
        String result;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUserName(auth.getName());

        if ((originalPost.getPostUser().getUserName() == user.getUserName()) | (user.getUserType() == UserType.ADMINISTRATOR)) {
            post.setPostUser(user);
            postService.updatePost(post);
            result = "redirect:" + configuration.getBlogBaseURL();
        } else {
            redirectAttributes.addFlashAttribute("message", "Insufficient privileges to edit other users post!");
            result = "redirect:/admin/message";
        }

        return result;

    }

    @RequestMapping(value = { "admin/user" }, method = RequestMethod.GET)
    public String adminUser(Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        User newUser = new User();
        model.addAttribute("user", newUser);

        return "admin/user";
    }

    @RequestMapping(value = { "admin/user/{username}" }, method = RequestMethod.GET)
    public String adminUser(@PathVariable String username, Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        User user = userService.getUserByUserName(username);

        model.addAttribute("user", user);

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
        configuration = configurationService.getConfiguration(1);
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

    @RequestMapping(value = { "admin/message" }, method = RequestMethod.GET)
    public String adminMessage(Model model) {
        configuration = configurationService.getConfiguration(1);
        model.addAttribute("configuration", configuration);

        return "admin/message";
    }

}
