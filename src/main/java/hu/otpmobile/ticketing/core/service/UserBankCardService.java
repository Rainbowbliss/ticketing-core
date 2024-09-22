package hu.otpmobile.ticketing.core.service;

import hu.otpmobile.ticketing.core.model.User;
import hu.otpmobile.ticketing.core.model.UserBankCard;
import hu.otpmobile.ticketing.core.repository.UserBankCardRepository;
import hu.otpmobile.ticketing.core.web.dto.UserPaymentRequest;
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
    return bankCardRepository.findByUser(user).orElseThrow(RuntimeException::new);
  }

  @Transactional
  public void pay(UserPaymentRequest userPaymentRequest) {
    var bankCard = bankCardRepository.findByCardId(userPaymentRequest.getCardId())
        .orElseThrow(RuntimeException::new);

    if (!bankCard.getUser().getId().equals(userPaymentRequest.getUserId())) {
      log.error("Ez a bankkártya nem ehhez a felhasználóhoz tartozik");
      throw new RuntimeException();
    }

    bankCard.setAmount(bankCard.getAmount().subtract(userPaymentRequest.getPrice()));

    bankCardRepository.save(bankCard);
  }
}
