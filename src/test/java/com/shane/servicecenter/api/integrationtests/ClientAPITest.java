package com.shane.servicecenter.api.integrationtests;

import com.shane.servicecenter.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by SHANE on 2015/08/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8080"})
public class ClientAPITest {
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

//    @Test
    public void setup() throws Exception {
        template=new TestRestTemplate();
    }
//    @Test
    public void testRead() throws Exception {
        ResponseEntity<String> response=template.getForEntity(BASE_URL+"/clients",String.class);
        System.out.println("Response is "+response.getBody());

    }

}
