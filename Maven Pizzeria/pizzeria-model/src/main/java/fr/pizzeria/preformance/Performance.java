package fr.pizzeria.preformance;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String service;
	private Calendar date;
	private Long tempsExec;
	
	public Performance() {
	}
	
	public Performance(String service, Calendar date, Long tempsExec) {
		super();
		this.service = service;
		this.date = date;
		this.tempsExec = tempsExec;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public Long getTempsExec() {
		return tempsExec;
	}
	public void setTempsExec(Long tempsExec) {
		this.tempsExec = tempsExec;
	}
}
