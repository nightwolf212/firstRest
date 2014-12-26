package database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
////////////////////////////////////////////////////////////
//Authors of exhibits. Required for database and hibernate
////////////////////////////////////////////////////////////

@Entity
@Table(name="author")
public class Author {
	
	////////////////////////////////////////////////////////
	//Fields
	////////////////////////////////////////////////////////
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="authorId")
	private int authorId;    
	
	@Column(name="authorName")
	private String authorName;  
	
	@Column(name="birth")
	private String birth;  // date of birth
	
	@Column(name="country")
	private String country;
		
	/////////////////////////////////////////////////////////
	// Getters and setters
	/////////////////////////////////////////////////////////
	
	public int getAuthorId() {
		return authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public String getBirth() {
		return birth;
	}
	public String getCountry() {
		return country;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return  authorId + "," + authorName
				+ "," + birth + "," + country+",";
	}  

	


}
