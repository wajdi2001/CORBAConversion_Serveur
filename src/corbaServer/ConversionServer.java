package corbaServer;


import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import service.ConversionImpl;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConversionServer {
    public static void main(String[] args) throws InvalidName, NamingException, WrongPolicy, ServantNotActive, AdapterInactive {
        // Initialisation de l'ORB (Object Request Broker)
        ORB orb = ORB.init(args, null);

        // Récupération du POA (Portable Object Adapter) à partir de l'ORB
        POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

        // Activation du POA pour qu'il puisse gérer les objets
        poa.the_POAManager().activate();

        // Création d'une instance de ConversionImpl, une classe qui implémente les opérations de conversion
        ConversionImpl conversion = new ConversionImpl();

        // Initialisation d'un contexte pour gérer les objets distants
        Context ctx = new InitialContext();

        // Liaison de l'objet ConversionImpl avec un nom "CV" dans le contexte
        ctx.rebind("CV", poa.servant_to_reference(conversion));

        // Lancement de l'ORB pour écouter les demandes des clients
        orb.run();
    }
}
