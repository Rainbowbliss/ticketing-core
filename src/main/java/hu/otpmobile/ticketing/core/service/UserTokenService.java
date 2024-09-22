package hu.otpmobile.ticketing.core.service;

import hu.otpmobile.ticketing.core.repository.UserTokenRepository;
import hu.otpmobile.ticketing.core.web.dto.UserDetailsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserTokenService {

  private final UserBankCardService userBankCardService;
  private final UserTokenRepository userRepository;

  public UserDetailsResponse validate(String tokenString) {
    var tokenOptional = userRepository.findByToken(tokenString);

    if (tokenOptional.isEmpty()) {
      log.error("A felhasználói token lejárt vagy nem értelmezhető");
      throw new RuntimeException();
    }
    var token = tokenOptional.get();
    var user = token.getUser();
    var userBankCard = userBankCardService.getUserBankCard(user);

    return new UserDetailsResponse(user.getId(), userBankCard.getCardId(),
        userBankCard.getAmount());
  }
}
