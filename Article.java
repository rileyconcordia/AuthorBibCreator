//------------------------------------------------------------------------
//Written by: Kwok Ho, Chan 40091211 | Lang Zhu 27890575
//COMP249
//Assignment 3
//Question 1
//Due Date: March 17, 2019
//------------------------------------------------------------------------
import java.util.List;

public class Article {
	
	/**
	 * 
	 * @author riley
	 *
	 */
	public class Author {
		
		private String[] authors;
		
		/**
		 * 
		 * @param authorString
		 */
		public Author(String authorString) {
			this.authors = authorString.split(" and ");
		}
		
		/**
		 * 
		 * @return the author based on IEEE
		 * 
		 */
		public String toIEEEString() {
			return String.join(" and ", this.authors);
		}
		
		/**
		 * 
		 * @return the author based on ACM
		 */
		public String toACMString() {
			if(this.authors.length > 1) {
				return this.authors[0] + " et al";
			} else {
				return this.authors[0];				
			}
		}
		
		/**
		 * 
		 * @return the author based on NJ
		 */
		public String toNJSring() {
			return String.join(" & ", this.authors);
		}
		
		/**
		 * 
		 * @param keyword
		 * @return true if keyword is found
		 */
		public boolean contains(String keyword) {
			for(String author : authors) {
				if(author.contains(keyword)) {
					return true;
				}
			}
			return false;
		}
		
	}
	
	public Author author;
	public String journal;
	public String title;
	public String year;
	public String volume;
	public String number;
	public String pages;
	public String keywords;
	public String doi;
	public String ISSN;
	public String month;
	
	/**
	 * 
	 * @return author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * setter
	 * @param author
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * 
	 * @return journal
	 */
	public String getJournal() {
		return journal;
	}

	/**
	 * set journal
	 * @param journal
	 */
	public void setJournal(String journal) {
		this.journal = journal;
	}

	/**
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * set title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * set year
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 
	 * @return volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * set volume
	 * @param volume
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * 
	 * @return number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * set number
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * 
	 * @return pages
	 */
	public String getPages() {
		return pages;
	}

	/**
	 * set pages
	 * @param pages
	 */
	public void setPages(String pages) {
		this.pages = pages;
	}

	/**
	 * 
	 * @return keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * set keywords
	 * @param keywords
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * 
	 * @return doi
	 */
	public String getDoi() {
		return doi;
	}

	/**
	 * set doi
	 * @param doi
	 */
	public void setDoi(String doi) {
		this.doi = doi;
	}

	/**
	 * 
	 * @return ISSN
	 */
	public String getISSN() {
		return ISSN;
	}

	/**
	 * set ISSN
	 * @param iSSN
	 */
	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}

	/**
	 * 
	 * @return month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * set month
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * 
	 * @param attribute
	 * @param value
	 */
	public void set(String attribute, String value) {
		switch(attribute) {
			case "author":
				this.setAuthor(new Author(value));
			break;
			case "journal":
				this.setJournal(value);
			break;
			case "title":
				this.setTitle(value);
			break;
			case "year":
				this.setYear(value);
			break;
			case "volume":
				this.setVolume(value);
			break;
			case "number":
				this.setNumber(value);
			break;
			case "pages":
				this.setPages(value);
			break;
			case "keywords":
				this.setKeywords(value);
			break;
			case "doi":
				this.setDoi(value);
			break;
			case "ISSN":
				this.setISSN(value);
			break;
			case "month":
				this.setMonth(value);
			break;
		}
	}
	
	/**
	 * 
	 * @return the whole ref based on IEEE
	 */
	public String toIEEEString() {
		return (
			this.getAuthor().toIEEEString() + ". "
			+ "\"" + this.getTitle() + "\", " + this.getJournal() + ", vol. " + this.getVolume() +  ", " + this.getNumber() + ", p. " + this.getPages() + ", " + this.getMonth() + " " + this.getYear()
		);
	}
	
	/**
	 * 
	 * @return the whole ref based on ACM
	 */
	public String toACMString() {
		return (
			this.getAuthor().toACMString() + ". "
			+ this.getYear() + ". " + this.getTitle() + ". " + this.getJournal() + ". " + this.getVolume() + ", " + this.getNumber() + " (" + this.getYear() + "), " + this.getPages() + ". DOI:https://doi.org/" + this.getDoi() + "." 
		);
	}
	
	/**
	 * 
	 * @return the whole ref based on NJ
	 */
	public String toNJString() {
		return (
			this.getAuthor().toNJSring() + ". "
			+ this.getTitle() + ". " + this.getJournal() + ". " + this.getVolume() + ", " + this.getPages() + "(" + this.getYear() + ")"
		);
	}

}
