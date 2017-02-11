package razor.main;

import java.util.List;

import razor.edge.Edge;
import razor.handle.Handle;
import razor.util.file.FileIO;
import razor.util.web.WebUtility;

public class Main {
	public static void main(String [] args){

		FileIO fileio = new FileIO();
		List<String> urls = fileio.getURLs();
		
		WebUtility webUtility = new WebUtility();
		webUtility.getImageTags(urls.get(0));
		
		System.out.println("DONE!!!!!!!!");
	}
}
