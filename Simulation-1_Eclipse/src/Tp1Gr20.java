
/*
 * I N F x 1 2 0
 *
 * D?crivez votre classe Tp1Gr20 ici.
 * 
 * 
 */
 
public class Tp1Gr20 {

    // Autres m?thodes s'il y a lieu
    
    public static void main (String[] params) {
        int nf = 1;// nombre de facture
        int np = 0;// nombre de participant
        int r1 = 0;// nombre de rabais de15%
        int r2 = 0;// nombre de rabais de 10%
        int r3 = 0;// nombre de rabais de 0%
        double r = 0; // montant total de rabais
        int ntp = 0;// nombre total de participant
        double ttps = 0;// total TPS
        double ttvq = 0;// total TVQ
        int numClient = 0;
        int nbrParticipant = 0;
        int durActivit = 0;
        int nombreTotalDeRabais = 0;
        int nombreTotalDeParticipant = 0;
        double montantAvantTaxesEtRabais = 0;
        double TPS = 0;
        double TVQ = 0;  
        double montantAvecTaxeSansRabais = 0;
        double montantFinal = 0;
        double revnuTotalSansTaxesAvecRabais = 0;
        double revenuTotalAvecTaxeSansRabais = 0;
        double rabais = 0;
        final double tps = 5.0 / 100;
        final double tvq = 8.5 / 100;
        
        System.out.println( "\n\n" );
        System.out.println( "Ce programme facture les forfaits vacance/plein air avec ou sans rabais selon le cas" ); 
        System.out.println( " et affiche un bilan des différentes exécutions à la fermeture du programme" );//présentation du programme
        System.out.println( "\n" );
        System.out.print( "N°Client ou un nombre negatif pour terminer: " );
        numClient = Clavier.lireInt();//pour entrer le numéro de client
        if (numClient < 0 )
        {System.out.print( " FIN NORMALE DU PROGRAMME" );// à l'entrer d'un nombre négatif le programme s'arrête
        }
    while (numClient >= 0 && numClient < 1000 || numClient > 3999)
        {System.out.println( "ERREUR!" );// indique numéro invalide
          System.out.print( "N°Client: " );
          numClient = Clavier.lireInt();//pour entrer un nouveau numéro de client
        }
        while (numClient >= 1000 && numClient <= 3999)
        {System.out.print( "Nombre de participant: " );//car muméro de client valide
          nbrParticipant = Clavier.lireInt();//pour entrer le nombre de participant
        
        while (nbrParticipant <= 0)
        { System.out.println( "ERREUR!");//nombre invalide
          System.out.print( "Nombre de participant: " );
          nbrParticipant = Clavier.lireInt();//pour entrer un nouveau nombre
         }
         if( nbrParticipant > 0)
          { System.out.print( "Durée de l'activité: ");//nombre valide
            durActivit = Clavier.lireInt();//pour entrer une durée
            while (durActivit < 0)
            {System.out.println( "ERREUR!" );// durée invalide
             System.out.print("Durée de l'activité: ");   
              durActivit = Clavier.lireInt();//pour entrer une nouvelle durée  
            }
            if (durActivit == 0)
            {System.out.println( " N° Client: " + numClient );
             System.out.println( " FACTURE ANNULÉE" );}
            else if (durActivit == 1 && nbrParticipant < 5)
            {montantAvantTaxesEtRabais = 50;}
            else if (durActivit == 1 && nbrParticipant >= 5)
            {montantAvantTaxesEtRabais = (50 * 4) + ( 45 * ( nbrParticipant - 4));} 
            else if (durActivit == 2 && nbrParticipant < 5)
            {montantAvantTaxesEtRabais = (50 * 2 - 5) * nbrParticipant;}
            else if (durActivit == 2 && nbrParticipant >= 5)
            {montantAvantTaxesEtRabais = ((50 * 2 - 5) * 4) + ((45 * 2 - 5) * (nbrParticipant - 4));}
            else if (durActivit > 2 && nbrParticipant < 5)
            {montantAvantTaxesEtRabais = ((50 * 2 - 5) + (30 * (durActivit - 2))) * nbrParticipant;}
            else 
            {montantAvantTaxesEtRabais = (((50 * 2 - 5) + (30 * (durActivit - 2))) * 4) + (((45 * 2 - 5) + (30 * (durActivit - 2))) * (nbrParticipant - 4));}
            nf = nf + 1;
            np = nbrParticipant;
            ntp = nbrParticipant + np ;
            TPS = montantAvantTaxesEtRabais * tps;
            TVQ = (montantAvantTaxesEtRabais + TPS) * tvq;
            ttps = TPS ;
            ttvq = TVQ;
            montantAvecTaxeSansRabais = montantAvantTaxesEtRabais + TPS + TVQ;
            if (numClient >= 1000 && numClient <= 1999)
            {rabais = montantAvantTaxesEtRabais * 15 / 100;
             r1 = r1 + 1;
            }
            else if (numClient >= 2000 && numClient <= 2999)
            {rabais = montantAvantTaxesEtRabais * 10 / 100;
             r2 = r2 + 1;
            }
            else
            {rabais = 0;
             r3 = r3 + 1;
            }
             r = rabais;
            montantFinal = montantAvecTaxeSansRabais + rabais;
            revenuTotalAvecTaxeSansRabais = montantAvecTaxeSansRabais;
            revnuTotalSansTaxesAvecRabais = montantFinal - TPS - TVQ;
            if (durActivit > 0)
            {System.out.println( " N° Client: " + numClient );
             System.out.println( "Durée de l'activitée: " + durActivit + "j" );
             System.out.println( "Nombre de participant(s): " + nbrParticipant );
             System.out.println( "Montant de la facture avant taxes et rabais: " + montantAvantTaxesEtRabais );
             System.out.println( "Tps: " + TPS );
             System.out.println( "Tvq: " + TVQ );
             System.out.println( "Montant avec taxe sans rabais: " + montantAvecTaxeSansRabais );
             System.out.println( "Rabais: " + rabais );
             System.out.println( "Montant final: " + montantFinal );
            }
           System.out.println( "\n\n" );
           System.out.println( "Ce programme facture les forfaits vacance/plein air avec ou sans rabais selon le cas" ); 
           System.out.println( " et affiche un bilan des différentes exécutions à la fermeture du programme" );//présentation du programme
           System.out.println( "\n" );
           System.out.print( "N°Client ou un nombre negatif pour terminer: " );
           numClient = Clavier.lireInt();//pour entrer le numéro de client
                   if (numClient < 0 )
        {System.out.print( " FIN NORMALE DU PROGRAMME" );// à l'entrer d'un nombre négatif le programme s'arrête
        }

    }
    
}
     if(nf >= 1 && numClient < 0)
            {System.out.println( "\n\n" );
             System.out.println( "Nombre total de participant: " + ntp);
             System.out.println( "Nombre total de rabais de 15%: " + r1);
             System.out.println( "Nombre total de rabais de 10%: " + r2 );
             System.out.println( "Nombre total de rabais de 0%: " + r3 );
             System.out.println( "Montant total de rabais: " + r);
             System.out.println( "Revenu total avec taxe sans rabais: " + revenuTotalAvecTaxeSansRabais);
             System.out.println( "Total Tps: " + ttps);
             System.out.println( "Total Tvq: " + ttvq);
             System.out.println( "Revenu total sans taxes avec rabais: " + revnuTotalSansTaxesAvecRabais);
             System.out.println( " FIN NORMALE DU PROGRAMME" );// à l'entrer d'un nombre négatif le programme s'arrête
            }
            
        
            
        
        
        
        
        
        
        
        
        
    
    } // main
    
} // Tp1Gr20
