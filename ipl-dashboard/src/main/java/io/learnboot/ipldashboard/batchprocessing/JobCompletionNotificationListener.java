package io.learnboot.ipldashboard.batchprocessing;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import io.learnboot.ipldashboard.model.Team;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener{

	
	  private final EntityManager em;

	 
	  @Autowired
	  public JobCompletionNotificationListener(EntityManager em) {
	    this.em = em;
	  }

	  @Override
	  public void afterJob(JobExecution jobExecution) {
	    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
	    	Map<String, Team> teamData=new HashMap<>();
	    	
	    	em.createQuery("select m.team1,count(*) from match m group by m.team1",Object[].class)
	    	.getResultList()
	    	.stream()
	    	.map(e->new Team((String)e[0],(Long)e[1]))
	    	.forEach(team ->  teamData.put(team.getTeamName(),team));
	    }
	   
	  }

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		
	}
}
