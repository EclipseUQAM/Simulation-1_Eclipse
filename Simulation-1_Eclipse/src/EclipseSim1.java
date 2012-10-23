/*
 * Cours INF6150
 *
 *
 * Projet
 * ------
 * Le projet 'Facturation forfait plein air' vise une clientele qui souhaite
 * reserver des forfaits vacances en plein air pour differentes activites.
 * Il consiste a ameliorer le processus de facturation et la flexibilite du logiciel en
 * integrant de nouvelles regles ayant trait aux taxes et aux rabais.
 *
 * 
 * Equipe
 * ------
 * Christian Niore NIOC22038808
 * Claude Boisvert BOIC16096504
 * Karl Brodeur    BROK09028701
 * Samira Feddag   FEDS04518206
 * Abdelilah Naimi NAIA16015901
 *
 * 
 * Description
 * -----------
 * Programme permettant de faire des factures avec des taxes et des rabais.
 *
 *
 * Version 1 (demandes essentielles)
 * ---------
 * - Appliquer une taxe harmonisee de 15% en remplacement de la tps et tvq. 
 * - Appliquer le rabais sur le montant facture avant les taxes.
 * - Ajouter une nouvelle categorie de client numerotes de 4000 a 4999.
 * - Les clients numerotes de 4000 a 4999 ont 0% de rabais.
 * - Les clients numerotes de 3000 a 3999 ont 5% de rabais.
 * 
 *
 * Version 2 (demandes importantes)
 * ---------
 * - Cumuler le montant total des rabais de 15%, 10% et 5% et les afficher 
 *   dans le bilan de fermeture.
 * - Cumuler le montant total des rabais bases sur la duree des sejours 
 *   de 1 jour, de 2 jours ou de 3 jours et +. Afficher ses montants 
 *   dans le bilan de fermeture.
 * 
 *
 * Version 3 (demandes Souhaitables)
 * ---------
 * - Permettre d'annuler une facture au moment d'entrer le nombre de 
 *   participants.
 * - Ameliorer la clarte de l'affichage.
 * - Ameliorer la qualite des commentaires.
 * - Ameliorer la nomenclature des variables.
 * - Respecter les niveaux d'indentation.
 * - Supprimer les variables inutilisees.
 * - Enlever les caracteres nuisant a l'affichage.
 * 
 * 
 * Bogues corriges dans la version originale
 * -----------------------------------------
 * - Initialisation incorrecte du nombre de facture. Debuter a 0 au lieu de 1. 
 * - Calcul erronne pour le premier jour d'activite. S'il y avait entre 2 et 4
 *   participants, on calculait toujours pour 1 seul participant.
 * - Calcul erronne du montant total des rabais. Seul le rabais de la derniere
 *   facture etait cumule.
 * 
 */

public class EclipseSim1 {

    // Autres methodes s'il y a lieu
    
