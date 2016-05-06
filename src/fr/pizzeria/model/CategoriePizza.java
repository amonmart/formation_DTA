package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE(1,"Viande"), POISSON(2,"Poisson"), SANS_VIANDE(3,"Sans Viande"),FRUITS(4,"Fruits"), NON_RENSEIGNE(99,"Non Renseignée");
	
	private String labelle;
	private Integer num;
	
	private CategoriePizza (Integer num, String labelle){
		this.labelle = labelle;
		this.num = num;
	}

	public String getLabelle() {
		return labelle;
	}
	
	public Integer getNum() {
		return num;
	}
	
	public static CategoriePizza getCategorieByInt(int categorie){
		CategoriePizza retour = null;
		
		for(CategoriePizza categories : CategoriePizza.values()){
			if (categories.num == categorie){
				retour = categories;
			}
		}
		if (retour == null){
			retour = CategoriePizza.NON_RENSEIGNE;
		}
		return retour;
	}
	

}
