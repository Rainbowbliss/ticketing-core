package hu.otpmobile.ticketing.core.web.error.exception;

import hu.otpmobile.ticketing.core.web.error.ErrorType;
import lombok.Getter;

@Getter
public class TicketingException extends RuntimeException {

  private final ErrorType errorType;
  private final String details;

  public TicketingException(ErrorType errorType) {
    this(errorType, "");
  }

  public TicketingException(ErrorType errorType, String details) {
    this.errorType = errorType;
    this.details = details;
  }

}