    public static void main (String[] params) {

        // Declarations des variables locales 
        
        // Constantes
        final double TAXE = 15.0 / 100;                // Taxe harmonisee de 15%
        
    	// Nombres reels
        double montantAvantTaxesEtRabais = 0;          // Montant sans taxe ni rabais
        double montantAvecTaxeSansRabais = 0;          // Montant avec taxe sans rabais
        double montantRabais = 0;                      // Montant rabais (1 facture)
        double montantTaxe = 0;                        // Montant taxe (1 facture)
        double montantTotal = 0;                       // Montant total (1 facture)
        double revenuTotalAvecTaxeSansRabais = 0;      // Revenu total avec taxe sans rabais
        double revenuTotalSansTaxesAvecRabais = 0;     // Revenu total sans taxe avec rabais
        double totalRabais = 0;                        // Montant total des rabais
        double totalRabais5 = 0;                       // Montant total des rabais de 5%
        double totalRabais10 = 0;                      // Montant total des rabais de 10%
        double totalRabais15 = 0;                      // Montant total des rabais de 15%
        double totalRabaisJour1 = 0;                   // Montant total des rabais (duree 1 jour)
        double totalRabaisJour2 = 0;                   // Montant total des rabais (duree 2 jours)
        double totalRabaisJour3 = 0;                   // Montant total des rabais (duree 3 jours et +)
        double totalTaxe = 0;                          // Montant total des taxes
        
        // Nombres entiers
        int dureeActivite = 0;                         // Duree des activites (nb jours)
        int nbFacture = 0;                             // Nb de facture
        int nbParticipant = 0;                         // Nb de participant
        int nbRabais0 = 0;                             // Nb de rabais de 0%  
        int nbRabais5 = 0;                             // Nb de rabais de 5%
        int nbRabais10 = 0;                            // Nb de rabais de 10%
        int nbRabais15 = 0;                            // Nb de rabais de15%        
        int nbTotalParticipant = 0;                    // Nb total de participants
        int numClient = 0;                             // Numero de client
        
        // Affichage initial
        System.out.println( "\n==========================================================================================" );
        System.out.println( "Ce programme facture les forfaits vacance/plein air avec ou sans rabais selon le cas et" ); 
        System.out.println( "affiche à la fin du programme un bilan de fermeture pour toutes les factures entrees.\n" );
        System.out.println( "------------------------------------------------------------------------------------------" );
        System.out.println( "\n" );
        System.out.print( "Entrer un numero de client [-1 = Terminer       ] .: " );
        
        // Saisie [client]
        numClient = Clavier.lireInt();
        
        // Fin du programme
        if (numClient < 0 ) {
            System.out.print( "\nFIN NORMALE DU PROGRAMME" );
        }
        
        // Saisie incorrecte [client]
        while (numClient >= 0 && numClient < 1000 || numClient > 4999) {
            System.out.println( "ERREUR! Numero de client incorrect." );
            System.out.print( "Entrer un numero de client [-1 = Terminer       ] .: " );
            
            // Saisie [client]
            numClient = Clavier.lireInt();
        }
        
        // Saisie correcte [client]
        while (numClient >= 1000 && numClient <= 4999) {
            System.out.print( "Nombre de participant(s)   [ 0 = Facture annulee] .: " );
            
            // Saisie [participant]
            nbParticipant = Clavier.lireInt();
        
            // Saisie incorrecte [participant]
            while (nbParticipant < 0) { 
                System.out.println( "ERREUR! Nombre de participant(s) incorrect.");
                System.out.print( "Nombre de participant(s)   [ 0 = Facture annulee] .: " );
                
                // Saisie [participant]
                nbParticipant = Clavier.lireInt();
            }
            
            // Saisie correcte [participant]
            if (nbParticipant >= 0) { 
                   
            	// Continuer processus de facturation 
                if( nbParticipant > 0) { 
                    System.out.print( "Duree des activites        [ 0 = Facture annulee] .: ");

                    // Saisie [duree activites]
                    dureeActivite = Clavier.lireInt();
                
                    // Saisie incorrecte [duree activites]
                    while (dureeActivite < 0) {
                        System.out.println( "ERREUR! Duree des activites incorrecte." );
                        System.out.print("Duree des activites        [ 0 = Facture annulee] .: ");   
                        
                       // Saisie [duree activites]
                        dureeActivite = Clavier.lireInt();  
                    }
                }

                // Calcul du montant facture avant taxes et rabais 
                //
                // Jour 1 = $50 pour les 4 premieres personnes et $45 pour les autres
                // Jour 2 = Même tarif que le jour 1 sauf qu'on soustrait $5 par personne
                // Jour 3 et + = $30 par personne
                if (dureeActivite == 0 || nbParticipant == 0) {
                    dureeActivite = 0;
                    nbParticipant = 0;
                    System.out.println( "\nNumero de client ..............: " + numClient );
                    System.out.println( "\nFACTURE ANNULEE" );
                } 
                
                else if (dureeActivite == 1 && nbParticipant < 5) {
                    montantAvantTaxesEtRabais = 50 * nbParticipant;
                }
                
                else if (dureeActivite == 1 && nbParticipant >= 5) {
                    montantAvantTaxesEtRabais = (50 * 4) + ( 45 * ( nbParticipant - 4));
                }
                
                else if (dureeActivite == 2 && nbParticipant < 5) {
                    montantAvantTaxesEtRabais = ((50 * 2 - 5) * nbParticipant);
                }
                
                else if (dureeActivite == 2 && nbParticipant >= 5) {
                    montantAvantTaxesEtRabais = ((50 * 2 - 5) * 4) + ((45 * 2 - 5) * (nbParticipant - 4));
                }
                
                else if (dureeActivite > 2 && nbParticipant < 5) {
                    montantAvantTaxesEtRabais = ((50 * 2 - 5) + (30 * (dureeActivite - 2))) * nbParticipant;
                }
                
                else {
                    montantAvantTaxesEtRabais = (((50 * 2 - 5) + (30 * (dureeActivite - 2))) * 4) + (((45 * 2 - 5) + (30 * (dureeActivite - 2))) * (nbParticipant - 4));
                }
            
                // Calcul et cumulatif si on effectue le processus de facturation
                if (dureeActivite != 0) {
                
                    nbFacture = nbFacture + 1;
                    nbTotalParticipant = nbTotalParticipant + nbParticipant;
           
                    // Calcul des rabais selon la categorie de client
                    if (numClient >= 1000 && numClient <= 1999) {
                        montantRabais = montantAvantTaxesEtRabais * 15 / 100;
                        nbRabais15 = nbRabais15 + 1;
                        totalRabais15 = totalRabais15 + montantRabais;
                    }
                    
                    else if (numClient >= 2000 && numClient <= 2999) {
                        montantRabais = montantAvantTaxesEtRabais * 10 / 100;
                        nbRabais10 = nbRabais10 + 1;
                        totalRabais10 = totalRabais10 + montantRabais;
                    }
                    
                    else if (numClient >= 3000 && numClient <= 3999) {
                        montantRabais = montantAvantTaxesEtRabais * 5 / 100;
                        nbRabais5 = nbRabais5 + 1;
                        totalRabais5 = totalRabais5 + montantRabais;
                    }
                    
                    else {
                        montantRabais = 0;
                        nbRabais0 = nbRabais0 + 1;
                    }
                
                    // Calcul des rabais selon la duree des activites
                    if (dureeActivite == 1) {
                        totalRabaisJour1 = totalRabaisJour1 + montantRabais;
                    }
                    
                    else if(dureeActivite == 2){
                        totalRabaisJour2 = totalRabaisJour2 + montantRabais;
                    }
                    
                    else if(dureeActivite >= 3){
                        totalRabaisJour3 = totalRabaisJour3 + montantRabais;
                    }
                
                    // Calcul et cumulatif de montant
                    totalRabais = totalRabais + montantRabais;
                    montantTaxe = montantAvantTaxesEtRabais * TAXE;
                    totalTaxe = montantTaxe + totalTaxe ;
                    montantAvecTaxeSansRabais = montantAvantTaxesEtRabais + montantTaxe;
                    montantTotal = montantAvecTaxeSansRabais - montantRabais;
                    revenuTotalAvecTaxeSansRabais = revenuTotalAvecTaxeSansRabais + montantAvecTaxeSansRabais;
                    revenuTotalSansTaxesAvecRabais = revenuTotalSansTaxesAvecRabais + montantTotal - montantTaxe;          
                
                } // if (dureeActivite != 0)
               
                // Affichage d'une facture
                if (dureeActivite > 0) {
                    System.out.println( "\n      F A C T U R E \n");
                    System.out.println( "Numero de client ..............: " + numClient );
                    System.out.println( "Duree de l'activite ...........: " + dureeActivite + " jour(s)" );
                    System.out.println( "Nombre de participant(s) ......: " + nbParticipant );
                    System.out.println( "\nMontant sans taxe ni rabais ...: $" + montantAvantTaxesEtRabais );
                    System.out.println( "Taxe (15%) ....................: $" + ((double)Math.round(montantTaxe * 100) / 100));
                    System.out.println( "Montant avec taxe sans rabais .: $" + ((double)Math.round(montantAvecTaxeSansRabais * 100) / 100));
                    System.out.println( "Rabais ........................: $" + ((double)Math.round(montantRabais * 100) / 100));
                    System.out.println( "\nMontant total .................: $" + ((double)Math.round(montantTotal * 100) / 100));
                }
                
                // Affichage initial
                System.out.println( "------------------------------------------------------------------------------------------" );
                System.out.println( "\n" );
                System.out.print( "Entrer un numero de client [-1 = Terminer       ] .: " );
                
                // Saisie [client]
                numClient = Clavier.lireInt();
                
                // Saisie incorrecte [client]
                while (numClient >= 0 && numClient < 1000 || numClient > 4999) {
                    System.out.println( "ERREUR! Numero de client est incorrect." );
                    System.out.print( "Entrer un numero de client [-1 = Terminer       ] .: " );
                    
                    // Saisie [client]
                    numClient = Clavier.lireInt();
                }
                
                // Fin du programme
                if (numClient < 0 && nbFacture <= 0) {
                    System.out.println( "\n==========================================================================================" );
                    System.out.println( "FIN NORMALE DU PROGRAMME\n" );
                }

            } // if (nbParticipant > 0)
    
        } // while (numClient >= 1000 && numClient <= 4999)
        
        // Affichage du bilan de fermeture
        if (nbFacture >= 1 && numClient < 0) {
            System.out.println( "\n\n" );
            System.out.println( "B I L A N   D E   F E R M E T U R E\n" );
            System.out.println( "Nombre de participant(s) .....................: " + nbTotalParticipant);
            System.out.println( "Nombre de rabais de 15% ......................: " + nbRabais15);
            System.out.println( "Nombre de rabais de 10% ......................: " + nbRabais10);
            System.out.println( "Nombre de rabais de 5% .......................: " + nbRabais5);
            System.out.println( "Nombre de rabais de 0% .......................: " + nbRabais0);
            
            System.out.println( "\nMontant de rabais de 15% .....................: $" + ((double)Math.round(totalRabais15 * 100) / 100));
            System.out.println( "Montant de rabais de 10% .....................: $" + ((double)Math.round(totalRabais10 * 100) / 100));
            System.out.println( "Montant de rabais de 5% ......................: $" + ((double)Math.round(totalRabais5 * 100) / 100));
            System.out.println( "Montant de rabais activites de 1 jour ........: $" + ((double)Math.round(totalRabaisJour1 * 100) / 100) );
            System.out.println( "Montant de rabais activites de 2 jours .......: $" + ((double)Math.round(totalRabaisJour2 * 100) / 100) );
            System.out.println( "Montant de rabais activites de 3 jours et + ..: $" + ((double)Math.round(totalRabaisJour3 * 100) / 100) );
            
            System.out.println( "Montant total de rabais ......................: $" + ((double)Math.round(totalRabais * 100) / 100));
            System.out.println( "\nRevenu total avec taxe sans rabais ...........: $" + ((double)Math.round(revenuTotalAvecTaxeSansRabais * 100) / 100));
            System.out.println( "Montant total de taxe ........................: $" + ((double)Math.round(totalTaxe * 100) / 100));
            System.out.println( "Revenu total sans taxe avec rabais ...........: $" + ((double)Math.round(revenuTotalSansTaxesAvecRabais * 100) / 100));
            System.out.println( "\n==========================================================================================" );
            System.out.println( "FIN NORMALE DU PROGRAMME" );
   
        }
    
    } // main
    
} // EclipseSim1