package org.example.barber_shop.Controller;

import lombok.RequiredArgsConstructor;
import org.example.barber_shop.DTO.ApiResponse;
import org.example.barber_shop.DTO.User.ForgotPasswordRequest;
import org.example.barber_shop.DTO.User.LoginRequest;
import org.example.barber_shop.DTO.User.RegisterRequest;
import org.example.barber_shop.DTO.User.ResetPasswordRequest;
import org.example.barber_shop.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final ClientRegistrationRepository clientRegistrationRepository;
    @PostMapping("/register")
    public ApiResponse<?> register(@RequestBody RegisterRequest registerRequest) {
        return new ApiResponse<>(
                HttpStatus.CREATED.value(),
                "RESOURCE_CREATED",
                userService.register(registerRequest)
        );
    }

    @GetMapping("/verify-email")
    public ApiResponse<?> verifyEmail(@RequestParam("token") String token) {
        if (userService.verifyToken(token)){
            return new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "RESOURCE_UPDATED",
                    null
            );
        } else {
            return new ApiResponse<>(
                    HttpStatus.BAD_REQUEST.value(),
                    "INVALID_TOKEN",
                    null
            );
        }
    }

    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody LoginRequest loginRequest) {
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "LOGIN_SUCCESS",
                userService.login(loginRequest)
        );
    }
    @PostMapping("/forgot-password")
    public ApiResponse<?> forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest){
        userService.forgotPassword(forgotPasswordRequest);
        return new ApiResponse<>(
                HttpStatus.OK.value(), "MAIL SENT", null
        );
    }
    @PostMapping("/reset-password")
    public ApiResponse<?> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest){
        userService.resetPassword(resetPasswordRequest);
        return new ApiResponse<>(
                HttpStatus.OK.value(), "PASSWORD RESET", null
        );
    }
    @GetMapping("/get-google-login-url")
    public ApiResponse<?> getGoogleLoginUrl(){
        OAuth2AuthorizationRequest authorizationRequest = OAuth2AuthorizationRequest
                .authorizationCode()
                .clientId("950893291709-9rqulakhl78cnlejkuofncru62p49epo.apps.googleusercontent.com")
                .redirectUri("http://localhost:8080/login/oauth2/code/google")
                .scope("openid", "profile", "email")
                .build();
        String loginUrl = authorizationRequest.getAuthorizationUri();
        return new ApiResponse<>(
            HttpStatus.OK.value(), "GOOGLE_LOGIN", loginUrl
        );
    }
}
