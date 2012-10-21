
/*
 * I N F x 6 1 5 0
 *
 * Le projet ''Facturation forfait plein air'' vise une clientele qui souhaite
 * reserver des forfaits vacances en plein air pour différentes activites.
 * Il consiste a ameliorer le processus de facturation et la flexibilite du logiciel en
 * integrant de nouvelles regles ayant trait aux taxes et aux rabais.
 * 
 * Equipe
 * 
 * Christian Niore NIOC22038808
 * Claude Boisvert BOIC16096504
 * Karl Brodeur    BROK09028701
 * Samira Feddag   FEDS04518206
 * Naimi Abdelilah NAIA16015901
 */
 
import java.text.DecimalFormat;

public class EclipseSim1 {

    // Autres m?thodes s'il y a lieu
    
    public static void main (String[] params) {
           
        //Les doubles utilises pour le calcul des rabais, des taxes et des revenus.
        double montantAvantTaxesEtRabais = 0;
        double montantAvecTaxeSansRabais = 0;
        double montantFinal = 0;
        double montantRabais = 0;
        double montantTaxe = 0;
        double revenuTotalSansTaxesAvecRabais = 0;
        double revenuTotalAvecTaxeSansRabais = 0;
        double totalRabais = 0; // montant total de rabais
        double totalRabais5 = 0; 
        double totalRabais10 = 0;
        double totalRabais15 = 0;
        double totalRabaisJour1 = 0;
        double totalRabaisJour2 = 0;
        double totalRabaisJour3 = 0;
        double prixSansRabais = 0;
        double totalTaxe = 0;// total TPS
        
        //La taxe de 15% est une constante.
        final double TAXE = 15.0 / 100;
        
        //Les entiers qui servent de compteurs, de numero de client et de duree dactivite.
        int dureeActivite = 0;
        int nbFacture = 0;// nombre de facture
        int nbParticipant = 0;// nombre de participants
        int nbRabais0 = 0;// nombre de rabais de 0%  
        int nbRabais5 = 0;// nombre de rabais de 5%
        int nbRabais10 = 0;// nombre de rabais de 10%
        int nbRabais15 = 0;// nombre de rabais de15%        
        int nbTotalParticipant = 0;// nombre total de participants
        int numClient = 0;

        
        //Decris le programme a l'utilisateur
        System.out.println( "\n\n" );
        System.out.println( "==========================================================================================" );
        System.out.println( "Ce programme facture les forfaits vacance/plein air avec ou sans rabais selon le cas et" ); 
        System.out.println( "affiche un bilan des differentes executions a la fermeture du programme\n" );//presentation du programme
        System.out.println( "------------------------------------------------------------------------------------------" );
        System.out.println( "\n" );
        System.out.print( "Entrer un numéro de client ou -1 pour terminer : " );
        numClient = Clavier.lireInt();//pour entrer le numero de client
        
        if (numClient < 0 ){
            System.out.print( "\nFIN NORMALE DU PROGRAMME" );// ? l'entrer d'un nombre negatif le programme s'arrete
        }
        
        while (numClient >= 0 && numClient < 1000 || numClient > 4999){
            System.out.println( "ERREUR! Ce numero est invalide." );// indique numero invalide
            System.out.print( "Entrer un numéro de client ou -1 pour terminer : " );
            numClient = Clavier.lireInt();//pour entrer un nouveau num?ro de client
        }
        
        while (numClient >= 1000 && numClient <= 4999){
            System.out.print( "Nombre de participant(s) ......: " );//car mumero de client valide
            nbParticipant = Clavier.lireInt();//pour entrer le nombre de participant
        
            while (nbParticipant <= 0){ 
                System.out.println( "ERREUR!");//nombre invalide
                System.out.print( "Nombre de participant(s) ......: " );
                nbParticipant = Clavier.lireInt();//pour entrer un nouveau nombre
            }
            
            if( nbParticipant > 0){ 
                System.out.print( "Durée de l'activité ...........: ");//nombre valide
                dureeActivite = Clavier.lireInt();//pour entrer une duree
                
                while (dureeActivite < 0){
                    System.out.println( "ERREUR! Duree invalide." );// duree invalide
                    System.out.print("Durée de l'activité ...........: ");   
                    dureeActivite = Clavier.lireInt();//pour entrer une nouvelle duree  
                }
                
                //Calcul du prix de base sans aucun rabais
                if (dureeActivite > 0){
                    prixSansRabais = 50 * nbParticipant * dureeActivite;
                }
                
                //Defini le prix de l'activite avant le rabais et les taxes  
                if (dureeActivite == 0){
                    System.out.println( "Numéro de client ..............: " + numClient );
                    System.out.println( "FACTURE ANNULEE" );
                    nbFacture = nbFacture - 1;
                }else if (dureeActivite == 1 && nbParticipant < 5){
                    montantAvantTaxesEtRabais = 50 * nbParticipant;
                }else if (dureeActivite == 1 && nbParticipant >= 5){
                    montantAvantTaxesEtRabais = (50 * 4) + ( 45 * ( nbParticipant - 4));
                    //totalRabaisJour1 = totalRabaisJour1 + prixSansRabais - montantAvantTaxesEtRabais; 
                }else if (dureeActivite == 2 && nbParticipant < 5){
                    montantAvantTaxesEtRabais = ((50 * 2 - 5) * nbParticipant);
                    //totalRabaisJour2 = totalRabaisJour2 + prixSansRabais - montantAvantTaxesEtRabais;
                }else if (dureeActivite == 2 && nbParticipant >= 5){
                    montantAvantTaxesEtRabais = ((50 * 2 - 5) * 4) + ((45 * 2 - 5) * (nbParticipant - 4));
                    //totalRabaisJour2 = totalRabaisJour2 + prixSansRabais - montantAvantTaxesEtRabais;
                }else if (dureeActivite > 2 && nbParticipant < 5){
                    montantAvantTaxesEtRabais = ((50 * 2 - 5) + (30 * (dureeActivite - 2))) * nbParticipant;
                    //totalRabaisJour3 = totalRabaisJour3 + prixSansRabais - montantAvantTaxesEtRabais;
                }else{
                    montantAvantTaxesEtRabais = (((50 * 2 - 5) + (30 * (dureeActivite - 2))) * 4) + (((45 * 2 - 5) + (30 * (dureeActivite - 2))) * (nbParticipant - 4));
                    //totalRabaisJour3 = totalRabaisJour3 + prixSansRabais - montantAvantTaxesEtRabais;
                }
            
                nbFacture = nbFacture + 1;
                nbTotalParticipant = nbTotalParticipant + nbParticipant;
           
                //Defini le rabais a appliquer selon le numero de client
                if (numClient >= 1000 && numClient <= 1999){
                    montantRabais = montantAvantTaxesEtRabais * 15 / 100;
                    nbRabais15 = nbRabais15 + 1;
                    totalRabais15 = totalRabais15 + montantRabais;
                }else if (numClient >= 2000 && numClient <= 2999){
                    montantRabais = montantAvantTaxesEtRabais * 10 / 100;
                    nbRabais10 = nbRabais10 + 1;
                    totalRabais10 = totalRabais10 + montantRabais;
                }else if (numClient >= 3000 && numClient <= 3999){
                    montantRabais = montantAvantTaxesEtRabais * 5 / 100;
                    nbRabais5 = nbRabais5 + 1;
                    totalRabais5 = totalRabais5 + montantRabais;
                }else{
                    montantRabais = 0;
                    nbRabais0 = nbRabais0 + 1;
                }
                
                //Calcul des rabais selon le nombre de jours
                if (dureeActivite == 1){
                    totalRabaisJour1 = totalRabaisJour1 + montantRabais;
                }else if(dureeActivite == 2){
                    totalRabaisJour2 = totalRabaisJour2 + montantRabais;
                }else if(dureeActivite >= 3){
                    totalRabaisJour3 = totalRabaisJour3 + montantRabais;
                }
                
                //Calcul des taxes et des rabais.
                totalRabais = totalRabais + montantRabais;
                montantTaxe = ( montantAvantTaxesEtRabais - montantRabais ) * TAXE;
                totalTaxe = montantTaxe + totalTaxe ;
                montantAvecTaxeSansRabais = montantAvantTaxesEtRabais + montantTaxe;
                montantFinal = montantAvecTaxeSansRabais - montantRabais;
                revenuTotalAvecTaxeSansRabais = revenuTotalAvecTaxeSansRabais + montantAvecTaxeSansRabais;
                revenuTotalSansTaxesAvecRabais = revenuTotalSansTaxesAvecRabais + montantFinal - montantTaxe;
            
                //Affiche les infos de l'activite qui vient d'etre entree
                if (dureeActivite > 0){
                    System.out.println( "\n      F A C T U R E \n");
                    System.out.println( "Numéro de client ..............: " + numClient );
                    System.out.println( "Durée de l'activité ...........: " + dureeActivite + " jour(s)" );
                    System.out.println( "Nombre de participant(s) ......: " + nbParticipant );
                    System.out.println( "\nActivités .....................: $" + montantAvantTaxesEtRabais );
                    System.out.println( "Taxe harmonisee ...............: $" + ((double)Math.round(montantTaxe * 100) / 100));
                    System.out.println( "Sous-total ....................: $" + ((double)Math.round(montantAvecTaxeSansRabais * 100) / 100));
                    System.out.println( "Rabais ........................: $" + ((double)Math.round(montantRabais * 100) / 100));
                    System.out.println( "Total .........................: $" + ((double)Math.round(montantFinal * 100) / 100));
                }
                
                //Demande a l'utilisateur s'il veut continuer d'entrer des factures
                System.out.println( "\n" );
                System.out.println( "==========================================================================================" );
                System.out.println( "Ce programme facture les forfaits vacance/plein air avec ou sans rabais selon le cas et" ); 
                System.out.println( "affiche un bilan des differentes executions a la fermeture du programme\n" );//presentation du programme
                System.out.println( "------------------------------------------------------------------------------------------" );
                System.out.println( "\n" );
                System.out.print( "Entrer un numéro de client ou -1 pour terminer : " );
                numClient = Clavier.lireInt();//pour entrer le numero de client
                
                while (numClient >= 0 && numClient < 1000 || numClient > 4999){
                    System.out.println( "ERREUR! Ce numero est invalide." );// indique numero invalide
                    System.out.print( "Entrer un numéro de client ou -1 pour terminer : " );
                    numClient = Clavier.lireInt();//pour entrer un nouveau num?ro de client
                }
                
                if(numClient < 0 && nbFacture <= 0){
                    System.out.println( "\n==========================================================================================" );
                    System.out.println( "FIN NORMALE DU PROGRAMME\n" );// a l'entrer d'un nombre negatif le programme s'arrete
                }

            }//if( nbParticipant > 0)
    
        }//while (numClient >= 1000 && numClient <= 4999)
        
        //Affichage des informatino de sortie du programme avec 1 facture au moins
        if(nbFacture >= 1 && numClient < 0){
            System.out.println( "\n\n" );
            System.out.println( "B I L A N  D E  F E R M E T U R E\n" );
            System.out.println( "Nombre de participant(s) .....................: " + nbTotalParticipant);
            System.out.println( "Nombre de rabais de 15% ......................: " + nbRabais15);
            System.out.println( "Nombre de rabais de 10% ......................: " + nbRabais10);
            System.out.println( "Nombre de rabais de 5% .......................: " + nbRabais5);
            System.out.println( "Nombre de rabais de 0% .......................: " + nbRabais0);
            
            System.out.println( "\nMontant de rabais de 15% .....................: $" + ((double)Math.round(totalRabais15 * 100) / 100));
            System.out.println( "Montant de rabais de 10% .....................: $" + ((double)Math.round(totalRabais10 * 100) / 100));
            System.out.println( "Montant de rabais de 5% ......................: $" + ((double)Math.round(totalRabais5 * 100) / 100));
            System.out.println( "Montant de rabais activités de 1 jour ........: $" + ((double)Math.round(totalRabaisJour1 * 100) / 100) );
            System.out.println( "Montant de rabais activités de 2 jours .......: $" + ((double)Math.round(totalRabaisJour2 * 100) / 100) );
            System.out.println( "Montant de rabais activités de 3 jours et + ..: $" + ((double)Math.round(totalRabaisJour3 * 100) / 100) );
            
            System.out.println( "\nRevenu total brut ............................: $" + ((double)Math.round(revenuTotalAvecTaxeSansRabais * 100) / 100));
            System.out.println( "Total de rabais ..............................: $" + ((double)Math.round(totalRabais * 100) / 100));
            System.out.println( "Total taxe harmonisée ........................: $" + ((double)Math.round(totalTaxe * 100) / 100));
            System.out.println( "Revenu total .................................: $" + ((double)Math.round(revenuTotalSansTaxesAvecRabais * 100) / 100));
            System.out.println( "\n==========================================================================================" );
            System.out.println( "FIN NORMALE DU PROGRAMME" );// a l'entrer d'un nombre negatif le programme s'arrete
   
        }
    
    } // main
    
} // EclipseSim1