package fr.pizzeria.model;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ToString private String code;
	@ToString(uppercase = true) private String nom;
	@ToString 
	private BigDecimal prix;
	@ToString 
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;
	private String urlImage;
	
	public static int nbPizzas;

	public Pizza() {
	}

	public Pizza(String code, String nom, BigDecimal prix) {
		this();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = CategoriePizza.VIANDE;
	}
	
	public Pizza(String code, String nom, BigDecimal prix, CategoriePizza cat) {
		this();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = cat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}
	
	public void cattt(Pizza p) {

	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
	
	private final static Map<String, String> FORMAT = new HashMap<String, String>();
	private final static String AUTRE_FORMAT = "(%s)";
	
	static {
		FORMAT.put("code", "%s ->");
		FORMAT.put("nom", "%s ***");
	}

	@Override
	public String toString() {
		return Arrays.asList(this.getClass().getDeclaredFields())
				.stream()
					.filter(field -> field.getAnnotation(ToString.class) !=null)
					.map(getValeurDuChamp())
					.collect(Collectors.joining(" "));
	}

	private Function<? super Field, ? extends String> getValeurDuChamp() {
		return field -> {
			
			String resultat = "";
			try {
				resultat= field.getAnnotation(ToString.class).uppercase() ? field.get(this).toString().toUpperCase() : field.get(this).toString();
			} catch (SecurityException | IllegalArgumentException | IllegalAccessException e1) {
					e1.printStackTrace();
			}
			
			String formatResultat = FORMAT.get(field.getName()) == null ? AUTRE_FORMAT : FORMAT.get(field.getName());
			
			return  String.format(formatResultat, resultat);
		};
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(31,1)
				.append(categorie)
				.append(code)
				.append(nom)
				.toHashCode();
		/*
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
		*/
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false; 
			}
		   if (obj == this) {
			   return true;
			   }
		   if (obj.getClass() != getClass()) {
		     return false;
		   }
		Pizza other = (Pizza) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(obj))
				.append(code, other.code)
				.append(nom, other.nom)
				.append(prix, other.prix)
				.isEquals();
		}
	
	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
				/*
		if (categorie != other.categorie)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
		*/
	

}
