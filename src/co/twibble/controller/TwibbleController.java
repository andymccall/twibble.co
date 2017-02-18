package co.twibble.controller;

import co.twibble.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

        Post post = new Post();

        post.setPostTitle("First blog entry...");
        post.setPostContents("This is the first post!");

        model.addAttribute("post", post);

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
