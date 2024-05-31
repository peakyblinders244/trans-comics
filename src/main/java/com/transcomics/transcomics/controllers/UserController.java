package com.transcomics.transcomics.controllers;

import com.transcomics.transcomics.common.Constants;
import com.transcomics.transcomics.model.wrapper.WrapResponse;
import com.transcomics.transcomics.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * Le-Hong-Quan
 * Date: 29/05/2024
 * Time: 11:18
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constants.USER_URL)
@Tag(name = "User", description = "User API")
@RequiredArgsConstructor
public class UserController {
    private final ExecutorService executorService;
    private final UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public CompletableFuture<Object> getInformationUser(@PathVariable String userId, Principal principal) {
        return CompletableFuture.supplyAsync(() -> {
            return WrapResponse.ok(userService.getUserModelResByUserId(userId));
        }, executorService);
    }
}

