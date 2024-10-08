package hu.otpmobile.ticketing.core.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentRequest {

  @NotNull
  Long userId;

  @NotBlank
  String cardId;

  @NotNull
  BigDecimal price;
}
