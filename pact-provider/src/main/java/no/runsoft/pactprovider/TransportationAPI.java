package no.runsoft.pactprovider;

import no.runsoft.pactprovider.transportation.Bike;
import no.runsoft.pactprovider.transportation.Car;
import no.runsoft.pactprovider.transportation.MakeAndModel;
import no.runsoft.pactprovider.transportation.Truck;
import no.runsoft.pactprovider.transportation.Vehicle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransportationAPI {

  @RequestMapping("/vehicle/car")
  public Vehicle getCar(@RequestParam int id) {
    return new Car(id, new MakeAndModel("Volvo", "V70", "2003"));
  }

  @RequestMapping("/vehicle/bike")
  public Vehicle getBike(@RequestParam int id) {
    return new Bike(id, new MakeAndModel("Specialized", "Tarmac", "2018"), true, 105);
  }

  @RequestMapping("/vehicle/truck")
  public Vehicle getTruck(@RequestParam int id) {
    return new Truck(id, new MakeAndModel("Scania", "R-Highline", "2019"));
  }
}
