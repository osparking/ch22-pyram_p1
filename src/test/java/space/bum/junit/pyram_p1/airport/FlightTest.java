package space.bum.junit.pyram_p1.airport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.manning.junitbook.testpyramid.airport.Flight;

class FlightTest {

  @Test
  @DisplayName("탑승객 수 미달 좌석배정 실패 시험")
  public void testSetInvalidSeats() {
    Flight flight = new Flight("AA1234", 50);
    flight.setOrigin("청주");
    flight.setDestination("상하이");
    IntStream.range(0, flight.getSeats()).forEach(i -> flight.addPassenger());
    assertEquals(50, flight.getPassengers());
    assertThrows(RuntimeException.class, () -> flight.setSeats(49));
  }

  @Test
  @DisplayName("탑승객 수 초과 좌석배정 성공 시험")
  public void testSetValidSeats() {
    Flight flight = new Flight("AA1234", 50);
    flight.setOrigin("London");
    flight.setDestination("Bucharest");
    IntStream.range(0, flight.getSeats()).forEach(i -> flight.addPassenger());
    assertEquals(50, flight.getPassengers());
    flight.setSeats(52);
    assertEquals(52, flight.getSeats());
  }

  @Test
  public void testChangeOrigin() {
    Flight flight = new Flight("KK1234", 50);
    flight.setOrigin("동경");
    flight.setDestination("항조우");
    flight.takeOff();
    assertEquals(true, flight.isFlying());
    assertEquals(true, flight.isTakenOff());
    assertEquals(false, flight.isLanded());
    assertThrows(RuntimeException.class, () -> flight.setOrigin("모스크바"));
  }

  @Test
  public void testLand() {
    Flight flight = new Flight("KK1234", 50);
    flight.setOrigin("동경");
    flight.setDestination("항조우");
    flight.takeOff();
    assertEquals(true, flight.isTakenOff());
    assertEquals(false, flight.isLanded());
    flight.land();
    assertEquals(true, flight.isTakenOff());
    assertEquals(true, flight.isLanded());
    assertEquals(false, flight.isFlying());
  }

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
