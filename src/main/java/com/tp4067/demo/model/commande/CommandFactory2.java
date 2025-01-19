package com.tp4067.demo.model.commande;

    import com.tp4067.demo.model.commande.Commande2;
    
    import java.util.Date;  
    import java.util.List;  
    
public interface CommandFactory2 {
    Commande2 createCommande2(List<String> nomvehicules, Date dateLivraison, String userName, int idUser, String paysLivraison,double montant);  

}
