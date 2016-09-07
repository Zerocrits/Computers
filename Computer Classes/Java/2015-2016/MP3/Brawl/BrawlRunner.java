//Bill Joseph
//BrawlRunner

import java.util.ArrayList;
import java.util.Scanner;

public class BrawlRunner
{
	public static void main(String[] args)
	{
		int fightCount;
		Player user = new Player();
		Character opponent = new Player();
		Scanner sc = new Scanner(System.in);
		String str="";

		System.out.println("**FIGHT CLUB, DO NOT TALK**");
		while(user.isNotDefeated())
		{
			user.setHealth(15);
			int r = (int) (Math.random() * 4)+1;
			switch(r)
			{
				case 1 : System.out.println("\nYou Are Fighting A Goblin!"); opponent = new Goblin(); break;
				case 2 : System.out.println("\nYou Are Fighting A Ghost!"); opponent = new Ghost(); break;
				case 3 : System.out.println("\nYou Are Fighting A Witch!"); opponent = new Witch(); break;
				case 4 : System.out.println("\nYou Are Fighting A Vampire!"); opponent = new Vampire(); break;
			}

			while(user.isNotDefeated() && opponent.isNotDefeated())
			{
				System.out.println("\nPress Enter To Attack!");
				str= sc.nextLine();
				System.out.println(user.displayCharacter());
				System.out.println(user.getNameOfAttack());
				System.out.println(user.attacks(opponent));
				System.out.println("" + user.toString());
				System.out.println("" + opponent.toString());
				if(opponent.isNotDefeated())
				{
					System.out.println("\nPress Enter To Defend!");
					str= sc.nextLine();
					System.out.println(opponent.displayCharacter());
					System.out.println(opponent.getNameOfAttack());
					System.out.println(opponent.attacks(user));
					System.out.println("" + user.toString());
					System.out.println("" + opponent.toString());
				}
				else
					System.out.println("\n**YOU WON**\n");
			}
		}
		System.out.println("\n**YOU LOST**\n");
	}
}

/*

**FIGHT CLUB, DO NOT TALK**

You Are Fighting A Goblin!

Press Enter To Attack!

            _,,,,,,,_
          ,88888888888,
        ,888'       `888,
        888' 0     0 `888
       888      0      888
       888             888
       888    ,000,    888
        888, 0     0 ,888
        '888,       ,888'
          '8JGS8888888'
            ````````
You sneak up and stab him!
Damage: 5

Your Level: 5
Your Health: 15

*Goblin's Level: 4
*Goblin's Health: 15

Press Enter To Defend!

             ,      ,
            /(.-''-.)\
        |\  \/      \/  /|
        | \ \/ =.  .= \ / |
        \( \   o\/o   / )/
         \_, '-/  \-' ,_/
           /   \__/   \
           \ \__/\__/ /
         ___\ \|--|/ /___
       /`    \      /    `\
      /       '----'       \
Goblin pushed you into a pit of snakes
Damage: 3

Your Level: 5
Your Health: 12

*Goblin's Level: 4
*Goblin's Health: 15

Press Enter To Attack!

            _,,,,,,,_
          ,88888888888,
        ,888'       `888,
        888' 0     0 `888
       888      0      888
       888             888
       888    ,000,    888
        888, 0     0 ,888
        '888,       ,888'
          '8JGS8888888'
            ````````
You sneak up and stab him!
Damage: 5

Your Level: 5
Your Health: 12

*Goblin's Level: 4
*Goblin's Health: 10

Press Enter To Defend!

             ,      ,
            /(.-''-.)\
        |\  \/      \/  /|
        | \ \/ =.  .= \ / |
        \( \   o\/o   / )/
         \_, '-/  \-' ,_/
           /   \__/   \
           \ \__/\__/ /
         ___\ \|--|/ /___
       /`    \      /    `\
      /       '----'       \
Goblin Throws Dynamite at you!
Damage: 3

Your Level: 5
Your Health: 9

*Goblin's Level: 4
*Goblin's Health: 10

Press Enter To Attack!

            _,,,,,,,_
          ,88888888888,
        ,888'       `888,
        888' 0     0 `888
       888      0      888
       888             888
       888    ,000,    888
        888, 0     0 ,888
        '888,       ,888'
          '8JGS8888888'
            ````````
You sneak up and stab him!
Damage: 3

Your Level: 5
Your Health: 9

*Goblin's Level: 4
*Goblin's Health: 7

Press Enter To Defend!

             ,      ,
            /(.-''-.)\
        |\  \/      \/  /|
        | \ \/ =.  .= \ / |
        \( \   o\/o   / )/
         \_, '-/  \-' ,_/
           /   \__/   \
           \ \__/\__/ /
         ___\ \|--|/ /___
       /`    \      /    `\
      /       '----'       \
Goblin bit down on your leg
Damage: 2

Your Level: 5
Your Health: 7

*Goblin's Level: 4
*Goblin's Health: 7

Press Enter To Attack!

            _,,,,,,,_
          ,88888888888,
        ,888'       `888,
        888' 0     0 `888
       888      0      888
       888             888
       888    ,000,    888
        888, 0     0 ,888
        '888,       ,888'
          '8JGS8888888'
            ````````
You swipe out his legs!
Damage: 1

Your Level: 5
Your Health: 7

*Goblin's Level: 4
*Goblin's Health: 6

Press Enter To Defend!

             ,      ,
            /(.-''-.)\
        |\  \/      \/  /|
        | \ \/ =.  .= \ / |
        \( \   o\/o   / )/
         \_, '-/  \-' ,_/
           /   \__/   \
           \ \__/\__/ /
         ___\ \|--|/ /___
       /`    \      /    `\
      /       '----'       \
Goblin Screams loudly
Damage: 1

Your Level: 5
Your Health: 6

*Goblin's Level: 4
*Goblin's Health: 6

Press Enter To Attack!

            _,,,,,,,_
          ,88888888888,
        ,888'       `888,
        888' 0     0 `888
       888      0      888
       888             888
       888    ,000,    888
        888, 0     0 ,888
        '888,       ,888'
          '8JGS8888888'
            ````````
You command your to dog attack!
Damage: 3

Your Level: 5
Your Health: 6

*Goblin's Level: 4
*Goblin's Health: 3

Press Enter To Defend!

             ,      ,
            /(.-''-.)\
        |\  \/      \/  /|
        | \ \/ =.  .= \ / |
        \( \   o\/o   / )/
         \_, '-/  \-' ,_/
           /   \__/   \
           \ \__/\__/ /
         ___\ \|--|/ /___
       /`    \      /    `\
      /       '----'       \
Goblin bit down on your leg
Damage: 1

Your Level: 5
Your Health: 5

*Goblin's Level: 4
*Goblin's Health: 3

Press Enter To Attack!

            _,,,,,,,_
          ,88888888888,
        ,888'       `888,
        888' 0     0 `888
       888      0      888
       888             888
       888    ,000,    888
        888, 0     0 ,888
        '888,       ,888'
          '8JGS8888888'
            ````````
You command your to dog attack!
Damage: 3

Your Level: 5
Your Health: 5

*Goblin's Level: 4
*Goblin's Health: 0

**YOU WON**


You Are Fighting A Goblin!

Press Enter To Attack!



*/
