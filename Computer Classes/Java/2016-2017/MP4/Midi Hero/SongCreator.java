import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class SongCreator
{
	private File file;
	private PrintWriter bw;
	private FileWriter fw;

	public SongCreator()
	{
	}

	public SongCreator(int[] note, int[] time, String Filename)
	{
		try {

			fw = new FileWriter(Filename);
			bw = new PrintWriter(fw);
			for(int i = 0; i < note.length; i++)
			{
				bw.println(note[i] + "\nhi" + time[i] + "\n");
			}
			bw.close();


		} catch (IOException e) {

			e.printStackTrace();

		}




		/*file = new File("Song-keys/Hello1.txt");

		// creates the file
		file.createNewFile();

		// creates a FileWriter Object
		writer = new FileWriter(file);

		// Writes the content to the file
		writer.write(note + "\n");*/
	}
}