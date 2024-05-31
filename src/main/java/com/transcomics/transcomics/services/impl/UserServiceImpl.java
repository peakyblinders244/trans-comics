package com.transcomics.transcomics.services.impl;

import com.transcomics.transcomics.common.ErrorCode;
import com.transcomics.transcomics.entities.UserAccount;
import com.transcomics.transcomics.entities.UserLoginData;
import com.transcomics.transcomics.handle.ServiceException;
import com.transcomics.transcomics.model.UserDetailModel;
import com.transcomics.transcomics.model.req.LoginReq;
import com.transcomics.transcomics.model.req.RegisterUserReq;
import com.transcomics.transcomics.model.res.JwtModelResponse;
import com.transcomics.transcomics.model.res.UserModelRes;
import com.transcomics.transcomics.repositories.users.UserAccountRepository;
import com.transcomics.transcomics.repositories.users.UserLoginDataRepository;
import com.transcomics.transcomics.services.JwtService;
import com.transcomics.transcomics.services.UserService;
import com.transcomics.transcomics.utils.PasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Le-Hong-Quan
 * Date: 26/05/2024
 * Time: 11:29
 */
@Service
public class UserServiceImpl implements UserService {

    private UserLoginDataRepository userLoginDataRepository;
    private UserAccountRepository userAccountRepository;

    private JwtService jwtService;

    @Autowired
    public void setUserLoginDataRepository(UserLoginDataRepository userLoginDataRepository) {
        this.userLoginDataRepository = userLoginDataRepository;
    }

    @Autowired
    public void setUserAccountRepository(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Autowired
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }
    @Override
    public UserDetailModel getUserDetailModelByUserId(String userId) {
        UserAccount userAccount = userAccountRepository.findWithUserLoginDataByUserId(userId);
        if (userAccount == null) {
            throw new ServiceException(ErrorCode.USER_NOT_FOUND, userId);
        }
        UserLoginData userLoginData = userAccount.getUserLoginData();
        UserDetailModel userDetailModel = new UserDetailModel();
        userDetailModel.setUserId(userAccount.getUserId());
        userDetailModel.setLoginName(userLoginData != null ?
                userLoginData.getLoginName() : "");
        userDetailModel.setPasswordHash(userLoginData != null ?
                userLoginData.getPasswordHash() : "");
        userDetailModel.setEmailAddress(userLoginData != null ?
                userLoginData.getEmailAddress() : "");
        userDetailModel.setRoleId(userAccount.getRoleId());
        userDetailModel.setTokenGenerationTime(userLoginData != null ?
                userLoginData.getTokenGenerationTime() : null);
        userDetailModel.setEmailValidationStatus(userLoginData != null ?
                userLoginData.getEmailValidationStatusId() : "");
        return userDetailModel;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String registerUser(RegisterUserReq registerUserReq) {
        PasswordEncoder passwordEncoder = PasswordEncoderUtils.getPasswordEncoder(PasswordEncoderUtils.BCrypt);

        String userId = UUID.randomUUID().toString();
        UserLoginData userLoginData = new UserLoginData();
        userLoginData.setUserId(userId);
        userLoginData.setLoginName("admin");
        userLoginData.setPasswordSalt(PasswordEncoderUtils.SALT);
        userLoginData.setPasswordHash(passwordEncoder.encode("admin"));
        userLoginData.setHashAlgorithmId(PasswordEncoderUtils.BCrypt);
        userLoginData.setEmailAddress(registerUserReq.getEmailAddress());
        userLoginData.setEmailValidationStatusId("E");
        userLoginData.setConfirmationToken(UUID.randomUUID().toString());
        userLoginData.setTokenGenerationTime(new Date());

        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(userId);
        userAccount.setFirstName(registerUserReq.getFirstName());
        userAccount.setLastName(registerUserReq.getLastName());
        userAccount.setGender(registerUserReq.getGender());
        userAccount.setDateOfBirth(new Date());
        userAccount.setRoleId("USER");

        userAccountRepository.save(userAccount);
        userLoginDataRepository.save(userLoginData);
        return userId;
    }

    @Override
    public JwtModelResponse login(LoginReq loginReq) {
        UserLoginData userLoginData = userLoginDataRepository.findWithUserAccountByLoginName(loginReq.getUsername());
        // check exist
        if (userLoginData == null) {
            throw new ServiceException(ErrorCode.USER_NOT_FOUND, loginReq.getUsername());
        }
        // check password
        if (!PasswordEncoderUtils.getPasswordEncoder(userLoginData.getHashAlgorithmId())
                .matches(loginReq.getPassword(), userLoginData.getPasswordHash())) {
            throw new ServiceException(ErrorCode.PASSWORD_NOT_MATCH, loginReq.getUsername());
        }

        // create token
        UserDetailModel userDetailModel = new UserDetailModel();
        userDetailModel.setUserId(userLoginData.getUserId());
        userDetailModel.setLoginName(userLoginData.getLoginName());
        userDetailModel.setPasswordHash(userLoginData.getPasswordHash());
        userDetailModel.setEmailAddress(userLoginData.getEmailAddress());
        userDetailModel.setRoleId(userLoginData.getUserAccount() != null ?
                userLoginData.getUserAccount().getRoleId() :
                null);
        userDetailModel.setTokenGenerationTime(userLoginData.getTokenGenerationTime());
        userDetailModel.setEmailValidationStatus(userLoginData.getEmailValidationStatusId());
        String token = jwtService.generateToken(userDetailModel);
        String refreshToken = jwtService.generateRefreshToken(userDetailModel);
        return new JwtModelResponse(token, refreshToken);
    }

    @Override
    public UserModelRes getUserModelResByUserId(String userId) {
        UserAccount userAccount = userAccountRepository.findWithUserLoginDataByUserId(userId);
        if (userAccount == null) {
            throw new ServiceException(ErrorCode.USER_NOT_FOUND, userId);
        }
        UserLoginData userLoginData = userAccount.getUserLoginData();
        UserModelRes userModelRes = new UserModelRes();
        userModelRes.setUserId(userAccount.getUserId());
        userModelRes.setFirstName(userAccount.getFirstName());
        userModelRes.setLastName(userAccount.getLastName());
        userModelRes.setGender(userAccount.getGender());
        userModelRes.setDateOfBirth(userAccount.getDateOfBirth());
        userModelRes.setRoleId(userAccount.getRoleId());
        userModelRes.setLoginName(userLoginData != null ?
                userLoginData.getLoginName() : "");
        userModelRes.setEmailAddress(userLoginData != null ?
                userLoginData.getEmailAddress() : "");
        userModelRes.setLoginName(userLoginData != null ?
                userLoginData.getLoginName() : "");
        return userModelRes;
    }
}
