package no.runsoft.pactprovider.transportation;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class Bike implements Vehicle {

  private final int id;
  private final MakeAndModel makeAndModel;
  private final boolean teamSponsor;
  private final int grandTourWins;
}
