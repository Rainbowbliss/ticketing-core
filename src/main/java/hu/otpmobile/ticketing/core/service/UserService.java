package hu.otpmobile.ticketing.core.service;

import hu.otpmobile.ticketing.core.repository.UserRepository;
import hu.otpmobile.ticketing.core.web.dto.UserDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserBankCardService userBankCardService;

  public UserDetailsResponse getUserDetails(Long id) {
    var user = userRepository.findById(id).orElseThrow(RuntimeException::new);
    var bankCard = userBankCardService.getUserBankCard(user);
    return new UserDetailsResponse(user.getId(), bankCard.getCardId(), bankCard.getAmount());
  }
}
