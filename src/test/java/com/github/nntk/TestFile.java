package com.github.nntk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LogosApplication.class)
public class TestFile {
    @Autowired
    private LogosController logosController;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void year() throws Exception {


        MvcResult result = mockMvc.perform(get("/logos/listYear"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void month() throws Exception {


        MvcResult result = mockMvc.perform(get("/logos/2020"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void logFile() throws Exception {


        MvcResult result = mockMvc.perform(get("/logos/2020/12"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
}
