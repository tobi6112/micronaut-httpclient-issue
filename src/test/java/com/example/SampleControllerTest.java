package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class SampleControllerTest {

  @Inject
  EmbeddedServer server;

  @Inject
  @Client("/test")
  HttpClient client;

  @Test
  void shouldReturnHelloWorld1_1() {
    HttpResponse<String> response = client.toBlocking().exchange(HttpRequest.GET("/1").accept(
        MediaType.TEXT_PLAIN));

    assertEquals(200, response.code());
    assertEquals("Hello, World!", response.body());
  }

  @Test
  void shouldReturnHelloWorld1_2() {
    String response = client.toBlocking().retrieve(HttpRequest.GET("/1").accept(MediaType.TEXT_PLAIN));

    assertEquals("Hello, World!", response);
  }

  @Test
  void shouldReturnHelloWorld2() {
    HttpResponse<String> response = client.toBlocking().exchange(HttpRequest.GET("/2").accept(
        MediaType.TEXT_PLAIN));

    assertEquals(200, response.code());
    assertEquals("Hello, World!", response.body());
  }

}
