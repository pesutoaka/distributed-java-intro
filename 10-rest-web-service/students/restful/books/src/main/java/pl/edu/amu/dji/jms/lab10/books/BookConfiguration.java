package pl.edu.amu.dji.jms.lab10.books;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.amu.dji.jms.lab10.books.model.Book;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
@EnableAutoConfiguration
@RestController
public class BookConfiguration {

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }

    List<Book> books = new ArrayList<Book>();

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks(){return books;}

    public static void main(String[] args) {
        SpringApplication.run(BookConfiguration.class, args);
    }
}
