package swd20.leffapankki.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.FetchType;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	private int rating;
	private int year;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "categoryid")
	private Category category;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Movie(String title, int rating, int year, Category category) {
		super();
		this.title = title;
		this.rating = rating;
		this.year = year;
		this.category = category;
	}
	
	public Movie() {}
	
	@Override
	public String toString() {
		if (this.category != null)
		return "Movie [id=" + id + ", title=" + title + ", rating=" + rating + ", year=" + year + ", category="
				+ this.getCategory() + "]";
		else
			return	"Movie [id=" + id + ", title=" + title + ", rating=" + rating + ", year=" + year + ", category="
			+ category + "]";
	}		
}
