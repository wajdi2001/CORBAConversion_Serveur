package service;

import corbaConversion.IConversionRemotePOA;

// Classe implémentant l'interface IConversionRemotePOA
public class ConversionImpl extends IConversionRemotePOA {

    // Méthode de conversionMontant, héritée de l'interface IConversionRemote
    @Override
    public double conversionMontant(double montant) {
        // Logique de conversion : multiplie le montant par 3.3 (exemple arbitraire)
        return montant * 3.3;
    }
}
