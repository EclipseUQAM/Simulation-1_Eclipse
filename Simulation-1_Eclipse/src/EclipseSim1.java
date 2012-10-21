
/*
 * I N F x 6 1 5 0
 *
 * Le projet ''Facturation forfait plein air'' vise une clientele qui souhaite
 * reserver des forfaits vacances en plein air pour diff�rentes activites.
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
 
public class EclipseSim1 {

    // Autres methodes s'il y a lieu
    
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
        System.out.println( "Ce programme facture les forfaits vacance/plein air avec ou sans rabais selon le cas" ); 
        System.out.println( " et affiche un bilan des differentes executions a la fermeture du programme" );//presentation du programme
        System.out.println( "\n" );
        System.out.print( "NumClient ou un nombre negatif pour terminer: " );
        numClient = Clavier.lireInt();//pour entrer le numero de client
        
        if (numClient < 0 ){
            System.out.print( " FIN NORMALE DU PROGRAMME" );// ? l'entrer d'un nombre negatif le programme s'arrete
        }
        
        while (numClient >= 0 && numClient < 1000 || numClient > 4999){
            System.out.println( "ERREUR!" );// indique numero invalide
            System.out.print( "NumClient: " );
            numClient = Clavier.lireInt();//pour entrer un nouveau num?ro de client
        }
        
        while (numClient >= 1000 && numClient <= 4999){
            System.out.print( "Nombre de participant: " );//car mumero de client valide
            nbParticipant = Clavier.lireInt();//pour entrer le nombre de participant
        
            while (nbParticipant <= 0){ 
                System.out.println( "ERREUR!");//nombre invalide
                System.out.print( "Nombre de participant: " );
                nbParticipant = Clavier.lireInt();//pour entrer un nouveau nombre
            }
            
            if( nbParticipant > 0){ 
                System.out.print( "Duree de l'activit?: ");//nombre valide
                dureeActivite = Clavier.lireInt();//pour entrer une dur?e
                
                while (dureeActivite < 0){
                    System.out.println( "ERREUR!" );// duree invalide
                    System.out.print("Duree de l'activite: ");   
                    dureeActivite = Clavier.lireInt();//pour entrer une nouvelle duree  
                }
                
                //Defini le prix de l'activite avant le rabais et les taxes
                if (dureeActivite == 0){
                    System.out.println( " Num Client: " + numClient );
                    System.out.println( " FACTURE ANNULEE" );
                    nbFacture = nbFacture - 1;
                }else if (dureeActivite == 1 && nbParticipant < 5){
                    montantAvantTaxesEtRabais = 50 * nbParticipant;
                }else if (dureeActivite == 1 && nbParticipant >= 5){
                    montantAvantTaxesEtRabais = (50 * 4) + ( 45 * ( nbParticipant - 4));
                }else if (dureeActivite == 2 && nbParticipant < 5){
                    montantAvantTaxesEtRabais = ((50 * 2 - 5) * nbParticipant);
                }else if (dureeActivite == 2 && nbParticipant >= 5){
                    montantAvantTaxesEtRabais = ((50 * 2 - 5) * 4) + ((45 * 2 - 5) * (nbParticipant - 4));
                }else if (dureeActivite > 2 && nbParticipant < 5){
                    montantAvantTaxesEtRabais = ((50 * 2 - 5) + (30 * (dureeActivite - 2))) * nbParticipant;
                }else{
                    montantAvantTaxesEtRabais = (((50 * 2 - 5) + (30 * (dureeActivite - 2))) * 4) + (((45 * 2 - 5) + (30 * (dureeActivite - 2))) * (nbParticipant - 4));
                }
                
                nbFacture = nbFacture + 1;
                nbTotalParticipant = nbParticipant + nbTotalParticipant ;
           
                //Defini le rabais a appliquer selon le numero de client
                if (numClient >= 1000 && numClient <= 1999){
                    montantRabais = montantAvantTaxesEtRabais * 15 / 100;
                    nbRabais15 = nbRabais15 + 1;
                }else if (numClient >= 2000 && numClient <= 2999){
                    montantRabais = montantAvantTaxesEtRabais * 10 / 100;
                    nbRabais10 = nbRabais10 + 1;
                }else if (numClient >= 3000 && numClient <= 3999){
                    montantRabais = montantAvantTaxesEtRabais * 5 / 100;
                    nbRabais5 = nbRabais5 + 1;
                }else{
                    montantRabais = 0;
                    nbRabais0 = nbRabais0 + 1;
                }
                
                //Calcul des taxes et des rabais.
                totalRabais = totalRabais + montantRabais;                 
                montantTaxe = ( montantAvantTaxesEtRabais - montantRabais ) * TAXE;
                totalTaxe = montantTaxe + totalTaxe;
                montantAvecTaxeSansRabais = montantAvantTaxesEtRabais + montantTaxe;
                montantFinal = montantAvecTaxeSansRabais - montantRabais;
                revenuTotalAvecTaxeSansRabais = revenuTotalAvecTaxeSansRabais + montantAvecTaxeSansRabais;
                revenuTotalSansTaxesAvecRabais = revenuTotalSansTaxesAvecRabais + montantFinal - montantTaxe;
            
                //Affiche les infos de l'activite qui vient d'etre entree
                if (dureeActivite > 0){
                    System.out.println( " Num Client: " + numClient );
                    System.out.println( "Duree de l'activitee: " + dureeActivite + "j" );
                    System.out.println( "Nombre de participant(s): " + nbParticipant );
                    System.out.println( "Montant de la facture avant taxes et rabais: " + montantAvantTaxesEtRabais );
                    System.out.println( "Tps: " + montantTaxe );
                    System.out.println( "Montant avec taxe sans rabais: " + montantAvecTaxeSansRabais );
                    System.out.println( "Rabais: " + montantRabais );
                    System.out.println( "Montant final: " + montantFinal );
                }
                
                //Demande a l'utilisateur s'il veut continuer d'entrer des factures
                System.out.println( "\n\n" );
                System.out.println( "Ce programme facture les forfaits vacance/plein air avec ou sans rabais selon le cas" ); 
                System.out.println( " et affiche un bilan des differentes executions a la fermeture du programme" );//pr?sentation du programme
                System.out.println( "\n" );
                System.out.print( "NumClient ou un nombre negatif pour terminer: " );
                numClient = Clavier.lireInt();//pour entrer le num?ro de client
                
                while (numClient >= 0 && numClient < 1000 || numClient > 4999){   
                    System.out.println( "ERREUR!" );// indique num?ro invalide
                    System.out.print( "N?Client: " );
                    numClient = Clavier.lireInt();//pour entrer un nouveau num?ro de client
                }
                
                if(numClient < 0 && nbFacture <= 0){
                    System.out.print( " FIN NORMALE DU PROGRAMME" );// ? l'entrer d'un nombre n?gatif le programme s'arr?te
                }

            }//if( nbParticipant > 0)
    
        }//while (numClient >= 1000 && numClient <= 4999)
        
        //Affichage des informatino de sortie du programme avec 1 facture au moins
        if(nbFacture >= 1 && numClient < 0){
            System.out.println( "\n\n" );
            System.out.println( "Nombre total de participant: " + nbTotalParticipant);
            System.out.println( "Nombre total de rabais de 15%: " + nbRabais15);
            System.out.println( "Nombre total de rabais de 10%: " + nbRabais10 );
            System.out.println( "Nombre total de rabais de 0%: " + nbRabais0 );
            System.out.println( "Montant total de rabais: " + totalRabais);
            System.out.println( "Revenu total avec taxe sans rabais: " + revenuTotalAvecTaxeSansRabais);
            System.out.println( "Total Tps: " + totalTaxe);
            System.out.println( "Revenu total sans taxes avec rabais: " + revenuTotalSansTaxesAvecRabais);
            System.out.println( " FIN NORMALE DU PROGRAMME" );// ? l'entrer d'un nombre n?gatif le programme s'arr?te
        }
            
    } // main
    
} // EclipseSim1