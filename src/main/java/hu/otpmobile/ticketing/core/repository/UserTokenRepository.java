package hu.otpmobile.ticketing.core.repository;

import hu.otpmobile.ticketing.core.model.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserTokenRepository extends JpaRepository<UserToken, Long> {

  Optional<UserToken> findByToken(String token);
}
