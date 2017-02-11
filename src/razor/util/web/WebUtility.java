package razor.util.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import razor.util.Constants;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class WebUtility {

	public void getImageTags(String url){
		try {

			//Connect to the website and get the html
			Document doc = Jsoup.connect(url).get();

			//Get all elements with img tag ,
			Elements img = doc.getElementsByTag("img");

			for (Element el : img) {

				//for each element get the srs url
				String src = el.absUrl("src");
				System.out.println(el.toString());

				System.out.println("Image Found!");
				System.out.println("src attribute is : "+src);

				getImages(src,url);

			}

		} catch (IOException ex) {
			System.err.println("There was an error");
			ex.printStackTrace();
		}
	}


	private static void getImages(String src, String dir) throws IOException {

		//Exctract the name of the image from the src attribute
		int indexname = src.lastIndexOf("/");

		if(indexname==-1){
			return;
		}
		if (indexname == src.length()) {
			src = src.substring(1, indexname);
		}

		indexname = src.lastIndexOf("/");
		String name = src.substring(indexname, src.length());

		System.out.println(name);

		//Open a URL Stream
		URL url = new URL(src);
		InputStream in = url.openStream();
		
		String fileName = "";
		System.out.println();

		OutputStream out = new BufferedOutputStream(new FileOutputStream( Constants.resultsPath+ (new Date().getTime()) + ".jpg"));

		for (int b; (b = in.read()) != -1;) {
			out.write(b);
		}
		out.close();
		in.close();
	}
}

