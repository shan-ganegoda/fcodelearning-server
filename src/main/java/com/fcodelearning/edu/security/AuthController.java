package com.fcodelearning.edu.security;

import com.fcodelearning.edu.dto.AuthUser;
import com.fcodelearning.edu.dto.AuthenticationRequest;
import com.fcodelearning.edu.dto.AuthenticationResponse;
import com.fcodelearning.edu.dto.RegisterRequest;
import com.fcodelearning.edu.services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final CookieProvider cookieProvider;

//    @GetMapping
//    public List<User> getAll(){
//        return authService.getAll();
//    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthUser> authenticate(@RequestBody AuthenticationRequest request, HttpServletResponse response){
        AuthenticationResponse auth = authService.authenticate(request);
        response.addCookie(cookieProvider.createAuthCookie(auth.getAccessToken()));
        response.addCookie(cookieProvider.createRefreshCookie(auth.getRefreshToken()));

        return ResponseEntity.ok(auth.getAuthUser());
    }

    @GetMapping("/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie refreshCookie = WebUtils.getCookie(request,"refreshToken");

        if(refreshCookie != null){
            AuthenticationResponse authResponse = authService.refreshToken(refreshCookie.getValue());
            response.addCookie(cookieProvider.createAuthCookie(authResponse.getAccessToken()));
        }
    }
}
