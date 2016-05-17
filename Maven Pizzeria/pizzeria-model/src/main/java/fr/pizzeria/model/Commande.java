package fr.pizzeria.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ToString private Integer numeroCommande;
	@ToString private String status;
	private Date dateCommande;
	public Set<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	private Integer livreurId;
	private Integer clientId;
	
	@ManyToMany
	@JoinTable(name = "CommandePizza",
			joinColumns=
		@JoinColumn(name="commandeId", referencedColumnName="id"),
			inverseJoinColumns =
		@JoinColumn(name="pizzaId", referencedColumnName="code")
	)
	@ToString private Set<Pizza> pizzas;
	
	public Commande() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(Integer numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Integer getLivreurId() {
		return livreurId;
	}

	public void setLivreurId(Integer livreurId) {
		this.livreurId = livreurId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

}
