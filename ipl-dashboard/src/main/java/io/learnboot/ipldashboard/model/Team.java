package io.learnboot.ipldashboard.model;

import javax.persistence.Entity;

@Entity
public class Team {

    
	private Long id;
    private String teamName;
    private Long totalMatches;
    private Long totalWins;

}
