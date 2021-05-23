package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/test")
public class SampleController {
  @Get(value = "1", produces = MediaType.TEXT_PLAIN)
  public String helloWorld1() {
    return "Hello, World!";
  }

  @Get(value = "2", produces = MediaType.TEXT_PLAIN)
  public HttpResponse<String> helloWorld2() {
    return HttpResponse.ok("Hello, World!");
  }
}
