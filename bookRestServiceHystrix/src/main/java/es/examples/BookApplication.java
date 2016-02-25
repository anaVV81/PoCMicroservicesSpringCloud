package es.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableCircuitBreaker


public class BookApplication {

//(fallbackMethod = "fallbackMethod")
  @RequestMapping(value = "/available")
  @HystrixCommand
  public String available() {
    return "The book is available";
  }
  public String fallbackMethod() {
    return "The book is available-fallback";
  }

  @RequestMapping(value = "/checked-out")
  public String checkedOut() {
    return "Book checked out";
  }

  public static void main(String[] args) {
    SpringApplication.run(BookApplication.class, args);
  }
}
