package demo.eu.controller;

import demo.eu.common.BaseResult;
import demo.eu.entity.User;
import demo.eu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/1
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public BaseResult<User> queryById(@PathVariable("id") Long id) {
        return BaseResult.success(userService.queryById(id));
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}

