package mangosoft.repository;

import mangosoft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    void deleteUserByUsername(String username);

    @Query("SELECT count(u) FROM User u")
    int countUsers();
}
