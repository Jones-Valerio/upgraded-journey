import java.util.Scanner;
import java.lang.*;

public class AdventureGame {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        // ENEMY SET UP
        String enemy = "Demon";
        int enemyHealth = 30;

        String enemy2 = "Another Demon";
        int enemy2Health = 40;

        String enemy3 = "Third Demon";
        int enemy3Health = 50;

        String lastEnemy = "Final Boss";
        int lastEnemyHealth = 80;

        // SET UP PLAYER NAME
        String player;
        System.out.println("Lets begin our Forest Adventure....");
        System.out.println("Enter your name:");
        player = in.nextLine();
        player = player.trim();
        int playerHealth = 100;

        System.out.printf("Welcome %s, Let's start the adventure!%n", player);

        //DISPLAY FIRST ENEMY
        displayDemon();

        playerHealth = Fight(player, playerHealth, enemy, enemyHealth);

        System.out.println("Player Health: " + playerHealth);

        if(playerHealth <= 0){
            System.exit(0);
        }

        // ASK USER FOR AN OPTION ON A PATH
        System.out.println("Do you want to continue to the forest or take the path to the river?");
        String path = in.next();
        path = path.trim();
        path = path.toLowerCase();

        //TAKE THE PATH OF RIVER
        if(path.equalsIgnoreCase("river")){
            System.out.println("Looks like you chose the path to the river. Let's see what is out there......\n");
            //display potion section
            int randomPotion = (int)(Math.random() * 3 - 1 + 1) + 1;
            playerHealth = potionSection(playerHealth, randomPotion);
            System.out.printf("Now your health is %d %s%n", playerHealth, player);
            System.out.println("Great..now it is time to continue into the forest....");
        }else{
            //ANYTHING ELSE DISPLAY THE NEXT ENEMY
            System.out.println("Let's continue into the forest.......\n");
            //fight enemy 2
            displayDemon();
            playerHealth = Fight(player, playerHealth, enemy2, enemy2Health);
            System.out.println("Player Health: " + playerHealth);

            if(playerHealth <= 0){
                System.exit(0);
            }

            //ASK FOR A DIFFERENT PATH
            System.out.println("Do you want to climb the mountain or keep going into forest?");
            String secondPath = in.next();
            secondPath = secondPath.trim();
            secondPath = secondPath.toLowerCase();

            //IF USER SELECTS THE MOUNTAIN PATH
            if(secondPath.equalsIgnoreCase("mountain")){
                System.out.println("You chose to climb that mountain...excellent..let's see what is up there...");

                //display potion section
                int randomPotion = (int)(Math.random() * 3 - 1 + 1) + 1;
                playerHealth = potionSection(playerHealth, randomPotion);
                System.out.printf("Now your health is %d %s%n", playerHealth, player);
                System.out.println("Now it's time to get back into the forest.....");
            }

        }
         //DISPLAY THIRD ENEMY
        displayDemon();

        playerHealth = Fight(player, playerHealth, enemy3, enemy3Health);

        if(playerHealth <= 0){
            System.exit(0);
        }

        //ASK FOR ANOTHER PATH
        System.out.println("Do you want to continue the forest path or go the the lake?");
        String lastPath = in.next();
        lastPath = lastPath.trim();
        lastPath = lastPath.toLowerCase();

        //IF USER SELECTS THE LAKE PATH
        if(lastPath.equalsIgnoreCase("lake")){
            System.out.println("The lake it is.....wonder what we can find out there.....");
            //display potion section
            int randomPotion = (int)(Math.random() * 3 - 1 + 1) + 1;
            playerHealth = potionSection(playerHealth, randomPotion);
            System.out.printf("Now your health is %d %s%n", playerHealth, player);
            System.out.println("We had our fun....it's time to get back into that Forest.....");
        }

        //DISPLAY THE LAST DEMON
        lastDemon();

        playerHealth = Fight(player, playerHealth, lastEnemy, lastEnemyHealth);

