package framework.utilities.helper_package;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileOperations {

	public static void writeInFile(String filePath, String Value) throws Exception {
		try {
			BufferedWriter BR = new BufferedWriter(new FileWriter(new File(filePath), true));
			BR.write(Value);
			BR.newLine();
			BR.close();
		}
		catch (Exception e) {

			throw e;
		}
	}
}
