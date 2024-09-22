package hu.otpmobile.ticketing.core.web.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {

  WRONG_BANK_CARD_ID("10100", "Ez a bankkártya nem ehhez a felhasználóhoz tartozik!",
      HttpStatus.BAD_REQUEST),
  RESOURCE_NOT_FOUND("404", "Nem található entitás!", HttpStatus.NOT_FOUND),
  TOKEN_NOT_PROVIDED("10050", "A felhasználói token nem szerepel", HttpStatus.UNAUTHORIZED),
  INVALID_TOKEN("10051", "A felhasználói token lejárt vagy nem értelmezhető",
      HttpStatus.UNAUTHORIZED);


  private final String code;
  private final String message;
  private final HttpStatus httpStatus;

  ErrorType(String code, String message, HttpStatus httpStatus) {
    this.code = code;
    this.message = message;
    this.httpStatus = httpStatus;
  }
}
