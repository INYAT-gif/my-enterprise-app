package se.inyat.myenterpriseapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.inyat.myenterpriseapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