        //DISPLAY WINNER BANNER IF USER DEFEATS LAST DEMON
        if(playerHealth > 0){
            System.out.println("" + " __ __ __    ________  ___   __    ___   __    ______   ______       \n" +
                    "/_//_//_/\\  /_______/\\/__/\\ /__/\\ /__/\\ /__/\\ /_____/\\ /_____/\\      \n" +
                    "\\:\\\\:\\\\:\\ \\ \\__.::._\\/\\::\\_\\\\  \\ \\\\::\\_\\\\  \\ \\\\::::_\\/_\\:::_ \\ \\     \n" +
                    " \\:\\\\:\\\\:\\ \\   \\::\\ \\  \\:. `-\\  \\ \\\\:. `-\\  \\ \\\\:\\/___/\\\\:(_) ) )_   \n" +
                    "  \\:\\\\:\\\\:\\ \\  _\\::\\ \\__\\:. _    \\ \\\\:. _    \\ \\\\::___\\/_\\: __ `\\ \\  \n" +
                    "   \\:\\\\:\\\\:\\ \\/__\\::\\__/\\\\. \\`-\\  \\ \\\\. \\`-\\  \\ \\\\:\\____/\\\\ \\ `\\ \\ \\ \n" +
                    "    \\_______\\/\\________\\/ \\__\\/ \\__\\/ \\__\\/ \\__\\/ \\_____\\/ \\_\\/ \\_\\/ \n" +
                    "                                                                     " + "");
            System.out.printf("Congratulations %s, looks like you defeated all demons....", player);

        }
    }

    //FUNCTION TO SIMULATE FIGTH BETWEEN USER AND DEMON
    public static int Fight(String player, int playerHealth, String enemy, int enemyHealth){
        Scanner in = new Scanner(System.in);
        System.out.printf("%s has an initial Health of %d%n", enemy, enemyHealth);

        do{
            if(playerHealth <= 0){
                break;
            }else {
                //ASK USER FOR ATTACK
                System.out.println("Choose how to attack your opponent: (punch, kick, superkick)");
                String selection = in.next();
                selection = selection.trim();
                selection = selection.toLowerCase();
                System.out.println(selection);
                int attackSelection = 0;

                if(selection.equalsIgnoreCase("punch")){
                    attackSelection = 1;
                }else if(selection.equalsIgnoreCase("kick")){
                    attackSelection = 2;
                }else if(selection.equalsIgnoreCase("superkick")){
                    attackSelection = 3;
                }else {
                    System.out.println("Not a choice for attack....");
                    Fight(player, playerHealth, enemy, enemyHealth);
                }


                int yourAttack = playerAttack(attackSelection);
                System.out.println(yourAttack);

                enemyHealth -= yourAttack;

                System.out.printf("You throw %d damage into your enemy.....%n", yourAttack);
                System.out.printf("%s has now %d of Health.....%n%n", enemy, enemyHealth);
            }

            if(enemyHealth <= 0){
                break;
            }else{

                int randomEnemyAttack = (int)(Math.random() * 3 - 1 + 1) + 1;
                int yourEnemyAttack = enemyAttack(randomEnemyAttack);

                playerHealth -= yourEnemyAttack;

                System.err.println("\nYour enemy is going to attack you now.....Prepare\n");
                System.err.printf("Your enemy throw %d damage to you.....%n", yourEnemyAttack);
                System.err.printf("%s has now %d of Health.....%n%n", player, playerHealth);
            }

        }while(playerHealth > 0 && enemyHealth > 0);

        if(playerHealth > 0){
            System.out.printf("%s has won the battle...%n", player);

        }else if(enemyHealth > 0){
            gameOver(enemy);
        }

        return playerHealth;
    }

    //PLAYER ATTACK FUNCTION
    public static int playerAttack(int attack){
        int max = 0;
        int min = 0;

        if(attack == 1){
            max = 4;
            min = 1;
        }else if(attack == 2){
            max = 7;
            min = 5;
        }else if(attack == 3){
            max = 10;
            min = 8;
        }

        int range = max - min + 1;
        int generatedAttack = (int) (Math.random() * range) + min;

        return  generatedAttack;
    }

    //ENEMY ATTACK FUNCTION
    public static int enemyAttack(int attack){
        int max = 0;
        int min = 0;

        if(attack == 1){
            max = 3;
            min = 1;
            System.err.println("             __________                  __,___/  \",\",");
            System.err.println("      ___.--\"          \"\\'.         ____/  l   \\    \",'-,");
            System.err.println("-----f\"               // \\\\\\        \\  (l\\ \\    \\     \\ \\\",");
            System.err.println("     |                    |||       /   u       |      \\ \\ \\");
            System.err.println("     |                    |||     _ )          /       | |  \\");
            System.err.println(" ----L_-XXX-.             .|'    / U          <        | |  |");
            System.err.println("             \"\\   -<_____///     \\           6 )       | |  |");
            System.err.println("               \\___)     -\"       '.       -.<\"       / /   |");
            System.err.println("                                   |'.___  |       _._.\"   /");
            System.err.println("                                   |     ./     _.\".\"   _.\"");
            System.err.println("                                  /      |\"----\"     _.\"");
            System.out.println("");
        }else if(attack == 2){
            max = 6;
            min = 4;
            System.err.println("" +
                    "" +
                    "\n" +
                    "                                                             _,,,,\n" +
                    "                                                            \\\\    \\  ,ouch!\n" +
                    "                                                        ____/c = o=\n" +
                    "                       \\|//                      *    _/   | /\\__C/\n" +
                    "                     -/_ /            ,-.   *       _/ \\    \\__  ___\n" +
                    "                       _\\\\_           |  \\    *  __/    \\  -/ O\\/'_ \\\n" +
                    "                       \\_  \\          x  |   *  /  \\____,\\______\\/  '\n" +
                    "              /\\_,///   >   )         \\_  \\     #     _/_\\/\n" +
                    "             / ,/   +\\ /   /         _/ )_/     \\     \\  \\\n" +
                    "             \\__|+ O  )  \\/        _/ \\/         \\_    \\  \\\n" +
                    "                /\\__D/    \\      _/    )         _>   ,)   )\n" +
                    "                 /  _   o  \\   _/,   _/        _/     /     \\\n" +
                    "                /   /       ,_/   __/         /_ .  _/ \\_   _\\\n" +
                    "               /   / \\    o//    _/           /_\\__/     \\_/ \\\n" +
                    "              /__o/   \\___|    _/            / x(          \\/ '-,__\n" +
                    "              _//       \\__ __/\\             \\  x\\          |______\\\n" +
                    "              \\  \\>       \\     \\             \\  |\n" +
                    "              // |         \\__   \\             '-'\n" +
                    "                            /    /\n" +
                    "                            \\___(\n" +
                    "                            /_/\n" +
                    "                           / O \\\n" +
                    "                           '-   \\__\n" +
                    "                             \\_____)");
            System.out.println("");
        }else if(attack == 3){
            max = 10;
            min = 7;
            System.err.println(""
                    + "                      _\n" +
                    "                      _  ,d$$$b\n" +
                    "                    d$$$b$$[  o\n" +
                    "                    $$< q \\  .'\n" +
                    "                    )  _, | /\n" +
                    "                  ,`-_/  ` \\'|\\\n" +
                    "                /'   / pb / `; `\\\n" +
                    "               |    (    `--,---,-',\n" +
                    "              /      `._   /_;,_|--'\n" +
                    "             )=,,_ .-'   \"-'(^^|/'\n" +
                    "            /    ``=ssssss(  `'\n" +
                    "            `---,_ /     `$,\n" +
                    "            <     |_______`$b\n" +
                    "            /     /|      |$`$\n" +
                    "            |     ||       ``-,\n" +
                    "            |    / /    |      `\\\n" +
                    "            |_ _--'     /`--_    )\n" +
                    "        ,\"\"---|       _/    /    |\n" +
                    "        |  ,--|   __/|_    `-----'\n" +
                    "        ( |  | ,`' (___,,   | |_\n" +
                    "         \\, (____,,         \\____,,\n" + "");
            System.out.println("");
        }

        int range = max - min + 1;
        int enemyAttack = (int)(Math.random() * range) + min;

        return enemyAttack;
    }

    //FUNCTION TO DISPLAY DEMONS
    public static void displayDemon(){
        System.out.print(""
                + "\n" +
                "                  /~~\\    \n" +
                "               W ( %% )   \n" +
                "                \\ \\--/    \n" +
                "   __O           \\ II         ^  ^  ^   ^      ___I_      ^  ^   ^  ^  ^   ^  ^\n" +
                "  / /\\_,           <>  \\    /|\\/|\\/|\\ /|\\    /\\-_--\\    /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\n" +
                "___/\\             /  \\      /|\\/|\\/|\\ /|\\   /  \\_-__\\   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\n" +
                "     /_           /    \\     /|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\n\n" +
                "" + "");

        System.out.println("");
        System.out.println("Looks like you encounter a demon...");
        System.out.println("Get ready to fight it.....");
        System.out.println("");
    }

    //FUNCTION TO DISPLAY LAST DEMON
    public static void lastDemon(){
        System.out.println("" + "                                             ,--,  ,.-.\n" +
                "                ,                   \\,       '-,-`,'-.' | ._\n" +
                "               /|           \\    ,   |\\         }  )/  / `-,',\n" +
                "               [ '          |\\  /|   | |        /  \\|  |/`  ,`\n" +
                "               | |       ,.`  `,` `, | |  _,...(   (      _',\n" +
                "               \\  \\  __ ,-` `  ,  , `/ |,'      Y     (   \\_L\\\n" +
                "                \\  \\_\\,``,   ` , ,  /  |         )         _,/\n" +
                "                 \\  '  `  ,_ _`_,-,<._.<        /         /\n" +
                "                  ', `>.,`  `  `   ,., |_      |         /\n" +
                "                    \\/`  `,   `   ,`  | /__,.-`    _,   `\\\n" +
                "                -,-..\\  _  \\  `  /  ,  / `._) _,-\\`       \\\n" +
                "                 \\_,,.) /\\    ` /  / ) (-,, ``    ,        |\n" +
                "                ,` )  | \\_\\       '-`  |  `(               \\\n" +
                "               /  /```(   , --, ,' \\   |`<`    ,            |\n" +
                "              /  /_,--`\\   <\\  V /> ,` )<_/)  | \\      _____)\n" +
                "        ,-, ,`   `   (_,\\ \\    |   /) / __/  /   `----`\n" +
                "       (-, \\           ) \\ ('_.-._)/ /,`    /\n" +
                "       | /  `          `/ \\\\ V   V, /`     /\n" +
                "    ,--\\(        ,     <_/`\\\\     ||      /\n" +
                "   (   ,``-     \\/|         \\-A.A-`|     /\n" +
                "  ,>,_ )_,..(    )\\          -,,_-`  _--`\n" +
                " (_ \\|`   _,/_  /  \\_            ,--`\n" +
                "  \\( `   <.,../`     `-.._   _,-`\n" +
                "   `                      ```" + "");
        System.out.println("");
        System.out.println("Looks like you encounter the LAST DEMON...");
        System.out.println("Get ready to fight it.....");
        System.out.println("");
    }

    //FUNCTION TO SELECT A RANDOM POTION
    public static int potionSection(int playerHealth, int num){
        Scanner sc = new Scanner(System.in);

        System.out.println("Well..well.well....you found three containers with a potion inside....");
        System.out.println("But be careful.....one of the potions might make you sick.....Choose wisely....");
        System.out.println("Select from container A, B or C......");
        String selection = sc.next();
        selection = selection.trim();
        selection = selection.toLowerCase();

        if(num == 1){

            if(selection.equalsIgnoreCase("a")){
                playerHealth += 10;
                System.out.println("Excellent....You get +10 in your health....");
            }else if(selection.equalsIgnoreCase("b")){
                playerHealth -= 6;
                System.out.println("Uppsss.....looks like you got sick....you get -6 in your health...");
            }else if(selection.equalsIgnoreCase("c")){
                playerHealth += 5;
                System.out.println("Not bad... you get +5 in your health...");
            }else {
                System.out.println("Not a choice...Please select one of the provided options...");
                potionSection(playerHealth, num);
            }

        }else if(num == 2){

            if(selection.equalsIgnoreCase("a")){
                playerHealth += 5;
                System.out.println("Not bad... you get +5 in your health...");
            }else if(selection.equalsIgnoreCase("b")){
                playerHealth += 10;
                System.out.println("Excellent....You get +10 in your health....");
            }else if(selection.equalsIgnoreCase("c")){
                playerHealth -= 6;
                System.out.println("Uppsss.....looks like you got sick....you get -6 in your health...");
            }else {
                System.out.println("Not a choice...Please select one of the provided options...");
                potionSection(playerHealth, num);
            }

        }else if(num == 3){
            if(selection.equalsIgnoreCase("a")){
                playerHealth -= 6;
                System.out.println("Uppsss.....looks like you got sick....you get -6 in your health...");
            }else if(selection.equalsIgnoreCase("b")){
                playerHealth += 5;
                System.out.println("Not bad... you get +5 in your health...");
            }else if(selection.equalsIgnoreCase("c")){
                playerHealth += 10;
                System.out.println("Excellent....You get +10 in your health....");
            }else {
                System.out.println("Not a choice...Please select one of the provided options...");
                potionSection(playerHealth, num);
            }
        }

        return playerHealth;
    }

    //FUNCTION FOR GAMEOVER
    public static void gameOver(String enemy){
        System.out.printf("Looks like %s has won the battle.....%n%n", enemy);
        System.out.println(""+" _____                        _____                \n" +
                "|  __ \\                      |  _  |               \n" +
                "| |  \\/ __ _ _ __ ___   ___  | | | |_   _____ _ __ \n" +
                "| | __ / _` | '_ ` _ \\ / _ \\ | | | \\ \\ / / _ \\ '__|\n" +
                "| |_\\ \\ (_| | | | | | |  __/ \\ \\_/ /\\ V /  __/ |   \n" +
                " \\____/\\__,_|_| |_| |_|\\___|  \\___/  \\_/ \\___|_|   \n" +
                "                                                   "+"");
        System.out.println("");
    }



}
