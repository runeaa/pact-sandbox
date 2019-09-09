package no.runsoft.pactconsumer.transportation;

import lombok.Data;

@Data
public class Truck implements Vehicle {

  private int id;
  private MakeAndModel makeAndModel;
  private int maxLoad;
}
