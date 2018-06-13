package mangosoft.controller;

import mangosoft.model.User;
import mangosoft.response.UsersListResponse;
import mangosoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User register) {
        User user = new User(register.getUsername(), passwordEncoder.encode(register.getPassword()), register.getFirstName(), register.getLastName());
        userService.save(user);
    }

    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public UsersListResponse getUserList(@RequestParam int page, @RequestParam int size, @RequestParam boolean asc, @RequestParam String property){
        UsersListResponse usersListResponse = new UsersListResponse();
        usersListResponse.setCount(userService.countUsers());
        usersListResponse.setUsersList(userService.findAll(page, size, asc, property));

        return usersListResponse;
    }

    @RequestMapping(value = "/dashboard/update/{username}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable(value = "username") String username, @RequestBody User update){
        User user = userService.findByUsername(username);
        user.setFirstName(update.getFirstName());
        user.setLastName(update.getLastName());
        return userService.save(user);
    }

    @RequestMapping(value = "/dashboard/delete/{username}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "username") String username){
        userService.deleteUser(username);
    }
}
