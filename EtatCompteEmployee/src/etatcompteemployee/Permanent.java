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
public class Permanent extends Employee {
    
    public static double MontantRegulier(JSONObject employee, JSONObject intervention) {
        Double montantRegulier = 0.0;
         montantRegulier = intervention.getInt("nombre_heures")
                    * (employee.getDouble("taux_horaire_min") + employee.getDouble("taux_horaire_min")) / 2;

        return montantRegulier;
    }

    public static double MontantDeplacement(JSONObject employee, JSONObject intervention, double montantRegulier) {
        Double montantDeplacement = 0.0;

        
            montantDeplacement = 200 - (intervention.getInt("distance_deplacement") * ((montantRegulier * 10) / 100));
            

        return montantDeplacement;
    }

    public static double HeuresSupplementaires(JSONObject employee, JSONObject intervention) {

        Double heuresSupplementaires = 0.0;

        

            if (intervention.getInt("nombre_heures") > 4 && intervention.getInt("nombre_heures") <= 8) {
                heuresSupplementaires = 50.00 * intervention.getInt("overtime");
            }
            else if (intervention.getInt("nombre_heures") > 8) {
                heuresSupplementaires = 100.00 * intervention.getInt("overtime");

            }

        

        return heuresSupplementaires;
    }
    
    public static double EtatParClient (JSONObject employee, JSONObject intervention) {
        
        double montantRegulier = MontantRegulier( employee,  intervention);
        double montantDeplacement = MontantDeplacement( employee,  intervention, montantRegulier);
        double heuresSupplementaires  = HeuresSupplementaires( employee, intervention);
          
        return  montantRegulier + montantDeplacement + heuresSupplementaires;
    } 
    
}
