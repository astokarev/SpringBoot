package PP_3_1_1.SpringBoot.controller;

import PP_3_1_1.SpringBoot.model.User;
import PP_3_1_1.SpringBoot.service.UserService;
import PP_3_1_1.SpringBoot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:users";
    }


    @GetMapping("/users")
    public String showUsers(Model model) {

        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add";
    }

    @PostMapping("/input")
    public String inputUser(@ModelAttribute("user") User user) {

        userService.addUser(user);
        return "redirect:users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {

        model.addAttribute("editable_user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("editable_user") User user, @PathVariable("id") Long id) {
        userService.editUser(id, user);
        return "redirect:users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {

        userService.deleteUser(id);
        return "redirect:users";
    }

}
