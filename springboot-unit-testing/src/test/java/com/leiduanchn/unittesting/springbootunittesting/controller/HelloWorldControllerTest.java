package com.leiduanchn.unittesting.springbootunittesting.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * lunching spring is a integration test. Here I only want to lunch this controller by spring mock MVC framework
 *
 * @author leiduanchn
 * @create 2019-12-24 10:40 p.m.
 */

//when using JUnit 4, should be add @RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)     //MVC tests
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld_basic() throws Exception {

        //call GET "/hello-world" , APPLICATION_JSON
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);    //response type which expect back

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())     // verify status code  isOk() == is(200)
                .andExpect(content().string("Hello World!"))    //verify return content,  content().json
                .andReturn();   // has return value

        //verify "Hello World!"
        assertEquals("Hello World!", result.getResponse().getContentAsString());

    }


}