package es.examples;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

@Component
public class BookComponent {


public String isBookAvailableFallback() {
    System.out.println("FALLBACK BOOK!!!");
    return "Try again later!!!!";
}

@HystrixCommand(fallbackMethod = "isBookAvailableFallback")
public String isBookAvailable() {
        return "The book is available";
}
}
