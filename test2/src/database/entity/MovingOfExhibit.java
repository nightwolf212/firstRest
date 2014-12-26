package database.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

///////////////////////////////////////////////////////////////
// Moving of exhibits. Required for database and hibernate
///////////////////////////////////////////////////////////////

@Entity
@Table(name="movingOfExhibit")
public class MovingOfExhibit {
	
	//////////////////////////////////////////////////////////////
	// Fields
	//////////////////////////////////////////////////////////////
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="MovingOfExId")
	private int movingOfExId;
	
	@Column(name="exhibitId")
	private int exhibitId;
	
	@Column(name="beginDate")
	private Date beginDate;
	
	@Column(name="endDate")
	private Date endDate;
	
	@Column(name="expoName")
	private String expoName;
	
	@Column(name="expoAdress")
	private String expoAdress;
	
	@Column(name="expoPhone")
	private String expoPhone;
	
	@Column(name="personName")
	private String personName;  // contact person
	
	/////////////////////////////////////////////////////////////
	// Getters and setters
	/////////////////////////////////////////////////////////////

	public int getMovingOfExId() {
		return movingOfExId;
	}

	public int getExhibitId() {
		return exhibitId;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getExpoName() {
		return expoName;
	}

	public String getExpoAdress() {
		return expoAdress;
	}

	public String getExpoPhone() {
		return expoPhone;
	}

	public String getPersonName() {
		return personName;
	}

	public void setMovingOfExId(int movingOfExId) {
		this.movingOfExId = movingOfExId;
	}

	public void setExhibitId(int exhibitId) {
		this.exhibitId = exhibitId;
	}

	public void setBeginDate(Date dt) {
		this.beginDate = dt;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setExpoName(String expoName) {
		this.expoName = expoName;
	}

	public void setExpoAdress(String expoAdress) {
		this.expoAdress = expoAdress;
	}

	public void setExpoPhone(String expoPhone) {
		this.expoPhone = expoPhone;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Override
	public String toString() {
		return movingOfExId + ","
				+ exhibitId + "," + beginDate + ","
				+ endDate + "," + expoName + ","
				+ expoAdress + "," + expoPhone + ","
				+ personName;
	}
	

}
