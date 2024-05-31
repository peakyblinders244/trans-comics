package com.transcomics.transcomics.controllers;

import com.transcomics.transcomics.common.Constants;
import com.transcomics.transcomics.model.req.LoginReq;
import com.transcomics.transcomics.model.wrapper.WrapResponse;
import com.transcomics.transcomics.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * Le-Hong-Quan
 * Date: 29/05/2024
 * Time: 13:12
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constants.AUTH_URL)
@Tag(name = "Auth", description = "Auth API")
@RequiredArgsConstructor
public class AuthController {
    private final ExecutorService executorService;
    private final UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CompletableFuture<Object> login(@Valid @RequestBody LoginReq loginReq) {
        return CompletableFuture.supplyAsync(() -> WrapResponse.ok(userService.login(loginReq)), executorService);
    }

}
