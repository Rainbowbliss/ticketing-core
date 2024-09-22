package hu.otpmobile.ticketing.core.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsResponse {

  private Long userId;
  private String cardId;
  private BigDecimal cardBalance;
}
