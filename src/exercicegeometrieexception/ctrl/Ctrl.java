package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }

    @Override
    public void selectCalcRadius(String value) {
        double valueDouble = 0;
        try {
            valueDouble = Double.parseDouble(value);

        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Réécrivez votre nombre en chiffre " + value + " : Invalide");
            refIhm.afficheResultatCircle(String.valueOf(0));
        }
        refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
    }

    @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {
        double valueAreaDouble = 0;
        double valueLongueurDouble = 0;
        try {
            valueAreaDouble = Double.parseDouble(valueArea);
        } catch (NumberFormatException e) {
            valueAreaDouble = Double.MIN_VALUE;
            refIhm.afficheMessage("Réécrivez votre nombre en chiffre " + valueArea + " : Invalide");

        }
        try {
            valueLongueurDouble = Double.parseDouble(valueLongueur);
        } catch (NumberFormatException e) {
            valueLongueurDouble=Double.MIN_VALUE;
            refIhm.afficheMessage("Réécrivez votre nombre en chiffre " + valueLongueur + " : Invalide");
        }
        refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
