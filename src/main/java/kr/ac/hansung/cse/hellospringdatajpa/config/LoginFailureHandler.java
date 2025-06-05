package kr.ac.hansung.cse.hellospringdatajpa.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        org.springframework.security.core.AuthenticationException exception)
            throws IOException {

        if (exception instanceof UsernameNotFoundException) {
            response.sendRedirect(request.getContextPath() + "/login?notfound=true");
        } else if (exception instanceof BadCredentialsException) {
            response.sendRedirect(request.getContextPath() + "/login?error=true");
        } else {
            response.sendRedirect(request.getContextPath() + "/login?error=true");
        }
    }
}
