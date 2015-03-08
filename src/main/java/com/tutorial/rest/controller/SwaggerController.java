package com.tutorial.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created on 08/03/15
 *
 * @author Ming Li
 */
@Controller
public class SwaggerController {

    private static final String viewName = "swagger/index";

    private static final String SWAGGER_UI_PATH = "/swagger";

    @RequestMapping(value = SWAGGER_UI_PATH, method = RequestMethod.GET)
    public String index() {
        return viewName;
    }
}
