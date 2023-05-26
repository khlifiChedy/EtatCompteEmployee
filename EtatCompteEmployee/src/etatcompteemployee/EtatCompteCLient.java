/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etatcompteemployee;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Lenovo
 */
/**public class EtatCompteCLient {

    public static double MontantRegulier(JSONObject employee, JSONObject intervention) {
        Double montantRegulier = 0.0;
       

        if (employee.getInt("type_employe") == 0) {
            montantRegulier = intervention.getInt("nombre_heures") * employee.getDouble("taux_horaire_min");

        } else if (employee.getInt("type_employe") == 1) {
            montantRegulier = intervention.getInt("nombre_heures")
                    * (employee.getDouble("taux_horaire_min") + employee.getDouble("taux_horaire_min")) / 2;

        } else if (employee.getInt("type_employe") == 2) {
            montantRegulier = intervention.getInt("nombre_heures") * employee.getDouble("taux_horaire_max");

        }

        return montantRegulier;
    }

    public static double MontantDeplacement(JSONObject employee, JSONObject intervention, double montantRegulier) {
        Double montantDeplacement = 0.0;

        switch (employee.getInt("type_employe")) {
            case 0:
                montantDeplacement = 200 - (intervention.getInt("distance_deplacement") * ((montantRegulier * 5) / 100));
                break;
            case 1:
                montantDeplacement = 200 - (intervention.getInt("distance_deplacement") * ((montantRegulier * 10) / 100));
                break;
            case 2:
                montantDeplacement = 200 - (intervention.getInt("distance_deplacement") * ((montantRegulier * 15) / 100));
                break;
            default:
                break;
        }

        return montantDeplacement;
    }

    public static double HeuresSupplementaires(JSONObject employee, JSONObject intervention) {

        Double heuresSupplementaires = 0.0;

        if (employee.getInt("type_employe") == 1) {

            if (intervention.getInt("nombre_heures") > 4 && intervention.getInt("nombre_heures") <= 8) {
                heuresSupplementaires = 50.00 * intervention.getInt("overtime");
            }
            else if (intervention.getInt("nombre_heures") > 8) {
                heuresSupplementaires = 100.00 * intervention.getInt("overtime");

            }

        } else if (employee.getInt("type_employe") == 2) {

            if (intervention.getInt("overtime") <= 4) {

                heuresSupplementaires = 75.00 * intervention.getInt("overtime");

            }

            else if (intervention.getInt("overtime") > 4) {
                heuresSupplementaires = 150.00 * intervention.getInt("overtime");

                if (heuresSupplementaires > 1500.00) {

                    heuresSupplementaires = 1500.00;

                }
            }

        }

        return heuresSupplementaires;
    }
    
    public static double EtatParClient (JSONObject employee, JSONObject intervention) {
        
        double etatParClient = 0.0;
        double montantRegulier = MontantRegulier( employee,  intervention);
        double montantDeplacement = MontantDeplacement( employee,  intervention, montantRegulier);
        double heuresSupplementaires  = HeuresSupplementaires( employee, intervention);
        
        etatParClient = montantRegulier + montantDeplacement + heuresSupplementaires;
          
        return  etatParClient;
    } 
    
    
}
* 
* /
