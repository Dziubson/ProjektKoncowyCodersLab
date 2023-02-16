package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.encje.Client;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select name from clients", nativeQuery = true)
    List<String> getAllUserNames();

    @Query("SELECT b FROM Client b WHERE b.user.login = ?1")
    List<Client> getDetails(String username);

    @Query("SELECT b.balance FROM Client b WHERE b.user.email = ?1")
    Long getBalanceByUserEmail(String email);

    @Query("update Client b set b.balance = ?1 WHERE b.email = ?2")
    void setClientBalance(Long balance, String email);

}
