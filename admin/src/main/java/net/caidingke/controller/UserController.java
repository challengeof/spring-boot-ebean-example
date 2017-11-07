package net.caidingke.controller;

import lombok.extern.slf4j.Slf4j;
import net.caidingke.domain.User;
import net.caidingke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bowen.
 */
@RestController
@Slf4j
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("name")
    @ResponseBody
    public User findByUsername(String username) {
        return userService.findByUsername(username);
    }
}
