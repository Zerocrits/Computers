import java.util.Scanner;

public class LightsOutRunner
{
	public static void main(String[] args)
	{
		LightsOut lights = new LightsOut("0000 0030 6000 0000", 1);
		System.out.println(lights.toString());
		lights = new LightsOut("0020 70C8 1020 0000", 2);
		System.out.println(lights.toString());

	}
}