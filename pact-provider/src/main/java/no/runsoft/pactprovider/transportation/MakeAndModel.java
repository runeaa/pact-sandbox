package no.runsoft.pactprovider.transportation;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@Getter
@RequiredArgsConstructor
public class MakeAndModel {

  private final String producer;
  private final String model;
  private final String year;

}
