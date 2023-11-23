package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
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

/**
 * The type Collection type controller test.
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Collection Type Controller Tests")
public class CollectionTypeControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private CollectionTypeService service;

  @Test
  @DisplayName("Type Not Found Test")
  void testTypeNotFound() throws Exception {
    String[] type = {"5"};
    Mockito
        .when(service.countByCollectionTypes("5"))
        .thenReturn(new CollectionTypeCount(type, 0));

    ResultActions result = mockMvc
        .perform(MockMvcRequestBuilders.get("/collections/count/5"));

    result.andExpect(MockMvcResultMatchers.status().isNotFound());
    Mockito.verify(service).countByCollectionTypes("5");
  }

  @Test
  @DisplayName("Types Ok Test")
  void testTypesOk() throws Exception {
    String[] types = {"1", "2"};
    Mockito
        .when(service.countByCollectionTypes("1,2"))
        .thenReturn(new CollectionTypeCount(types, 2));

    ResultActions result = mockMvc
        .perform(MockMvcRequestBuilders.get("/collections/count/1,2"));

    result.andExpect(MockMvcResultMatchers.status().isOk());
    Mockito.verify(service).countByCollectionTypes("1,2");
  }
}
