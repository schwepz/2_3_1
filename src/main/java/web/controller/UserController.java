
package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
    private  UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("userList",userService.listUsers());
        return "index";
    }
    @GetMapping("/user-create")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user-create";
    }
    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/user-update/{id}")
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "/user-update";
    }
    @PatchMapping("/user-update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/";
    }
    @DeleteMapping("user-delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/";
    }
}