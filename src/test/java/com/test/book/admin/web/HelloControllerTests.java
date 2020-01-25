package com.test.book.admin.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTests {


    //
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello() throws Exception {

        String hello = "hello";


        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }


    @Test
    public void helloDto() throws Exception {
        String name = "name";
        int amount = 10000;

        //param 값은 String만 허용
        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }

}
//jsonPath
//JSON 응답값을 필드별로 검증할 수 있는 메소드입니다.
//$를 기준으로 필드명을 명시합니다.