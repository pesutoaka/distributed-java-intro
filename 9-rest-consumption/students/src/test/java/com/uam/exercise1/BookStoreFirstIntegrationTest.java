package com.uam.exercise1;

import com.uam.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.uam.Application;

import java.io.Console;
import java.lang.reflect.Type;
import java.util.Objects;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class BookStoreFirstIntegrationTest {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void bookStoreShouldNotBeEmpty() {
        Book book = new Book();
        Object getRequest = restTemplate.getForObject(book.URL,Book.class);

        System.out.println(getRequest.toString());
    }
}
