package com.tutorial.webapp;

import com.tutorial.domain.User;
import com.tutorial.repository.UserRepository;
import com.tutorial.service.SayHelloService;
import com.tutorial.service.SayHelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {
    
    @Autowired
    private SayHelloService sayHelloService;
    
    @Autowired
    private UserRepository userRepository;
    
    String message = "Welcome to your 1st Maven Spring project !";

    @RequestMapping("/index")
    public ModelAndView index() {
        userRepository.addPerson(new User());
        System.out.println("from controller");
        sayHelloService.sayHello();
        return new ModelAndView("index", "message", message);
    }
    
    @RequestMapping("/hello")
    public ModelAndView showMessage() {
        System.out.println("from controller");
        sayHelloService.sayHello();
        return new ModelAndView("hello", "message", message);
    }
}  