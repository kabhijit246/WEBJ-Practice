package com.beehyv.assignment.model;

import javax.persistence.*;

@Entity
@Table(name="team")
public class Team {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	public Team() {	
	}
	
	public Team(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return "id="+id+", name="+name+"";
	}
}
