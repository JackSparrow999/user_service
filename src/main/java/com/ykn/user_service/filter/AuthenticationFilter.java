package com.ykn.user_service.filter;

import com.ykn.user_service.dtos.tracker.TrackerRequest;
import com.ykn.user_service.dtos.tracker.TrackerResponse;
import com.ykn.user_service.entities.tracker.Tracker;
import com.ykn.user_service.entities.user.User;
import com.ykn.user_service.exceptions.AppException;
import com.ykn.user_service.services.TrackerService;
import com.ykn.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {

    @Autowired
    TrackerService trackerService;

    @Autowired
    UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        Cookie[] cookies = httpServletRequest.getCookies();

        Cookie authCookie = null;

        if(cookies == null)
            cookies = new Cookie[0];

        for(Cookie cookie: cookies){
            if(cookie != null && authCookie == null && "tracker".equals(cookie.getComment())){
                authCookie = cookie;
            }
            if(cookie != null && "user".equals(cookie.getComment())){
                authCookie = cookie;
            }
        }

        Tracker tracker = null;
        User user = null;

        if(authCookie == null){
            TrackerRequest trackerRequest = new TrackerRequest();
            TrackerResponse trackerResponse = trackerService.saveTracker(trackerRequest);
            authCookie = new Cookie("tracker", trackerResponse.getId().toString());
            authCookie.setComment("tracker");
        }
        else if(authCookie.getComment().equals("tracker"))
            tracker = trackerService.getTrackerById(Long.parseLong(authCookie.getValue()));
        else if(authCookie.getComment().equals("user"))
            user = userService.getUserById(Long.parseLong(authCookie.getValue()));
        else
            throw new AppException("Unauthorized user!");

        httpServletRequest.setAttribute(authCookie.getComment(), authCookie.getValue());
        httpServletResponse.addCookie(authCookie);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
