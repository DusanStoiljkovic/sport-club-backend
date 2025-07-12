package com.singidunum.sports_club_backend.repositories;

import com.singidunum.sports_club_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    @Query(nativeQuery=true, value="SELECT * FROM `sport-club`.user WHERE first_name = :firstName")
    List<User> findAllByFirstName(@Param("firstName") String firstName);
}
