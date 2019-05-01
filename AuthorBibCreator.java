//------------------------------------------------------------------------
//Written by: Kwok Ho, Chan 40091211 | Lang Zhu 27890575
//COMP249
//Assignment 3
//Question 1
//Due Date: March 17, 2019
//------------------------------------------------------------------------
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class AuthorBibCreator {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {


		System.out.println("Welcome to BibCreator!"); //welcome message
		
		Scanner kb = new Scanner(System.in); //for user input
		Scanner sc = null; // to read the files
		File file = null;
		
		System.out.println("Please enter the author name you are targeting: "); //welcome message
		String userinput = kb.nextLine(); //to store the user's input

		List<Article> articles = new ArrayList<>();//arraylist		
		
		for(int i=1; i<=10; i++) {
			try //TRY TO OPEN THE FILE
			{	
				
				file = new File(("Latex" + i + ".bib"));
				sc = new Scanner(new FileInputStream(file));//open each file

				//after open the 10 files, check if any files already exist

				File temp_IEEE=null, temp_ACM=null, temp_NJ=null; //create the files for checking
				temp_IEEE = new File(userinput + "-IEEE.json"); //files for author-name-IEEE
				temp_ACM = new File(userinput + "-ACM.json"); //files for author-name-ACM
				temp_NJ = new File(userinput + "-NJ.json"); //files for author-name-NJ
				
				if (temp_IEEE.exists() || temp_ACM.exists() || temp_NJ.exists()) {
					
					throw new FileExistsException();
					
				} //throw FileExistsException if those files exist
				
			}
			
			catch(FileNotFoundException e) 
			{							   
				System.out.println("Could not open input file for reading."
						       + " Please check if file exists.");	
				System.out.print("Program will terminate.");
				System.exit(0);			   
			}//CATCH FILE NOT FOUND EXCEPTION
			
			catch (IOException e){
				System.out.println("IOException is caught");
				System.exit(0);	
			}//CATCH IO EXCEPTION
			
			catch (NoSuchElementException e) {
				System.out.println("NoSuchElementException is caught");
				System.exit(0);
			}//CATCH NoSuchElement Exception
			
			catch (IllegalStateException e) {
				System.out.println("IllegalStateException is caught");
				System.exit(0);
			}//CATCH Illegal State Exception
			
			catch (FileExistsException e) {
				System.out.println(e.getMessage());
				
				//declare the files
				File temp_IEEE=null, temp_ACM=null, temp_NJ=null; //create the files for checking
				temp_IEEE = new File(userinput + "-IEEE.json"); //files for author-name-IEEE
				temp_ACM = new File(userinput + "-ACM.json"); //files for author-name-ACM
				temp_NJ = new File(userinput + "-NJ.json"); //files for author-name-NJ				
				
				//declare the BU files				
				File temp_IEEE_BU=null, temp_ACM_BU=null, temp_NJ_BU=null; //create the BU files for checking
				temp_IEEE_BU = new File(userinput + "-IEEE-BU.json"); //files for author-name-IEEE
				temp_ACM_BU = new File(userinput + "-ACM-BU.json"); //files for author-name-ACM
				temp_NJ_BU = new File(userinput + "-NJ-BU.json"); //files for author-name-NJ
						
				//delete and rename
				if (temp_IEEE_BU.exists() || temp_ACM_BU.exists() || temp_NJ_BU.exists()) {
										
					//rename IEEE file
					if (temp_IEEE_BU.exists()) {
						boolean success;
						
						temp_IEEE_BU.delete();
						success = temp_IEEE.renameTo(temp_IEEE_BU);
						System.out.println("A file already exists with the name: " + userinput + "-IEEE.json" + "\nFile will be renamed as: " + userinput + "-IEEE-BU.json and any old BUs will be deleted.\n");	
						
						if (!success) {
							System.out.println(userinput+"-IEEE.json" + "is not renamed to " + userinput + "-IEEE-BU.json");
						}

					}//finish IEEE rename process
					
					//rename ACM file
					if (temp_ACM_BU.exists()) {
						boolean success;
						
						temp_ACM_BU.delete();
						success = temp_ACM.renameTo(temp_ACM_BU);
						System.out.println("A file already exists with the name: " + userinput + "-ACM.json" + "\nFile will be renamed as: " + userinput + "-ACM-BU.json and any old BUs will be deleted.\n");
						
						if (!success) {
							System.out.println(userinput+"-ACM.json" + " is not renamed to " + userinput + "-ACM-BU.json");
						}
	
					}//finish ACM rename process

					if (temp_NJ_BU.exists()) {
						boolean success;
						
						temp_NJ_BU.delete();
						success = temp_NJ.renameTo(temp_NJ_BU);
						System.out.println("A file already exists with the name: " + userinput + "-NJ.json" + "\nFile will be renamed as: " + userinput + "-NJ-BU.json and any old BUs will be deleted.\n");
						
						if (!success) {
							System.out.println(userinput+"-NJ.json" + "is not renamed to " + userinput + "-NJ-BU.json");
						}

					}//finish NJ rename process	

				}//finish the delete and rename process
				
				else {
					boolean success_rename_IEEE;
					success_rename_IEEE = temp_IEEE.renameTo(temp_IEEE_BU);
					System.out.println(userinput+"-IEEE.json" + " is renamed as " + userinput+"-IEEE-BU.json" );
					if (!success_rename_IEEE) {
						System.out.println(userinput+"-IEEE.json" + "is not renamed to " + userinput + "-IEEE-BU.json");
					}
					
					boolean success_rename_ACM;
					success_rename_ACM = temp_ACM.renameTo(temp_ACM_BU);
					System.out.println(userinput+"-ACM.json" + " is renamed as " + userinput+"-ACM-BU.json" );
					if (!success_rename_ACM) {
						System.out.println(userinput+"-ACM.json" + "is not renamed to " + userinput + "-ACM-BU.json");
					}
					
					boolean success_rename_NJ;
					success_rename_NJ = temp_NJ.renameTo(temp_NJ_BU);
					System.out.println(userinput+"-NJ-BU.json" + "is renamed as" + userinput+"-NJ-BU.json");
					if (!success_rename_NJ) {
						System.out.println(userinput+"-NJ.json" + "is not renamed to " + userinput + "-NJ-BU.json");
					}
					
				}//finish rename process when there is no BU files
				
			}//CATCH File Exists Exception
	
			List<Article> articlesFromFile = LoadArticlesFromFile(sc);
			for(Article article : articlesFromFile) {
				articles.add(article);
			}
		}//CLOSE OF FOR-LOOP
		
		
		//for loop to create the three empty files: 1)authur-name-IEEE.json, 2)authur-name-ACM.json, 3)authur-name-NJ.json
		for(int i=1; i<=10; i++) {
			try
			{ 
				PrintWriter pw_1 = new PrintWriter(new FileOutputStream(userinput+"-IEEE.json")); //create authur-name-IEEE.json
				PrintWriter pw_2 = new PrintWriter(new FileOutputStream(userinput+"-ACM.json")); //create authur-name-ACM.json
				PrintWriter pw_3 = new PrintWriter(new FileOutputStream(userinput+"-NJ.json")); //create authur-name-NJ.json
			}
			catch (FileNotFoundException e2) //caught FileNotFoundException for the creation of the three empty files
			{
				System.out.println("FileNotFoundException is caught");
			}
		}
		

		//to check if there is the author
		File filetoopen = null;
		Scanner sc_check = null;
		String str="";
		ArrayList<String>arrlist_check = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			try //TRY TO OPEN THE FILE
			{	
				filetoopen = new File(("Latex" + i + ".bib"));
				sc_check = new Scanner(new FileInputStream(filetoopen));
				
				while(sc_check.hasNextLine()) {
					str = sc_check.nextLine();
					arrlist_check.add(str);
				}
	
			}
			catch(Exception e) {
				System.out.println("");
			}
		}
		
		boolean check = false;
		for (int i=0; i<arrlist_check.size(); i++) {
			if (arrlist_check.get(i).contains(userinput)){
				check = true;
				break;
			}
		}
		//end of checking
		
		
		
		try {
			if (check) {
				processBibFiles(articles, userinput);//process files
			}
			else {
				File temp_IEEE = new File(userinput + "-IEEE.json"); //files for author-name-IEEE
				File temp_ACM = new File(userinput + "-ACM.json"); //files for author-name-ACM
				File temp_NJ = new File(userinput + "-NJ.json"); //
				temp_IEEE.delete();
				temp_ACM.delete();
				temp_NJ.delete();
				
				System.out.println("No records were found for author(s) with name: " + userinput);
				System.out.println("No files have been created");
				System.out.println("Goodbye! Hope you have enjoyed creating the needed files using AuthorBibCreator.");
				
			}
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
		}

		
	}
	
	
	
	
	/**
	 * 
	 * @param sc
	 * @return the elements in the ref in order to fit in every kind of ref style
	 */
	public static List<Article> LoadArticlesFromFile(Scanner sc) {
		List<Article> articles = new ArrayList<>();
		
		Article article = null;
		Pattern pattern = Pattern.compile("^([a-zA-Z]*?)=\\{(.*?)\\},\\s?$");
		while(sc.hasNextLine()) {
			String line = sc.nextLine();//read each file until the final line
			
			// There is a new article
			if(line.indexOf("@ARTICLE") == 0) {
				article = new Article();
			}
			// This is the end of the article.
			else if(line.indexOf("}") == 0) {
				articles.add(article);
			}
			else {
				Matcher matcher = pattern.matcher(line);
				if(matcher.matches()) {
					String attribute = matcher.group(1);
					String value = matcher.group(2);
					
					article.set(attribute, value);
				}
			}
		}
		return articles;
	}
	
	
	/**
	 * 
	 * @param articles
	 * @param userinput
	 * @throws FileNotFoundException
	 */
	public static void processBibFiles(List<Article> articles, String userinput) throws FileNotFoundException{
		
		String keyword = userinput;
		PrintWriter pw_IEEE = null;
		PrintWriter pw_ACM = null;
		PrintWriter pw_NJ = null;
		
		
		pw_IEEE = new PrintWriter(new FileOutputStream(keyword+"-IEEE.json"));
		pw_ACM = new PrintWriter(new FileOutputStream(keyword+"-ACM.json"));
		pw_NJ = new PrintWriter(new FileOutputStream(keyword+"-NJ.json"));
		
		//Article article;
		
		int count=0;
		
		
		for(Article article : articles) {
			if(!article.getAuthor().contains(keyword)) {

				continue;
			}	
			
			pw_IEEE.println(article.toIEEEString() + "\n");	
			
			pw_ACM.println("[" + (count+1) + "]" + article.toACMString() + "\n");
			
			pw_NJ.println(article.toNJString() + "\n");
			
			count++;
			
		}
		
		
		
		
		pw_IEEE.close();
		pw_ACM.close();
		pw_NJ.close();	
	}

}
