package com.samsquad.fakitureapi.endpoint.rest.controller;

import static com.samsquad.fakitureapi.endpoint.rest.controller.health.PingController.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.samsquad.fakitureapi.PojaGenerated;
import com.samsquad.fakitureapi.conf.FacadeIT;
import com.samsquad.fakitureapi.endpoint.rest.controller.health.HealthDbController;
import com.samsquad.fakitureapi.endpoint.rest.controller.health.PingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@PojaGenerated
class HealthControllerIT extends FacadeIT {

  @Autowired PingController pingController;
  @Autowired HealthDbController healthDbController;

  @Test
  void ping() {
    assertEquals("pong", pingController.ping());
  }

  @Test
  void can_read_from_dummy_table() {
    var responseEntity = healthDbController.dummyTable_should_not_be_empty();
    assertEquals(OK, responseEntity);
  }
}
