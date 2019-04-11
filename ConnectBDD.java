/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author julie
 */
public class ConnectBDD {
    
    
    public static Connection connexion(){
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver charger");
            
            String url = "jdbc:mysql://localhost:3306/opixdev1_gestlab?autoReconnect=true&useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
            
            Connection connect = DriverManager.getConnection(url, "root","");
            System.out.println("Connexion réussi mother fucker");
            return connect;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur : "+ex);
            JOptionPane.showMessageDialog(null,"impossible de se oconnecter","erreur",JOptionPane.ERROR_MESSAGE);
            
            System.exit(1);
            return null;
        } 
        
        
    }
    
    
    public static ResultSet rqLogin(Connection connect, String login, String mdp) throws SQLException{
        Statement stmt = connect.createStatement();
        
        String rq = "Select id, pseudo From connexion where pseudo=\""+login+"\" AND mdp=\""+mdp+"\";";
        
        
        return stmt.executeQuery(rq);
        
        
    }

    
    //requete appareillage
    public static ResultSet rqMeubleAppareillage(Connection connect) throws SQLException{
        Statement stmt = connect.createStatement();  
        String rq = "Select * From materiels WHERE domaine = 'appareillage'";
        return stmt.executeQuery(rq);        
    }

    //requete media
    public static ResultSet rqMeubleMedia(Connection connect) throws SQLException{
        Statement stmt = connect.createStatement();  
        String rq = "Select * From materiels WHERE domaine = 'media'";
        return stmt.executeQuery(rq);        
    }
    
    //requete materiel de laboratoire
    public static ResultSet rqMeubleeMaterielDeLaboratoire(Connection connect) throws SQLException{
        Statement stmt = connect.createStatement();  
        String rq = "Select * From materiels WHERE domaine = 'materieldelaboratoire'";
        return stmt.executeQuery(rq);        
    }
    
     //requete electricite
    public static ResultSet rqMeubleeElectricite(Connection connect) throws SQLException{
        Statement stmt = connect.createStatement();  
        String rq = "Select * From materiels WHERE domaine = 'electricite'";
        return stmt.executeQuery(rq);        
    }
    
    //requete produit chimique
    public static ResultSet rqMeubleeProduitChimique(Connection connect) throws SQLException{
        Statement stmt = connect.createStatement();  
        String rq = "Select * From materiels WHERE domaine = 'produitchimique'";
        return stmt.executeQuery(rq);        
    }
    
    //requete verreries et associes
    public static ResultSet rqMeubleeVerreriesEtAssocies(Connection connect) throws SQLException{
        Statement stmt = connect.createStatement();  
        String rq = "Select * From materiels WHERE domaine = 'verreriesetassocies'";
        return stmt.executeQuery(rq);        
    }
    
    
    
    //requete verreries et associes
    public static ResultSet rqMeubleeAppSc(Connection connect, String Dom, String Sc) throws SQLException{
        Statement stmt = connect.createStatement();  
        String rq = "Select * From materiels WHERE domaine = \""+Dom+"\" AND categorie =\""+Sc+"\" ;";
        return stmt.executeQuery(rq);   
        
    }
    
    
     //requete alerte
    public static ResultSet rqMeubleeAlerte(Connection connect, String Dom, String Sc) throws SQLException{
        Statement stmt = connect.createStatement();  
        String rq = "Select * From materiels WHERE quantite < alerte";
        return stmt.executeQuery(rq); 
    }
    
     //requete full meuble
    public static ResultSet rqMeublee(Connection connect, String Dom, String Sc) throws SQLException{
        Statement stmt = connect.createStatement();  
        String rq = "Select * From materiels";
        return stmt.executeQuery(rq); 
    }
    
    
     //requete nom
    public static ResultSet rqMeubleeName(Connection connect, String nom) throws SQLException{
        Statement stmt = connect.createStatement();  
        String rq = "Select * From materiels WHERE nom= \'"+nom+"\' ;";
        return stmt.executeQuery(rq); 
    }
    
    
    
       
    
     
     //requete ajout d'un matériel
    public static ResultSet rqMeubleAjout(String nom, String precision, String rcommentaire, String reference, int Quantite, int alerte, String information, String securite, String expiration, String domaine, String categorie) throws SQLException{
        Statement stmt = connect.createStatement();  
        String rq = "INSERT INTO materiels (nom, precisions, rcommentaire, reference, quantite, alerte, information, securite, expiration, domaine , categorie) VALUES( "+nom , precision, rcommentaire , reference ,Quantite, alerte, information, securite, expiration +")";
        return stmt.executeQuery(rq); 
    }

}
