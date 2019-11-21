package com.app.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CertificateControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void isGetCertificatesReturnStatusOK() throws Exception {
        this.mockMvc.perform(get("/api/certificates")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void isPostCertificateReturnStatusOK() throws Exception{
        String object = "{\"id\":1,\"certType\": 0,\"isin\": \"certAB\"," +
                "\"barrierLevel\": null,\"participationRate\": null," +
                "\"market\": \"Frankfurt\",\"currency\": \"EUR\"," +
                "\"issuer\": \"Bank\", \"issuePrice\": 47.02," +
                "\"currentPrice\": 50.3, \"typeValue\": \"Standard\"}";
         this.mockMvc.perform(post("/api/certificate/").contentType(MediaType.APPLICATION_JSON).content(object)
                 .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
