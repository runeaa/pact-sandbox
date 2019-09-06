package no.runsoft.pactprovider.transportation;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@Getter
@RequiredArgsConstructor
public class MakeAndModel {

  private final String producer;
  private final String model;
  private final String year;

}
