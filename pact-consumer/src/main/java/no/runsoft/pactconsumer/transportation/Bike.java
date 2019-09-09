package no.runsoft.pactconsumer.transportation;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Bike implements Vehicle {

  private int id;
  private MakeAndModel makeAndModel;
  private boolean teamSponsor;
  private int grandTourWins;
}
