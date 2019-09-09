package no.runsoft.pactconsumer;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import io.pactfoundation.consumer.dsl.LambdaDsl;
import no.runsoft.pactconsumer.transportation.Car;
import no.runsoft.pactconsumer.transportation.Vehicle;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
    properties = "http://localhost:8084",
    classes = VehicleClient.class)
@Ignore
public class VehicleClientContractTest {

  @Rule
  public PactProviderRuleMk2 provider = new PactProviderRuleMk2("pact-provider", null,
      8084, this);

  @Rule
  public ExpectedException expandException = ExpectedException.none();

  @Autowired
  private VehicleClient vehicleClient;

  @Pact(consumer = "pact-consumer")
  public RequestResponsePact pactCarExsists(PactDslWithProvider builder) {
    DslPart body = LambdaDsl.newJsonBody((o) -> o
        .numberType("id",1)
        .object("makeAndModel", (makeAndModelObject) -> {
          makeAndModelObject.stringType("producer", "Volvo");
          makeAndModelObject.stringType("model", "V70");
          makeAndModelObject.stringType("year", "2003");
        })
        .numberType("km100L", 12.8)).build();

    return builder.given(
        "Car with id 1 exists")
        .uponReceiving("A request to /vehicle/car/1")
        .path("/vehicle/car/1")
        .method("GET")
        .willRespondWith()
        .status(200)
        .body(body)
        .toPact();
  }

  @Pact(consumer = "pact-consumer")
  public RequestResponsePact pactBikeExsists(PactDslWithProvider builder) {
    DslPart body = LambdaDsl.newJsonBody((o) -> o
        .numberType("id",1)
        .object("makeAndModel", (makeAndModelObject) -> {
          makeAndModelObject.stringType("producer", "Specialized");
          makeAndModelObject.stringType("model", "Tarmac");
          makeAndModelObject.stringType("year", "2018");
        })
        .booleanType("teamSponsor", true)
        .numberType("grandTourWins", 1)).build();

    return builder.given(
        "Bike with id 1 exists")
        .uponReceiving("A request to /vehicle/bike/1")
        .path("/vehicle/bike/1")
        .method("GET")
        .willRespondWith()
        .status(200)
        .body(body)
        .toPact();
  }

  @Pact(consumer = "pact-consumer")
  public RequestResponsePact pactTruckExsists(PactDslWithProvider builder) {
    DslPart body = LambdaDsl.newJsonBody((o) -> o
        .numberType("id",1)
        .object("makeAndModel", (makeAndModelObject) -> {
          makeAndModelObject.stringType("producer", "Scania");
          makeAndModelObject.stringType("model", "R-Line");
          makeAndModelObject.stringType("year", "2019");
        })
        .numberType("maxLoad",52)).build();

    return builder.given(
        "Truck with id 1 exists")
        .uponReceiving("A request to /vehicle/truck/1")
        .path("/vehicle/truck/1")
        .method("GET")
        .willRespondWith()
        .status(200)
        .body(body)
        .toPact();
  }

  @PactVerification(fragment = "pactCarExsists")
  @Test
  public void carExsists() {
    final Car car = vehicleClient.getVehicle("1");
    Assert.assertEquals("Volvo", car.getMakeAndModel().getProducer());
    Assert.assertEquals("V70", car.getMakeAndModel().getModel());
    Assert.assertEquals("2003", car.getMakeAndModel().getYear());
  }

  @PactVerification(fragment = "pactBikeExsists")
  @Test
  public void bikeExsists() {
    final Vehicle bike = vehicleClient.getBike("1");
    Assert.assertEquals("Specialized", bike.getMakeAndModel().getProducer());
    Assert.assertEquals("Tarmac", bike.getMakeAndModel().getModel());
    Assert.assertEquals("2018", bike.getMakeAndModel().getYear());
  }

  @PactVerification(fragment = "pactTruckExsists")
  @Test
  public void truckExsists() {
    final Vehicle bike = vehicleClient.getTruck("1");
    Assert.assertEquals("Scania", bike.getMakeAndModel().getProducer());
    Assert.assertEquals("R-Line", bike.getMakeAndModel().getModel());
    Assert.assertEquals("2019", bike.getMakeAndModel().getYear());
  }
}
