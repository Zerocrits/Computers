//Name: Bill Joseph
//Prog: Toy Store
//Spec: Create a Toy Store

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ToyStoreRunner
{
	public static void main(String[] args)
	{
		ToyStore toy = new ToyStore();
		System.out.println(toy);
		toy.loadToys("sorry bat sorry sorry sorry train train teddy teddy ball ball");
		System.out.println(toy);
		System.out.println(toy.getMostFrequentToy());

		toy = new ToyStore();
		toy.loadToys("yahtzee, monopoly, candyland, monopoly, yahtzee, candyland");
		System.out.println("\n" + toy);
		System.out.println(toy.getMostFrequentToy());

		toy = new ToyStore();
		toy.loadToys("operation, operation, boggle, scrabble, clue, life, clue, clue");
		System.out.println("\n" + toy);
		System.out.println(toy.getMostFrequentToy());
	}
}
/*

[]
[sorry 4, bat 1, train 2, teddy 2, ball 2]
Max is: sorry 4

[yahtzee, 2, monopoly, 2, candyland, 1, candyland 1]
Max is: yahtzee, 2

[operation, 2, boggle, 1, scrabble, 1, clue, 2, life, 1, clue 1]
Max is: operation, 2
Press any key to continue . . .

*/