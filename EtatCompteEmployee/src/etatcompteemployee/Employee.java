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
public class Employee {
    
     
    //public static JSONObject getEmployee() {
    //return employee;
    //}
    public static void main(String[] args) throws Exception {

        double etatParClient;
        JSONObject employee = new JSONObject();
        JSONArray interventions = new JSONArray();
        JSONObject intervention = new JSONObject();

        employee.accumulate("matricule_employe", "123456789");
        employee.accumulate("type_employe", 2);
        employee.accumulate("taux_horaire_min", 35.45);
        employee.accumulate("taux_horaire_max", 72.00);

        intervention.accumulate("code_client", "C123");
        intervention.accumulate("distance_deplacement", 4);
        intervention.accumulate("overtime", 1);
        intervention.accumulate("nombre_heures", 5);
        intervention.accumulate("date_intervention", "2023-04-14");

        interventions.add(intervention);

        employee.accumulate("interventions", interventions);

        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("count", 1); // Si la clé "count" n'existe pas, elle est créée avec la valeur 1
        jsonObject.accumulate("count", 2); // La valeur existante de la clé "count" est additionnée avec 2, donnant 3
        
        System.out.println(jsonObject);

        System.out.println(employee);
        //System.out.println(intervention.getInt("distance_deplacement"));

        etatParClient = EtatCompteCLient.EtatParClient(employee, intervention);

        System.out.println(etatParClient);
    }

}
