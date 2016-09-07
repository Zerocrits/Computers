//Bill Joseph
//Histogram
//Histogram client run

public class HistogramClient
{
	public static void main(String args[])
	{
		String data = "", histo = "";
		Histogram test = new Histogram("1 5 3 4 5 5 5 4 3 2 5 5 5 3");

		data = test.getData();
		histo = test.getHistogram();
		System.out.println(data);
		System.out.println(histo);

		test.setList("2 3 4 5 6 7 8 9 0 2 3 5 6 8 8 8 9 4 5");
		data = test.getData();
		histo = test.getHistogram();
		System.out.println(data);
		System.out.println(histo);

		test.setList("2 3 4 5 6 7 8 2 0 2 3 5 6 8 8 8 9 4 5");
		data = test.getData();
		histo = test.getHistogram();
		System.out.println(data);
		System.out.println(histo);
	}
}
/*

0 - 0
1 - 1
2 - 1
3 - 3
4 - 2
5 - 7
6 - 0
7 - 0
8 - 0
9 - 0

0:
1:*
2:*
3:***
4:**
5:*******
6:
7:
8:
9:

0 - 1
1 - 1
2 - 3
3 - 5
4 - 4
5 - 10
6 - 2
7 - 1
8 - 4
9 - 2

0:*
1:*
2:***
3:*****
4:****
5:**********
6:**
7:*
8:****
9:**

0 - 2
1 - 1
2 - 6
3 - 7
4 - 6
5 - 13
6 - 4
7 - 2
8 - 8
9 - 3

0:**
1:*
2:******
3:*******
4:******
5:*************
6:****
7:**
8:********
9:***

Press any key to continue . . .

*/