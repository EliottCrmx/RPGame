package fil.coo.adventure;
import java.util.*;
import java.util.Scanner;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.*;
import fil.coo.adventure.entities.items.util.*;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.places.salle.Forest;

import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Main {
    protected static Player player;
    private static Room currentRoom; //Salle actuelle du joueur
    
    public static void main(String[] args) {
        
        //Initialisation du joueur
        player = new Player("Immortal_Soul_Viking", 0, 100, 10, 0, new Inventory());
        currentRoom = new Forest();
    
        try {
            File soundFile = new File("music/z3r0-8bit-Syndrome-8bit-Horror-COPYRIGHT-FREE-MUSIC.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Instanciation Roue de la fortune
    
        //Début du jeu
        Scanner sc = new Scanner(System.in);
        currentRoom.start();
        while(!player.isDead()) {
            //chargement de la salle
            System.out.println("\n-------------------- STATISTIQUE DE LA SALLE --------------------");
            if (currentRoom.getMonsters().size() != 0){
                System.out.print("Monstres présents : ");
                for (Monster monster : currentRoom.getMonsters()) {
                    if (monster == currentRoom.getMonsters().get(currentRoom.getMonsters().size() -1)) {
                        System.out.println(monster.getName());
                    }else {
                        System.out.print(monster.getName() + ", ");
                    }
                }
            }else{
                System.out.println("Vous avez vaincu tous les monstres de cette salle");
            }
            if (currentRoom.getItems().size() != 0){
                System.out.print("Items présents : ");
                for (Item item : currentRoom.getItems()) {
                    if (item == currentRoom.getItems().get(currentRoom.getItems().size() -1)) {
                        System.out.println(item.getName());
                    } else {
                        System.out.print(item.getName() + ", ");
                    }
                }
            }else{
                System.out.println("Il n'y a plus d'items dans cette salle");
                }
            System.out.println("--------------------------------------------------------------");

            //Affichage des Stats du joueur>
            System.out.println("\n-------------------- STATISTIQUE DU JOUEUR --------------------");
            if (player.getInventory().getItems().size() != 0){
                System.out.print("Inventaire : ");
                for (Item item : player.getInventory().getItems()) {
                    if (item == player.getInventory().getItems().get(player.getInventory().getItems().size() -1)) {
                        System.out.println(item.getName());
                    } else {
                        System.out.print(item.getName() + ", ");
                    }
                }
            } else {
                System.out.println("Vous n'avez rien dans votre inventaire");
            }
            System.out.println("Vos points de vie : " + "\u001B[32m" + player.getLifePoints()+ "\u001B[39m");
            System.out.println("Vos points d'armure : " + "\u001B[36m" + player.getArmor()+ "\u001B[39m");
            System.out.println("Vos points d'attaque : " + "\u001B[31m" + player.getStrength()+ "\u001B[39m");
            System.out.println("Votre trésor est de : " + "\u001B[33m" + player.getGold() + "\u001B[39m" + " pièces d'or");
            //Demande au Player ce les actions qu'il peut faire => choix de 1 à 5(nombre d'actions)

            System.out.println("--------------------------------------------------------------\n");
            System.out.println("--------------------- Que souhaitez-vous faire ? ---------------------\n");
            System.out.println("1 : Passer à la salle suivante");
            System.out.println("2 : Ramasser un item");
            System.out.println("3 : Utiliser un item de l'inventaire");
            System.out.println("4 : Attaquer un monstre");
            System.out.println("5 : Magasin");
            System.out.println("6 : Quittez le jeu");
            String action = sc.nextLine();
            


            switch(action) {
                case "1":
                    move(); //Déplacement du joueur                     
                    //demande au joueur nt roomquelle salle il veut aller
                    //update de la curre
                    break;
                case "2":

                    if (currentRoom.getItems().size() == 0) { //vérifie si il reste des items dans la salle
                        System.out.println("Il n'y a plus d'items dans cette salle !!");
                        break;
                    }

                    //Demande au joueur quel item il veut prendre
                    //ajoute l'item à l'inventaire du joueur
                    addItemToInventory();
                    break;
                case "3":
                    //demande au joueur quel item il veut utiliser
                    if(player.getInventory().getItems().isEmpty()) //si l'inventaire est vide =>le joueur ne peut pas accéder à l'option 3
                        {
                        System.out.println("Vous n'avez pas d'item dans votre inventaire");
                        break;
                    }else if (player.getInventory().getItems().size() == 1) //si l'inventaire contient un seul item =>le joueur n'a pas le choix
                        {    
                        useItem();
                        break;
                    }else{
                        useItem();//applique l'effet de l'item
                        break;
                    } 
                    
                case "4":
                    //demande au joueur quel monstre il veut attaquer
                    //Début du combat
                    System.out.println("Quelle monstre voulez-vous attaquer ?");
                    if (currentRoom.getMonsters().size() != 0) { //vérifie si il reste des monstres dans la salle
                          
                        //récupère la liste des monstres de la salle courante
                        for (int i = 0; i < currentRoom.getMonsters().size(); i++) {
                            System.out.println((i+1) + ": " + currentRoom.getMonsters().get(i).getName()); //affiche la liste des monstres
                    }
                    Scanner sc1 = new Scanner(System.in);
                    int selection = sc1.nextInt();
                    Monster selectedMonster = currentRoom.getMonsters().get(selection - 1);
                    attackMonster(selectedMonster); //attaque le monstre sélectionné
                    break;
                    }else{
                        System.out.println("Il n'y a plus de monstres dans cette salle passez à la salle suivante !!");
                        break;}
                    
                case "5":
                    //Ouvrir la boutique au joueur

                    Item lp = new LifePotion();
                    Item sp = new StrengthPotion();

                    System.out.println("Que voulez-vous acheter ?");
                    System.out.println("1: Potion de Vie : 20 (25 gold)");
                    System.out.println("2: Potion de Force : 10 (25 gold)");
                    System.out.println("3: Rien");
                    Scanner scanner = new Scanner(System.in);
                    boolean run = true;
                    while (run) {
                        int val = sc.nextInt();
                        switch (val) {
                            case 1:
                                //buy LifePotion
                                buyItem(lp, 10);
                                break;
                            case 2:
                                //buy StrenghtPotion
                                buyItem(sp, 20);
                                break;
                            case 3:
                                run = false;
                                break;
                        }
                    }
                    default:
                        System.out.println("Vous quittez le magasin!"); 
                case "6":
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("êtes-vous bien sûr de vouloir quitter la partie ? (pas de sauvegarde possible pour le moment)");
                    System.out.println("1: Oui");
                    System.out.println("2: Non");
                    if (sc2.nextInt() == 1){
                        System.exit(0);
                        break;
                    } else {
                        break;
                    }
                }
        }
        //Fin du jeu
        System.out.println("Game over!");
        }
    

    //Ajoute un item de la salle à l'inventaire du joueur
    public static void addItemToInventory(){
        System.out.println("Quelle Item voulez-vous utiliser ?");
        List<Item> availableItems = currentRoom.getItems(); //liste les items de la salle courrante
        for (int i = 0; i < availableItems.size(); i++) {
            System.out.println((i+1) + ": " + availableItems.get(i).getName());//on affiche les items de la salle courrante
        }
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        Item selectedItem = availableItems.get(selection - 1);
        player.getInventory().addItem(selectedItem);//on ajoute l'item à l'inventaire du joueur
        currentRoom.removeItem(selectedItem);//on retire l'item de la salle courrante
        System.out.println("Vous avez récupérer " + selectedItem.getName());
    }

    //Utilisation d'un item de l'inventaire
    public static void useItem(){
        System.out.println("Quelle Item voulez-vous utiliser ?");
        List<Item> inventoryItems = player.getInventory().getItems();
        for (int i = 0; i < inventoryItems.size(); i++) {
            System.out.println((i+1) + ": " + inventoryItems.get(i).getName());
        }
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        Item selectedItem = inventoryItems.get(selection - 1);
        selectedItem.isUsedBy(player);
        player.getInventory().removeItem(selectedItem);
        System.out.println("Vous avez utilisé " + selectedItem.getName());
    }

    public static void move() {
        if(currentRoom.allMonstersKilled() && currentRoom.getLinkedRooms() != null) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Dans quelle salle souhaitez-vous vous rendre ?");
            for (int i = 0; i < currentRoom.getLinkedRooms().size(); i++) {
                System.out.println((i+1) + ": " + currentRoom.getLinkedRooms().get(i).getName()); //affiche la liste des salles
            }
            int selectedRoom = sc.nextInt();
            System.out.println("Souhaitez-vous jouer à la Roue de la Fortune ?" + " (1 : Oui, 2 : Non)"); //Demande au joueur s'il veut jouer à la roue de la fortune;
            player.setArmor(player.getArmor() + 3); //Ajout de 3 points d'armure à chaque nouvelle salle
            OneArmedBandit oneArmedBandit = new OneArmedBandit();
            int test = sc.nextInt();
            switch(test) {
                case 1: //Si le joueur veut jouer à la roue de la fortune
                    oneArmedBandit.isUsedBy(player);
                    break;
                case 2: //Si le joueur ne veut pas jouer à la roue de la fortune
                    break;
                default: //Si le joueur entre une lettre invalide
                    System.out.println("Veuillez entrer un chiffre valide");
                    break;
            }

            currentRoom = currentRoom.getLinkedRooms().get(selectedRoom-1);
            System.out.println("Vous entrez dans la salle : " + currentRoom.getName() + "...");
            currentRoom.start();

        }else {
            System.out.println("Il n'y a pas d'autres salles à explorer ou tous les monstres de la salle n'ont pas été vaincus");
        }
    }




    //Boutique
    public static void buyItem(Item item, int price){
        if (player.getGold() >= price) {
            //player.addItemToInventory(lp);
            player.removeGold(price);
            player.getInventory().addItem(item);
            System.out.println("Vous avez acheté : "+ item.getName() + " pour 10 pièces d'or (nouveau solde : "+ player.getGold()+")");
        } else {
            System.out.println("Vous n'avez pas assez de gold (solde actuel : "+player.getGold()+" pièce(s) d'or");
        }
    }





    //Interaction entre le joueur et le monstre => Le monstre donne du Gold lorsqu'il meurt
    public static void attackMonster(Monster monster) {
        while(!player.isDead() && !monster.isDead()) {
            //Le joueur attaque le monstre
            System.out.println(player.getName()+"(" + "\u001B[32m" +player.getLifePoints() + "\u001B[39m" + " hp,"+ "\u001B[36m" +player.getArmor()+ "\u001B[39m" + " d'armure)"+ " attaque " +
            monster.getName()+"("+ "\u001B[32m" +monster.getLifePoints()+ "\u001B[39m" +" hp,"+ "\u001B[36m" +monster.getArmor()+ "\u001B[39m" +" d'armure)");
            //System.out.println(player.getName() + " a " + player.getLifePoints() + " pdv et " + player.getArmor() + " d'armure");
            //System.out.println(monster.getName() + " a " + monster.getLifePoints() + " points de vie et " + monster.getArmor() + " d'armure");
            if (monster.getArmor() >= player.getStrength()) {
                //Si l'armure du monstre est supérieur à la force du joueur, l'armure du monstre diminue de la force du joueur
                monster.setArmor(monster.getArmor() - player.getStrength());
            }else if (monster.getArmor() < player.getStrength()) {
                //Si l'armure du monstre est inférieur à la force du joueur, l'armure du monstre passe à 0 et le monstre perd des points de vie
                monster.setLifePoint (monster.getLifePoints() - (player.getStrength() - monster.getArmor()));
                monster.setArmor(0);;
            } else {
                //Si l'armure du monstre est égale à la force du joueur, le monstre perd des points de vie
                monster.setLifePoint(monster.getLifePoints() - player.getStrength());
            }
            System.out.println("------------------ PHASE DE COMBAT ------------------");

            System.out.println(player.getName() + " a " + "\u001B[32m" + player.getLifePoints() + "\u001B[39m" + " points de vie et " + "\u001B[36m" + player.getArmor() + "\u001B[39m" + " d'armure");
            System.out.println(player.getName()+" a infligé " + "\u001B[91m" + player.getStrength() +"\u001B[39m" + " points de dégâts à " + monster.getName());
            System.out.println(monster.getName() + " a " + "\u001B[32m" + monster.getLifePoints() + "\u001B[39m" + " points de vie et " + "\u001B[36m" + monster.getArmor() + "\u001B[39m" + " d'armure");
            
            if(monster.isDead()){
                //si le monstre est mort
                player.addGold(monster.getGold()); //Le joueur gagne de l'or contenu dans le monstre
                player.addStrenghtPoint(1);
                System.out.println("Vous avez battu " + monster.getName());
                System.out.println("Vous avez gagné " + monster.getGold() + " pièces d'or");
                currentRoom.removeMonsters(monster); //Enleve le monstre mort de la salle courante
                break;
            }
            //Attaque du monstre avec prise en compte de l'armure du joueur, l'armure ne peut pas être négative
            if (player.getArmor() >= monster.getStrength()) {
                player.setArmor(player.getArmor() - monster.getStrength());
            
            }else if (player.getArmor() < monster.getStrength()) {
                player.setLifePoint(player.getLifePoints() - (monster.getStrength() - player.getArmor()));
                player.setArmor(0);
            }else {
                player.setLifePoint(player.getLifePoints() - monster.getStrength());
            }
            if(player.isDead()){ 
                //si le joueur est mort
                System.out.println("Vous vous êtes fait battre par " + monster.getName() + " Game Over");
                //game over
                break;
            }
        }


    
    }


}
    


