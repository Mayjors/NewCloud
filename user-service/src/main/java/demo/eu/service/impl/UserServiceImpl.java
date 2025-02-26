package demo.eu.service.impl;

import demo.eu.entity.User;
import demo.eu.mapper.UserMapper;
import demo.eu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) {
        return userMapper.findById(id);
    }
}

