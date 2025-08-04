package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("user", userService.getUser());
        return "list";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam ("name") String name,
                          @RequestParam ("surname") String surname,
                          @RequestParam ("age") int age) {
        User user = new User(name, surname, age);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam ("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam ("id") Long id,
                             @RequestParam ("name") String name,
                             @RequestParam ("surname") String surname,
                             @RequestParam ("age") int age) {
        userService.updateUser(id, name, surname, age);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam ("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
