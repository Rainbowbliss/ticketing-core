package hu.otpmobile.ticketing.core.service;

import hu.otpmobile.ticketing.core.model.User;
import hu.otpmobile.ticketing.core.model.UserBankCard;
import hu.otpmobile.ticketing.core.repository.UserBankCardRepository;
import hu.otpmobile.ticketing.core.web.dto.UserPaymentRequest;
import hu.otpmobile.ticketing.core.web.error.ErrorType;
import hu.otpmobile.ticketing.core.web.error.exception.TicketingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserBankCardService {

  private final UserBankCardRepository bankCardRepository;

  public UserBankCard getUserBankCard(User user) {
    return bankCardRepository.findByUser(user)
        .orElseThrow(() -> new TicketingException(ErrorType.RESOURCE_NOT_FOUND));
  }

  @Transactional
  public void pay(UserPaymentRequest userPaymentRequest) {
    var bankCard = bankCardRepository.findByCardId(userPaymentRequest.getCardId())
        .orElseThrow(() -> new TicketingException(ErrorType.RESOURCE_NOT_FOUND));

    if (!bankCard.getUser().getId().equals(userPaymentRequest.getUserId())) {
      log.error("Ez a bankkártya nem ehhez a felhasználóhoz tartozik");
      throw new TicketingException(ErrorType.WRONG_BANK_CARD_ID);
    }

    bankCard.setAmount(bankCard.getAmount().subtract(userPaymentRequest.getPrice()));

    bankCardRepository.save(bankCard);
  }
}
