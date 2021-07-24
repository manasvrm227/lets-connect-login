package com.lc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lc.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

	Optional<List<Authority>> findByUserName(String userName);
}
