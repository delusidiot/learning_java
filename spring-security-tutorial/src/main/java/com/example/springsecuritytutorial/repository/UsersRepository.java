package com.example.springsecuritytutorial.repository;

import com.example.springsecuritytutorial.model.Users;
import lombok.NonNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"authorities"})
    Optional<Users> findByUsername(String username);
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"authorities"})
    @NonNull
    List<Users> findAll();
}
