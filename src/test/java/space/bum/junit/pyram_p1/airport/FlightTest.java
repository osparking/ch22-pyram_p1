package space.bum.junit.pyram_p1.airport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FlightTest {

  @Test
  @DisplayName("비운의 대한항공 항공편 번호 정당함 시험")
  public void testFlightCreation() {
    Flight flight = new Flight("KE007", 100);
    assertNotNull(flight);
  }

  @Test
  @DisplayName("항공편 번호 숫자부분 길이 부적으로 예외발생 시험")
  public void testInvalidFlightNumber() {
    assertThrows(RuntimeException.class,
        () -> {
          new Flight("AA12", 100);
        });
    assertThrows(RuntimeException.class,
        () -> {
          new Flight("AA12345", 100);
        });
  }

  @Test
  public void testValidFlightNumber() {
    Flight flight = new Flight("AA345", 100);
    assertNotNull(flight);
    flight = new Flight("AA3456", 100);
    assertNotNull(flight);
  }

  @Test
  public void testAddPassengers() {
    Flight flight = new Flight("AA1234", 50);
    flight.setOrigin("인천");
    flight.setDestination("상하이");

    IntStream.range(0, flight.getSeats()).forEach(i -> flight.addPassenger());

    assertEquals(50, flight.getPassengers());
    assertThrows(RuntimeException.class, () -> flight.addPassenger());
  }
}
