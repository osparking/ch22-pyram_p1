package space.bum.junit.pyram_p1.airport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PassengerTest {
  @Test
  @DisplayName("내국인 등록 번호 변경 성공 시험")
  public void testSetValidRrn() {
    Passenger passenger = new Passenger("831010-4234567", "최은서", "KR");
    passenger.setIdentifier("821010-2234567");
    assertEquals("821010-2234567", passenger.getIdentifier());
  }

  @Test
  @DisplayName("외국인 등록 번호 변경 성공 시험")
  public void testSetValidNonUsIdentifier() {
    Passenger passenger = new Passenger("840108-5234567", "김정은", "KP");
    passenger.setIdentifier("840108-7234567");
    assertEquals("840108-7234567", passenger.getIdentifier());
  }

  @Test
  @DisplayName("외국인 등록번호 오류로 인한 예외 2 건 발생 시험")
  public void testCreatePassengerWithInvalidNonKrIdentifier() {
    assertThrows(RuntimeException.class,
        () -> {
          new Passenger("831010-0234567", "김여정", "KP");
        });
    assertThrows(RuntimeException.class,
        () -> {
          new Passenger("840108-9234567", "김정은", "KP");
        });
  }

  @Test
  @DisplayName("외국인 여성 국가 코드 오류 예외 시험")
  public void testCreatePassengerWithInvalidCountryCode() {
    assertThrows(RuntimeException.class,
        () -> {
          new Passenger("831010-6234567", "자넷 젝슨", "GJ");
        });
  }

  @Test
  @DisplayName("외국인 남성 외국인 번호 변경 오류 예외 시험")
  public void testSetInvalidRrn() {
    assertThrows(RuntimeException.class,
        () -> {
          (new Passenger("840108-5234567", "김정은", "US"))
              .setIdentifier("840108-9234567");
        });
  }

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
  @DisplayName("주민 등록번호 오류로 인한 예외 2 건 발생 시험")
  public void testCreatePassengerWithInvalidRrn() {
    assertThrows(RuntimeException.class,
        () -> {
          new Passenger("201001-9234567", "임순남", "KR");
        });
    assertThrows(RuntimeException.class,
        () -> {
          new Passenger("201001-9234567", "러순녀", "KR");
        });
  }

  @Test
  @Disabled
  void test() {
    List<String> countries = Arrays.asList(Locale.getISOCountries());
    System.out.println(countries.contains("KR"));
    System.out.println(countries.size());
  }
}
