package hu.otpmobile.ticketing.core.repository;

import hu.otpmobile.ticketing.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
