package com.transcomics.transcomics.repositoriesTest;

import com.transcomics.transcomics.model.req.LoginReq;
import com.transcomics.transcomics.services.JwtService;
import com.transcomics.transcomics.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Le-Hong-Quan
 * Date: 28/05/2024
 * Time: 15:37
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Test
    public void testLogin() {
        String username = "admin";
        String password = "admin";
        var loginReq = new LoginReq();
        loginReq.setUsername(username);
        loginReq.setPassword(password);
        var jwtModelResponse = userService.login(loginReq);
        System.out.println("token: "+jwtModelResponse.getToken());
        System.out.println("refreshToken: "+jwtModelResponse.getRefreshToken());
    }

    @Test
    public void getUserFromToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiQURNSU4iLCJzdWIiOiIwYTdkMjY2Mi00MzcyLTRjNTQtOGE2NS1hODAxYTJkYTU2YmUiLCJpYXQiOjE3MTY4ODY3NDksImV4cCI6MTcxNjg5MDM0OX0.KCeWxzQG-7lgGmgngIw4h4w5LNZe5RkciTOJYBd-WR4";
        var user = jwtService.extractUserId(token);
        System.out.println("user: "+user);
    }
}
