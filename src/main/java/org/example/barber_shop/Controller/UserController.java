package org.example.barber_shop.Controller;

import lombok.RequiredArgsConstructor;
import org.example.barber_shop.DTO.ApiResponse;
import org.example.barber_shop.DTO.User.UpdateProfileRequest;
import org.example.barber_shop.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @GetMapping("/")
    public ApiResponse<?> getAllUsers() {
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "ALL USERS",
                userService.getAllUsers()
        );
    }

    @GetMapping("/profile")
    public ApiResponse<?> getUserProfile() {
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "YOUR PROFILE",
                userService.getProfile()
        );
    }

    @PutMapping("/profile")
    public ApiResponse<?> updateUserProfile(@RequestBody UpdateProfileRequest updateProfileRequest){
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "PROFILE UPDATED",
                userService.updateProfile(updateProfileRequest)
        );
    }
    @PostMapping("/update-avatar")
    public ApiResponse<?> updateAvatar(@RequestParam("image") MultipartFile image) throws IOException {
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "AVATAR CHANGED",
                userService.updateAvatar(image)
        );
    }
    @GetMapping("/get-all-staffs")
    public ApiResponse<?> getAllStaffs() {
        return new ApiResponse<>(
                HttpStatus.CONTINUE.value(), "ALL STAFFS", userService.getAllStaffs()
        );
    }
    @GetMapping("/get-all-admins")
    public ApiResponse<?> getAllAdmins() {
        return new ApiResponse<>(
                HttpStatus.CONTINUE.value(), "ALL ADMINS", userService.getAllAdmins()
        );
    }
    @GetMapping("/get-all-customers")
    public ApiResponse<?> getAllCustomers() {
        return new ApiResponse<>(
                HttpStatus.CONTINUE.value(), "ALL CUSTOMERS", userService.getAllCustomers()
        );
    }
    @GetMapping("/get-all-receptionists")
    public ApiResponse<?> getAllReceptionists() {
        return new ApiResponse<>(
                HttpStatus.CONTINUE.value(), "ALL RECEPTIONISTS", userService.getAllReceptionists()
        );
    }
    @GetMapping("/logout")
    public ApiResponse<?> logout(@RequestHeader("Authorization") String authorizationHeader){
        if (userService.logout(authorizationHeader)){
            return new ApiResponse<>(
                    HttpStatus.OK.value(), "SUCCESS", "This token is disable from now."
            );
        } else {
            return new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), "FAIL", "This token is still valid."
            );
        }
    }
}
