package com.revature.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="student_name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="course")
	private String course;
	
}
