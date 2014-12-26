package database.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//////////////////////////////////////////////////
// Exhibit in museum. Required for database and hibernate.
//////////////////////////////////////////////////

@Entity
@Table(name="exhibit")
public class Exhibit {
	
	/////////////////////////////////////////////////
	// Fields
	/////////////////////////////////////////////////
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="exhibitId")
	private int exhibitId;
	
	@Column(name="exhibitName")
	private String exhibitName;
	
	@Column(name="createDate")
	private String createDate;  //date of creation
	
	@Column(name="authorId")
	private int authorId;
	
	@Column(name="kitId")
	private int kitId; 
	
	@Column(name="respName")
	private String respName; //person, responsible for exhibit
	
	@Column(name="isFree")
	private boolean isFree;
	/////////////////////////////////////////////////////
	// Getters and setters
	/////////////////////////////////////////////////////
	
	public int getExhibitId() {
		return exhibitId;
	}
	public String getExhibitName() {
		return exhibitName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public int getAuthorId() {
		return authorId;
	}
	public String getRespName() {
		return respName;
	}
	public int getKitId() {
		return kitId;
	}
	public void setKitId(int kitId) {
		this.kitId = kitId;
	}
	public void setExhibitId(int exhibitId) {
		this.exhibitId = exhibitId;
	}
	public void setExhibitName(String exhibitName) {
		this.exhibitName = exhibitName;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public void setRespName(String respName) {
		this.respName = respName;
	}
	@Override
	public String toString() {
		return  exhibitId + ","
				+ exhibitName + ","+kitId+"," + createDate + ","
				+ authorId + "," + respName+","+isFree+",";
	}
	public boolean isFree() {
		return isFree;
	}
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

}
