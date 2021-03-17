package com.example.donutondemand.model;

import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String name;
    
    @OneToMany(mappedBy = "role")
    private Set < User > users;
}
