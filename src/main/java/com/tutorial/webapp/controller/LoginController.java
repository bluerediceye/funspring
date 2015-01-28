package com.tutorial.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/**
 * Created on 28/01/15
 *
 * @author Ming Li
 */
@Controller
public class LoginController {

    private Logger LOG = LoggerFactory.getLogger(LoginController.class);

    public String login(ModelMap model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        LOG.info("{} logged in", username);
        return "login";
    }
}
