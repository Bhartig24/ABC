
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


public class CsvUpdate {
public static void main(String[] args) {
	try {
		CSVWriter w = new CSVWriter(new FileWriter("agg.csv", true));
		String[] head = {"Results", "From Data.csv, Average of:"};
		w.writeNext(head);
		w.close();	
	} catch (Exception e){
		System.out.println(e);
	}
	int i = 1;
	while(true){
		int sum = 0;
		int n = 0;
		float agg = 0;
		try {
			int p = i;
			CSVReader data = new CSVReader(new FileReader("data.csv"),  '\t', '\'',i);
			String [] nextLine;
		     while ((nextLine = data.readNext()) != null) {
		        i++;
		        n++;
		        sum = sum + Integer.parseInt(nextLine[0]);
		     }
		     if(n != 0){
		    	 agg =(float) sum/n;
		    	 CSVWriter writer = new CSVWriter(new FileWriter("agg.csv", true));
		    	 String r2;
		    	 if(n == 1){
		    		 r2 = p+"th row";
		    	 } else{
		    		 r2 = p+"th row to "+(i-1)+"th row" ;
		    	 }
		    	 String[] entry= {agg+"",r2};
		    	 writer.writeNext(entry); 
		    	 writer.close();
		     }
		     //System.out.println(agg);
		     try{ 
		    	 CSVWriter wd = new CSVWriter(new FileWriter("data.csv", true),',','\0');
		    	 Random randomno = new Random();
		    	 String[] e1 =  {Integer.toString(randomno.nextInt(100))};
		    	 String[] e2 =  {Integer.toString(randomno.nextInt(100))};
		    	 String[] e3 =  {Integer.toString(randomno.nextInt(100))};
		    	 wd.writeNext(e1);
		    	 wd.writeNext(e2);
		    	 wd.writeNext(e3);
		    	 wd.close();
		    	 
		    	 Thread.sleep(3000);
		     } catch(Exception e){
		    	 System.out.println(e);
		     }
		     data.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	}
}
