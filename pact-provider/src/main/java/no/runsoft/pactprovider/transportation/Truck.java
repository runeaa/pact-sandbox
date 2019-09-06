package no.runsoft.pactprovider.transportation;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class Truck implements Vehicle {

  private final int id;
  private final MakeAndModel makeAndModel;
}
