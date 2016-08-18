package es.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import es.examples.BookComponent;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableCircuitBreaker


public class BookApplication {
  @Autowired
  BookComponent bookComponent;

//(fallbackMethod = "fallbackMethod")
  @RequestMapping(value = "/available")
  public String available() {
    return bookComponent.isBookAvailable();
  }

  @RequestMapping(value = "/checked-out")
  public String checkedOut() {
    return "Book checked out";
  }

  public static void main(String[] args) {
    SpringApplication.run(BookApplication.class, args);
  }
}
