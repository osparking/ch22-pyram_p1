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

}
