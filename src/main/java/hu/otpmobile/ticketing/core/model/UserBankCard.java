package hu.otpmobile.ticketing.core.model;

import hu.otpmobile.ticketing.core.enumeration.Currency;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class UserBankCard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private User user;

  private String cardId;

  private String cardNumber;
  private String cvc;

  private String name;

  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  private Currency currency;
}
