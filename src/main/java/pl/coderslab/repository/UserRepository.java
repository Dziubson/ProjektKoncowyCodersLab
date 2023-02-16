package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.encje.User;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT b FROM User b WHERE b.role = ?1")
    List<User> getAll(String role);

    @Query(value = "SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM User b WHERE b.login = ?1 AND b.password = ?2")
    Boolean search(String username, String password);




}
