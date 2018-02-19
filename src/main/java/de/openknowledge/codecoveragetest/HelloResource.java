package de.openknowledge.codecoveragetest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloResource {

  @GET
  public String getTest() {
    return "{\"message\":\"hello world\"}";
  }
}
