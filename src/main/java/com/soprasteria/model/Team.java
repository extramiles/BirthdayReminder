package com.soprasteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="teams")
	public class Team {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="team_id")
		private int team_id;

		@Column(name="team_name")
		private String team_name;
		
		@Column(name="project_id")
		private String project_id;

		public int getTeam_id() {
			return team_id;
		}

		public void setTeam_id(int team_id) {
			this.team_id = team_id;
		}

		public String getTeam_name() {
			return team_name;
		}

		public void setTeam_name(String team_name) {
			this.team_name = team_name;
		}

		public String getProject_id() {
			return project_id;
		}

		public void setProject_id(String project_id) {
			this.project_id = project_id;
		}
		
		

}
