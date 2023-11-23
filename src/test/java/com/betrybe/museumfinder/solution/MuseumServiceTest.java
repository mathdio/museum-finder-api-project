package com.betrybe.museumfinder.solution;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumService;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@DisplayName("Museum Service Tests")
public class MuseumServiceTest {

  @MockBean
  private MuseumFakeDatabase database;

  @Test
  @DisplayName("Museum not found by id test")
  void testGetMuseumNotFound() {
    Mockito
        .when(database.getMuseum(999L))
        .thenReturn(Optional.empty());

    MuseumService service = new MuseumService(database);
    assertThrows(MuseumNotFoundException.class, () -> {
      service.getMuseum(999L);
    });
  }

  @Test
  @DisplayName("Museum returned successfully by id")
  void testGetMuseumOk() {
    Mockito
        .when(database.getMuseum(1L))
        .thenReturn(Optional.of(new Museum()));

    MuseumService service = new MuseumService(database);
    assertTrue(new ReflectionEquals(new Museum())
        .matches(service.getMuseum(1L)));
  }
}
