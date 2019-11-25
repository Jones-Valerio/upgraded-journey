import java.util.Scanner;
import java.lang.Math;

public class AdventureGame {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String player;

        System.out.println("Enter your name:");
        player = in.nextLine();
        player = player.trim();
        int playerHealth = 100;

        System.out.printf("Welcome %s, Let's start the adventure!%n", player);

        displayDemon();

        String enemy = "Demon";
        int enemyHealth = 5;

        String enemy2 = "Another Demon";
        int enemy2Health = 5;

        String enemy3 = "Third Demon";
        int enemy3Health = 5;

        String lastEnemy = "Final Boss";
        int lastEnemyHealth = 5;

        do{
            if(playerHealth <= 0){
                break;
            }else {
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

        System.out.println("Do you want to continue to the forest or the river path?");
        String path = in.next();
        path = path.trim();
        path = path.toLowerCase();

        if(path.equalsIgnoreCase("forest")){
            displayDemon();

            do{
                if(playerHealth <= 0){
                    break;
                }else {
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
                    }

                    int yourAttack = playerAttack(attackSelection);
                    System.out.println(yourAttack);

                    enemy2Health -= yourAttack;

                    System.out.printf("You throw %d damage into your enemy.....%n", yourAttack);
                    System.out.printf("%s has now %d of Health.....%n%n", enemy2, enemy2Health);
                }

                if(enemy2Health <= 0){
                    break;
                }else{

                    int randomEnemyAttack = (int)(Math.random() * 3 - 1 + 1) + 1;
                    int yourEnemyAttack = enemyAttack(randomEnemyAttack);

                    playerHealth -= yourEnemyAttack;

                    System.err.println("\nYour enemy is going to attack you now.....Prepare\n");
                    System.err.printf("Your enemy throw %d damage to you.....%n", yourEnemyAttack);
                    System.err.printf("%s has now %d of Health.....%n%n", player, playerHealth);
                }

            }while(playerHealth > 0 && enemy2Health > 0);

            if(playerHealth > 0){
                System.out.printf("%s has won the battle...%n", player);
            }else if(enemy2Health > 0){
                gameOver(enemy2);
            }

            System.out.println("Do you want to climb the mountain or keep going into forest?");
            String secondPath = in.next();
            secondPath = secondPath.trim();
            secondPath = secondPath.toLowerCase();

            if(secondPath.equalsIgnoreCase("mountain")){
                System.out.println("You chose the mountain path");

            }

        }else if(path.equalsIgnoreCase("river")){
            System.out.println("you chose the river path");

        }

        displayDemon();

        do{
            if(playerHealth <= 0){
                break;
            }else {
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
                }

                int yourAttack = playerAttack(attackSelection);
                System.out.println(yourAttack);

                enemy3Health -= yourAttack;

                System.out.printf("You throw %d damage into your enemy.....%n", yourAttack);
                System.out.printf("%s has now %d of Health.....%n%n", enemy3, enemy3Health);
            }

            if(enemy3Health <= 0){
                break;
            }else{

                int randomEnemyAttack = (int)(Math.random() * 3 - 1 + 1) + 1;
                int yourEnemyAttack = enemyAttack(randomEnemyAttack);

                playerHealth -= yourEnemyAttack;

                System.err.println("\nYour enemy is going to attack you now.....Prepare\n");
                System.err.printf("Your enemy throw %d damage to you.....%n", yourEnemyAttack);
                System.err.printf("%s has now %d of Health.....%n%n", player, playerHealth);
            }

        }while(playerHealth > 0 && enemy3Health > 0);

        if(playerHealth > 0){
            System.out.printf("%s has won the battle...%n", player);
        }else if(enemy3Health > 0){
            gameOver(enemy3);
        }

        System.out.println("Do you want to continue the forest path or go the the lake?");
        String lastPath = in.next();
        lastPath = lastPath.trim();
        lastPath = lastPath.toLowerCase();

        if(lastPath.equalsIgnoreCase("lake")){
            System.out.println("You chose the lake path");
        }else if(lastPath.equalsIgnoreCase("forest")){
            lastDemon();

            do{
                if(playerHealth <= 0){
                    break;
                }else {
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
                    }

                    int yourAttack = playerAttack(attackSelection);
                    System.out.println(yourAttack);

                    lastEnemyHealth -= yourAttack;

                    System.out.printf("You throw %d damage into your enemy.....%n", yourAttack);
                    System.out.printf("%s has now %d of Health.....%n%n", lastEnemy, lastEnemyHealth);
                }

                if(lastEnemyHealth <= 0){
                    break;
                }else{

                    int randomEnemyAttack = (int)(Math.random() * 3 - 1 + 1) + 1;
                    int yourEnemyAttack = enemyAttack(randomEnemyAttack);

                    playerHealth -= yourEnemyAttack;

                    System.err.println("\nYour enemy is going to attack you now.....Prepare\n");
                    System.err.printf("Your enemy throw %d damage to you.....%n", yourEnemyAttack);
                    System.err.printf("%s has now %d of Health.....%n%n", player, playerHealth);
                }

            }while(playerHealth > 0 && lastEnemyHealth > 0);

            if(playerHealth > 0){
                System.out.printf("%s has won the battle...%n%n", player);
                System.out.println("" + " __ __ __    ________  ___   __    ___   __    ______   ______       \n" +
                        "/_//_//_/\\  /_______/\\/__/\\ /__/\\ /__/\\ /__/\\ /_____/\\ /_____/\\      \n" +
                        "\\:\\\\:\\\\:\\ \\ \\__.::._\\/\\::\\_\\\\  \\ \\\\::\\_\\\\  \\ \\\\::::_\\/_\\:::_ \\ \\     \n" +
                        " \\:\\\\:\\\\:\\ \\   \\::\\ \\  \\:. `-\\  \\ \\\\:. `-\\  \\ \\\\:\\/___/\\\\:(_) ) )_   \n" +
                        "  \\:\\\\:\\\\:\\ \\  _\\::\\ \\__\\:. _    \\ \\\\:. _    \\ \\\\::___\\/_\\: __ `\\ \\  \n" +
                        "   \\:\\\\:\\\\:\\ \\/__\\::\\__/\\\\. \\`-\\  \\ \\\\. \\`-\\  \\ \\\\:\\____/\\\\ \\ `\\ \\ \\ \n" +
                        "    \\_______\\/\\________\\/ \\__\\/ \\__\\/ \\__\\/ \\__\\/ \\_____\\/ \\_\\/ \\_\\/ \n" +
                        "                                                                     " + "");
                System.out.printf("Congratulations %s, looks like you defeated all demons....", player);

            }else if(lastEnemyHealth > 0){
                gameOver(lastEnemy);
            }
        }
    }

    public static int playerAttack(int attack){
        int max = 0;
        int min = 0;

        if(attack == 1){
            max = 5;
            min = 1;
        }else if(attack == 2){
            max = 6;
            min = 3;
        }else if(attack == 3){
            max = 10;
            min = 5;
        }

        int range = max - min + 1;
        int generatedAttack = (int) (Math.random() * range) + min;

        return  generatedAttack;
    }

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
            max = 5;
            min = 2;
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
            max = 8;
            min = 4;
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
