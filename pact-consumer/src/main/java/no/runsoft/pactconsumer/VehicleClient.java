package no.runsoft.pactconsumer;

import no.runsoft.pactconsumer.transportation.Bike;
import no.runsoft.pactconsumer.transportation.Car;
import no.runsoft.pactconsumer.transportation.Truck;
import no.runsoft.pactconsumer.transportation.Vehicle;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Component
public class VehicleClient {

  private final RestTemplate restTemplate;
  private static String URL = "http://localhost:8084";

  public VehicleClient() {
    this.restTemplate = new RestTemplateBuilder().rootUri(URL).build();
  }

  public Car getVehicle(String id) {
    final Car car = restTemplate.getForObject("/vehicle/car/" + id, Car.class);
    Assert.notNull(car, "Object is null.");
    return car;
  }

  public Vehicle getBike(String id) {
    final Bike bike = restTemplate.getForObject("/vehicle/bike/" + id, Bike.class);
    Assert.notNull(bike, "Object is null.");
    return bike;
  }

  public Vehicle getTruck(String id) {
    final Truck truck = restTemplate.getForObject("/vehicle/truck/" + id, Truck.class);
    Assert.notNull(truck, "Object is null.");
    return truck;
  }
}
