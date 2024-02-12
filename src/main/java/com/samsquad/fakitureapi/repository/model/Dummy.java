package com.samsquad.fakitureapi.repository.model;

import com.samsquad.fakitureapi.PojaGenerated;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@PojaGenerated
@Entity
@Getter
@Setter
public class Dummy {
  @Id private String id;
}
