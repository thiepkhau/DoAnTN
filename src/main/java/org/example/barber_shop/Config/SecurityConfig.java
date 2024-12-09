package org.example.barber_shop.Config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.barber_shop.Constants.Role;
import org.example.barber_shop.Entity.File;
import org.example.barber_shop.Entity.User;
import org.example.barber_shop.Repository.FileRepository;
import org.example.barber_shop.Repository.UserRepository;
import org.example.barber_shop.Service.TemporaryCodeService;
import org.example.barber_shop.Util.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;

import java.io.IOException;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final JWTFilter jwtFilter;
    private final UserRepository userRepository;
    private final FileRepository fileRepository;
    private final TemporaryCodeService temporaryCodeService;
    @Value("${front_end_server}")
    private String front_end_server;
    private final String[] publicApi = {"/api/auth/**", "/swagger-ui/**", "/v3/api-docs/**", "/api/service-type/get-all-service-types", "/api/service/get-all-services", "/api/combo/get-all-combos", "/api/users/get-all-staffs", "/api/users/get-all-customers", "/api/users/get-all-admins", "/api/booking/get-staff-work-schedule-in-week", "/api/payment/vnpay-result", "/api/staff-shift/get-staff-shift", "/websocket/**", "/api/review/all", "/api/review/staff-review/**", "/api/combo/get-one-combo/**"};
    private final String[] adminApi = {"/api/booking/complete-booking/**", "/api/users", "/api/service-type/add-service-type", "/api/service/add-service", "/api/combo/add-combo", "/api/shift/get-all-shifts", "/api/shift/**", "/api/booking/admin-book", "/api/staff-shift", "/api/salary/**", "/api/booking/no-show-booking/**", "/api/weekly-salary", "/api/payment/cash/**", "/api/voucher/**"};
    private final String[] customerApi = {"/api/booking/book", "/api/payment/get-vnpay-url", "/api/booking/update-booking", "/api/booking/cancel/**", "/api/review"};
    private final String[] staffApi = {"/api/weekly-salary/staff", "api/booking/reject-booking/**"};
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.cors(cors -> cors.configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.addAllowedOriginPattern("*");
            config.addAllowedMethod("*");
            config.addAllowedHeader("*");
            config.setAllowCredentials(true);
            return config;
        }));
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(request -> request
                .requestMatchers(publicApi).permitAll()
                .requestMatchers(adminApi).hasRole("ADMIN")
                .requestMatchers(customerApi).hasRole("CUSTOMER")
                .requestMatchers(staffApi).hasRole("STAFF")
                .anyRequest().authenticated()
        );
        http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"status\":403,\"message\":\"FORBIDDEN\",\"payload\": \"You don't have permission to access this resource!\"}");
                })
                .authenticationEntryPoint((request, response, authException) -> {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"status\":403,\"message\":\"FORBIDDEN\",\"payload\": \"You are not logged in!\"}");
                })
        );
        http.oauth2Login(httpSecurityOAuth2LoginConfigurer -> {
            httpSecurityOAuth2LoginConfigurer.successHandler(this::handleOauth2Success);
            httpSecurityOAuth2LoginConfigurer.permitAll();
        }).sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    public void handleOauth2Success(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException{
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String name = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");
        String avatar = oAuth2User.getAttribute("picture");
        User user = userRepository.findByEmail(email);
        if (user == null){
            user = new User();
            user.setEmail(email);
            user.setName(name);
            userRepository.save(user);
            File file = new File();
            file.setUrl(avatar);
            file.setOwner(user);
            file.setName(user.getName());
            file.setThumbUrl(avatar);
            file.setMediumUrl(avatar);
            fileRepository.save(file);
            user.setAvatar(file);
            user = userRepository.save(user);
        }
        String code = temporaryCodeService.generateCode(String.valueOf(user.getId()));
        response.sendRedirect(front_end_server + "?token_exchange=" + code);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
