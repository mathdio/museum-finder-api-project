package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Museum Controller Tests")
public class MuseumControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private MuseumServiceInterface service;

  @Test
  @DisplayName("Museum not found by id")
  void testGetMuseumNotFound() throws Exception {
    Mockito
        .when(service.getMuseum(999L))
        .thenThrow(MuseumNotFoundException.class);

    ResultActions result = mockMvc
        .perform(MockMvcRequestBuilders.get("/museums/999"));
    result.andExpect(MockMvcResultMatchers.status().isNotFound());

    Mockito.verify(service).getMuseum(999L);
  }

  @Test
  @DisplayName("Museum returned successfully by id")
  void testGetMuseumOk() throws Exception {
    Mockito
        .when(service.getMuseum(1L))
        .thenReturn(new Museum());

    ResultActions result = mockMvc
        .perform(MockMvcRequestBuilders.get("/museums/1"));
    result.andExpect(MockMvcResultMatchers.status().isOk());

    Mockito.verify(service).getMuseum(1L);
  }
}
