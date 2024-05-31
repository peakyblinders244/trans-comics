package com.transcomics.transcomics.repositoriesTest;

import com.transcomics.transcomics.entities.UserAccount;
import com.transcomics.transcomics.entities.UserLoginData;
import com.transcomics.transcomics.repositories.users.UserAccountRepository;
import com.transcomics.transcomics.repositories.users.UserLoginDataRepository;
import com.transcomics.transcomics.utils.PasswordEncoderUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.UUID;

/**
 * Le-Hong-Quan
 * Date: 26/05/2024
 * Time: 12:06
 */
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserLoginDataRepository userLoginDataRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Test
    public void testFindByLoginName() {
        String loginName = "admin";
        UserLoginData userLoginData = userLoginDataRepository.findWithUserAccountByLoginName(loginName);
        System.out.println(userLoginData);
    }

    @Test
    public void testSaveUser() {
        PasswordEncoder passwordEncoder = PasswordEncoderUtils.getPasswordEncoder(PasswordEncoderUtils.BCrypt);

        String userId = UUID.randomUUID().toString();
        UserLoginData userLoginData = new UserLoginData();
        userLoginData.setUserId(userId);
        userLoginData.setLoginName("admin");
        userLoginData.setPasswordSalt(PasswordEncoderUtils.SALT);
        userLoginData.setPasswordHash(passwordEncoder.encode("admin"));
        userLoginData.setHashAlgorithmId(PasswordEncoderUtils.BCrypt);
        userLoginData.setEmailAddress("admin@yopmail.com");
        userLoginData.setEmailValidationStatusId("E");
        userLoginData.setConfirmationToken(UUID.randomUUID().toString());
        userLoginData.setTokenGenerationTime(new Date());
//        userLoginData.setPasswordRecoveryToken(UUID.randomUUID().toString());

        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(userId);
        userAccount.setFirstName("admin");
        userAccount.setLastName("admin");
        userAccount.setGender("M");
        userAccount.setDateOfBirth(new Date());
        userAccount.setRoleId("ADMIN");

        userAccountRepository.save(userAccount);
        userLoginDataRepository.save(userLoginData);
    }
}
