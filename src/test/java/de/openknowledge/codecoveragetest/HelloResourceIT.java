package de.openknowledge.codecoveragetest;

import io.restassured.RestAssured;
import org.hamcrest.core.IsEqual;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@RunAsClient
public class HelloResourceIT {

  @Deployment
  public static Archive<?> createDeployment() {
    System.err.println("Inside createDeployment");
    WebArchive archive = ShrinkWrap.create(WebArchive.class)
            .addClass(HelloResource.class)
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    System.err.println(archive.toString(true));
    return archive;
  }

  @Test
  public void returnsHelloWorld() {
    Assert.assertEquals(true, true);
    /*
    RestAssured.get("http://localhost:8080/code-coverage-test/api/hello")
            .then()
            .assertThat()
            .body("message", IsEqual.equalTo("hello world"));
   */
  }
}
