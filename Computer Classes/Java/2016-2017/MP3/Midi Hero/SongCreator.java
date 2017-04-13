import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class SongCreator
{
	private File file;
	private BufferedWriter bw;
	private FileWriter fw;

	public SongCreator()
	{
	}

	public SongCreator(int note, int time, String Filename)
	{
		try {

			fw = new FileWriter(Filename);
			bw = new BufferedWriter(fw);
			bw.write(note + "\n" + time + "\n");


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