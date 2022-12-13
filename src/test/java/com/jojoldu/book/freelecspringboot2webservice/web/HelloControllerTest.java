package com.jojoldu.book.freelecspringboot2webservice.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다.
@WebMvcTest(controllers = HelloController.class) // Web에 집중할 수 있는 어노테이션이다. // 선언할 경우 @Controller, @ControllerAdvice를 사용할 수 있다.
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈(Bean)을 주입 받는다.
    private MockMvc mvc; // 웹API를 테스트할 때 사용한다. 스프링 MVC테스트의 시작점이다. 이 클래스를 통해 http get, post등에 대한 api테스트를 할 수 있다.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // mockmvc를 통해 hello주소로 http get 요청을 한다.
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증한다. http header의 status를 검증한다.
                .andExpect(content().string(hello)); // mvc.perform의 결과를 검증한다. 응답 본문의 내용을 검증한다. Controller에서 hello를 리턴하기 때문에 이 값이 맞는지 검증한다.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
