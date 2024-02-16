package space.bum.junit.pyram_p1.airport;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class PassengerTest {

  @Test
  void test() {
    List<String> countries = Arrays.asList(Locale.getISOCountries());
    System.out.println(countries.contains("KR"));
    System.out.println(countries.size());
    
  }

}
