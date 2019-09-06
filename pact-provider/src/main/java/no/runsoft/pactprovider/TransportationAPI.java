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
    return Car.builder()
        .id(id)
        .makeAndModel(MakeAndModel.builder()
            .producer("Volvo")
            .model("V70")
            .year("2003").build())
        .build();
  }

  @RequestMapping("/vehicle/bike")
  public Vehicle getBike(@RequestParam int id) {
    return Bike.builder()
        .id(id)
        .makeAndModel(MakeAndModel.builder()
            .producer("Specialized")
            .model("Tarmac")
            .year("2018").build())
        .teamSponsor(true)
        .grandTourWins(105)
        .build();
  }

  @RequestMapping("/vehicle/truck")
  public Vehicle getTruck(@RequestParam int id) {
    return Truck.builder().id(id)
        .makeAndModel(MakeAndModel.builder()
            .producer("Scania")
            .model("R-Highline")
            .year("2019").build())
        .build();
  }
}
