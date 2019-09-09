package no.runsoft.pactconsumer.transportation;

import lombok.Data;

@Data
public class Car implements Vehicle {

  private int id;
  private MakeAndModel makeAndModel;
  private double km100L;
}
