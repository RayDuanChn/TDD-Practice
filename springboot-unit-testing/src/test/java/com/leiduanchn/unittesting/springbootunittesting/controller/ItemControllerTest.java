package com.leiduanchn.unittesting.springbootunittesting.controller;

import com.leiduanchn.unittesting.springbootunittesting.business.ItemBusinessService;
import com.leiduanchn.unittesting.springbootunittesting.model.Item;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Controller unit test
 *
 * lunching spring is a integration test. Here I only want to lunch this controller by spring mock MVC framework
 *
 * @author leiduanchn
 * @create 2019-12-24 10:40 p.m.
 */

//when using JUnit 4, should be add @RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)   //MVC tests
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /*
       No using @MockBean to mock bean that will get a error:
           NoSuchBeanDefinitionException: No qualifying bean of type 'com.leiduanchn.unittesting.springbootunittesting.business.ItemBusinessService' available:
           expected at least 1 bean which qualifies as autowire candidate.
           Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}

       reason:  @WebMvcTest(ItemController.class) only load up all the stuff related to the itemController.
        it will not try to load up any other bean other than the ItemController.
        It will not load up the business service at all.
    */
    @MockBean
    private ItemBusinessService service;

    @Test
    public void dummyItem_basic() throws Exception {

        //call GET "/hello-world" , APPLICATION_JSON
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);    //response type which expect back

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())     // verify status code  isOk() == is(200)
                //Using .json(), it can match the responses even if it contains additional spaces.
                //If some of the elements are missing, it would only check for the elements that are present in it.
                .andExpect(content().json("{\"id\": 1,\"name\":\"ball\",\"price\":9}"))    //verify return content
                .andReturn();   // has return value

        //verify "Hello World!"
        //assertEquals("Hello World!", result.getResponse().getContentAsString());

    }

    @Test
    public void jsonAssert_strictTrue() throws JSONException {
        String actual = "{id:1, name:ball, price:9}";
        String expected = "{\"id\": 1,\"name\":\"ball\",\"price\":10}";

        /*
         *  {@code strict} parameter value:
         * <li>{@code true}: strict checking. Not extensible, and strict array ordering.</li>
         * <li>{@code false}: lenient checking. Extensible, and non-strict array ordering.</li>
         */
        JSONAssert.assertEquals(expected, actual, true);
    }
    @Test
    public void jsonAssert_strictFalse() throws JSONException {
        String actual = "{id:1, name:ball, price:9, quality:100}";
        String expected = "{\"id\": 1,\"name\":\"ball\",\"price\":9}";

        /*
         *  {@code strict} parameter value:
         * <li>{@code true}: strict checking. Not extensible, and strict array ordering.</li>
         * <li>{@code false}: lenient checking. Extensible, and non-strict array ordering.</li>
         */
        JSONAssert.assertEquals(expected, actual, false);
    }


    @Test
    public void itemFromServiceTest() throws Exception {

        when(service.retrieveItem()).thenReturn(new Item(1, "ball2", 10, 100));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item/from-service")
                .accept(MediaType.APPLICATION_JSON);    //response type which expect back

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())     // verify status code  isOk() == is(200)
                .andExpect(content().json("{\"id\": 1,\"name\":\"ball2\",\"price\":10}"))    //verify return content
                .andReturn();   // has return value
    }
}