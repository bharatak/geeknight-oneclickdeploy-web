package com.geeknight.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Greet implements Serializable{

	@javax.persistence.Id
	@GeneratedValue
	private Long Id;

	@Column(nullable = false)
	private String name;

	@Column(name="created_at", updatable = false, insertable = false)
	private Date createdAt;

	public Greet(){}

	public Greet(String name) {
		this.name = name;
	}

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}

	@Override
	public String toString() {
		return "Greet{" +
				"Id=" + Id +
				", name='" + name + '\'' +
				", createdAt=" + createdAt +
				'}';
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
