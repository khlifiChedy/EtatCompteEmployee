/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etatcompteemployee;

import net.sf.json.JSONObject;

/**
 *
 * @author Lenovo
 */
public class Superviseur extends Employee {
    
     public static double MontantRegulier(JSONObject employee, JSONObject intervention) {
             


        return intervention.getInt("nombre_heures") * employee.getDouble("taux_horaire_min");
    }

    public static double MontantDeplacement(JSONObject employee, JSONObject intervention, double montantRegulier) {
        

        return 200 - (intervention.getInt("distance_deplacement") * ((montantRegulier * 5) / 100));
    }

    public static double HeuresSupplementaires(JSONObject employee, JSONObject intervention) {

               

        return 0.0;
    }
    
    public static double EtatParClient (JSONObject employee, JSONObject intervention) {
        
        double montantRegulier = MontantRegulier( employee,  intervention);
        double montantDeplacement = MontantDeplacement( employee,  intervention, montantRegulier);
        double heuresSupplementaires  = HeuresSupplementaires( employee, intervention);
          
        return  montantRegulier + montantDeplacement + heuresSupplementaires;
    } 
    
    
    
}
