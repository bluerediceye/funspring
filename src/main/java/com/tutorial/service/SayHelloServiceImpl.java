package com.tutorial.service;

import org.springframework.stereotype.Service;

/**
 * Created by mli on 13/01/15.
 */

@Service
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public void sayHello(){
        System.out.println("hello world world");
    }
}
