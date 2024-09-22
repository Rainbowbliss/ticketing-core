package hu.otpmobile.ticketing.core.web.rest;

import hu.otpmobile.ticketing.core.service.UserBankCardService;
import hu.otpmobile.ticketing.core.service.UserService;
import hu.otpmobile.ticketing.core.service.UserTokenService;
import hu.otpmobile.ticketing.core.web.dto.UserDetailsResponse;
import hu.otpmobile.ticketing.core.web.dto.UserPaymentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserResource {

  private final UserBankCardService bankCardService;
  private final UserTokenService userTokenService;
  private final UserService userService;

  @GetMapping("/{id}")
  public UserDetailsResponse getUserDetails(@PathVariable Long id){
    return userService.getUserDetails(id);
  }

  @GetMapping("/validate")
  public UserDetailsResponse validate(@RequestHeader(name = "User-Token") String token) {
    return userTokenService.validate(token);
  }

  @PutMapping("/pay")
  public void pay(@RequestBody @Valid UserPaymentRequest userPaymentRequest) {
    bankCardService.pay(userPaymentRequest);
  }
}
