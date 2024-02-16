package space.bum.junit.pyram_p1.airport;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passenger {
  private String identifier;
  private String name;
  private String countryCode;
  // @formatter:off
  private String dobRegex = "^^\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])";
  private String rrnRegex = dobRegex + "-[1-4]\\d{6}$";
  private String nonKrRrnRegex = dobRegex + "-[5-8]\\d{6}$";
  // @formatter:on
  private Pattern pattern;

  public Passenger(String identifier, String name, String countryCode) {
    super();

    pattern = countryCode.equals("KR") ? Pattern.compile(rrnRegex)
        : Pattern.compile(nonKrRrnRegex);
    Matcher matcher = pattern.matcher(identifier);
    if (!matcher.matches()) {
      throw new RuntimeException("아이디 오류");
    }

    if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
      throw new RuntimeException("국가 코드 오류");
    }

    this.identifier = identifier;
    this.name = name;
    this.countryCode = countryCode;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    Matcher matcher = pattern.matcher(identifier);
    if (!matcher.matches()) {
      throw new RuntimeException("아이디 오류");
    }

    this.identifier = identifier;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
