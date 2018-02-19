package de.openknowledge.codecoveragetest;

import io.restassured.RestAssured;
import org.hamcrest.core.IsEqual;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URL;

@RunWith(Arquillian.class)
@RunAsClient
public class HelloResourceIT {

  @Deployment
  public static Archive<?> createDeployment() {
    return ShrinkWrap.create(WebArchive.class)
            .addClasses(JaxRsActivator.class, HelloResource.class)
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
  }

  @ArquillianResource
  private URL baseURI;

  @Test
  public void returnsHelloWorld() throws Exception {
    URI uri = UriBuilder.fromUri(baseURI.toURI()).path("api").path("hello").build();
    RestAssured.get(uri)
            .then()
            .assertThat()
            .body("message", IsEqual.equalTo("hello world"));
  }
}
