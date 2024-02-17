package space.bum.junit.pyram_p1.airport;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PassengerTest {

  @Test
  @DisplayName("내국인 남성 거주자 시험")
  public void testPassengerCreation() {
    Passenger passenger = new Passenger("201001-3234567", "임순남", "KR");
    assertNotNull(passenger);
  }

  @Test
  @DisplayName("러시아 출신 여성 거주자 시험")
  public void testNonUsPassengerCreation() {
    Passenger passenger = new Passenger("201001-6234567", "러순녀", "RU");
    assertNotNull(passenger);
  }

  @Test
  @Disabled
  void test() {
    List<String> countries = Arrays.asList(Locale.getISOCountries());
    System.out.println(countries.contains("KR"));
    System.out.println(countries.size());
  }
}
