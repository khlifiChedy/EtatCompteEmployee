/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package etatcompteemployee;

/**
 *
 * @author Lenovo
 */
public class EtatCompteEmployee {

    public static double etatCompteEmploye(double etatParClient) {
        double sommeCompteEmploye = 0.0;
        double montantFixe = 733.77;

        sommeCompteEmploye = Math.ceil(etatParClient + montantFixe);

        return sommeCompteEmploye;
    }

    public static double CoutFixe(double sommeCompteEmploye) {
        double coutFix = 0.0;

        coutFix = Math.ceil(sommeCompteEmploye * 0.012);

        return coutFix;
    }

    public static double CoutVariable(double sommeCompteEmploye) {
        double coutVariable = 0.0;

        coutVariable = Math.ceil(sommeCompteEmploye * 0.025);

        return coutVariable;
    }

}
