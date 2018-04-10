package org.shane.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paramotor {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pmtr_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name="pmtr_name")
	private String name;
	@Column(name="engn_name")
	private String engineName;
	@Column(name="engn_size_cc")
	private float engineSizeCC;
	@Column(name="prop_size_inch")
	private int propSizeInches;
	
	public Paramotor(String name, String engineName,
			float engineSizeCC, int propSizeInches) 
	{
		super();
		this.name = name;
		this.engineName = engineName;
		this.engineSizeCC = engineSizeCC;
		this.propSizeInches = propSizeInches;
	}
	
	public Paramotor() {  }
	
	
	public Long getId() {
		return id;
	}
	
	public synchronized String getName() {
		return name;
	}
	
	public synchronized String getEngineName() {
		return engineName;
	}
	
	public  synchronized double getEngineSizeCC() {
		return engineSizeCC;
	}
	
	public synchronized int getPropSizeInches() {
		return propSizeInches;
	}
	
	public synchronized void copyDetailsFrom(Paramotor p) {
		this.name = p.name;
		this.engineName = p.engineName;
		this.engineSizeCC = p.engineSizeCC;
		this.propSizeInches = p.propSizeInches;
	}

	@Override
	public String toString() {
		return "Paramotor [id=" + id + ", name=" + name + ", engineName=" + engineName + ", engineSizeCC="
				+ engineSizeCC + ", propSizeInches=" + propSizeInches + "]";
	}
	
	
	
}
