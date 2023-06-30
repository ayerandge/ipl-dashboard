package io.learnboot.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.learnboot.ipldashboard.model.Match;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {


}
