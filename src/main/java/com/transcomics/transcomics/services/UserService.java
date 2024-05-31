package com.transcomics.transcomics.services;

import com.transcomics.transcomics.model.UserDetailModel;
import com.transcomics.transcomics.model.req.LoginReq;
import com.transcomics.transcomics.model.req.RegisterUserReq;
import com.transcomics.transcomics.model.res.JwtModelResponse;
import com.transcomics.transcomics.model.res.UserModelRes;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Le-Hong-Quan
 * Date: 26/05/2024
 * Time: 10:59
 */
public interface UserService {
    UserDetailModel getUserDetailModelByUserId(String userId);

    String registerUser(RegisterUserReq registerUserReq);

    JwtModelResponse login(LoginReq loginReq);

    UserModelRes getUserModelResByUserId(String userId);
}
