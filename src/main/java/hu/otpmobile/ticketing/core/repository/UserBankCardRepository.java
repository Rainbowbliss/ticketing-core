package hu.otpmobile.ticketing.core.repository;

import hu.otpmobile.ticketing.core.model.User;
import hu.otpmobile.ticketing.core.model.UserBankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserBankCardRepository extends JpaRepository<UserBankCard, Long> {

  Optional<UserBankCard> findByUser(User user);

  Optional<UserBankCard> findByCardId(String cardId);
}
