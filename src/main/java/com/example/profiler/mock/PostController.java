package com.example.profiler.mock;

import java.util.stream.IntStream;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
  
  @GetMapping("/posts")
  public Post[] posts(@RequestParam(defaultValue = "50000") Integer size) {

    Faker faker = new Faker();
    Post[] res = new Post[size];
    IntStream.range(0, size).forEach( i -> {
      res[i] = new Post(
        faker.number().randomDigitNotZero(),
        faker.lorem().fixedString(20), 
        faker.lorem().paragraph());
    });

    return res;
  }
}
