package com.AI_snakes.backend.service.impl.user.account;

import com.AI_snakes.backend.mapper.UserMapper;
import com.AI_snakes.backend.pojo.User;
import com.AI_snakes.backend.service.user.account.RegisterService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String, String> map = new HashMap<>();
        if (username == null) {
            map.put("error_message", "Username cannot be empty");
            return map;
        }

        if (password == null || confirmedPassword == null) {
            map.put("error_message", "Password cannot be empty");
            return map;
        }

        username = username.trim();
        if (username.length() == 0) {
            map.put("error_message", "Username cannot be empty");
            return map;
        }

        if (password.length() == 0 || confirmedPassword.length() == 0) {
            map.put("error_message", "Password cannot be empty");
            return map;
        }

        if (username.length() > 100) {
            map.put("error_message", "Username length exceeds limit");
            return map;
        }

        if (password.length() > 100 || confirmedPassword.length() > 100) {
            map.put("error_message", "Password length exceeds limit");
            return map;
        }

        if (!password.equals(confirmedPassword)) {
            map.put("error_message", "Passwords don't match");
            return map;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
            map.put("error_message", "Username already exists");
            return map;
        }

        String encodedPassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/165979_lg_cdcbe79299.jpg";
        User user = new User(null, username, encodedPassword, photo);
        userMapper.insert(user);

        map.put("error_message", "success");
        return map;

    }
}
