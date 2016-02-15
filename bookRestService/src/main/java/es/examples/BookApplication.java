package es.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class BookApplication {

  @RequestMapping(value = "/available")
  public String available() {
    return "The book is available";
  }

  @RequestMapping(value = "/checked-out")
  public String checkedOut() {
    return "Book checked out";
  }

  public static void main(String[] args) {
    SpringApplication.run(BookApplication.class, args);
  }
}
