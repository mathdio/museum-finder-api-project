package com.betrybe.museumfinder.solution;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Collection Type Service Tests")
public class CollectionTypeServiceTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private MuseumFakeDatabase database;

  @Test
  @DisplayName("Search one type and return count as 0 test")
  void testReturnCountZero() {
    String[] type = {"5"};
    Mockito
        .when(database.countByCollectionType(type[0]))
        .thenReturn(0L);

    CollectionTypeService service = new CollectionTypeService(database);
    assertTrue(new ReflectionEquals(new CollectionTypeCount(type, 0L))
        .matches(service.countByCollectionTypes(type[0])));
  }
}
