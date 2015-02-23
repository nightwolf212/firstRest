package database.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

///////////////////////////////////////////////////////////////////
// Moving of kits. Required for database and hibernate
///////////////////////////////////////////////////////////////////

@Entity
@Table(name="movingOfKit")
@NamedQuery(name = "moks.getAll", query = "SELECT c from MovingOfKit c")
public class MovingOfKit {
	
	/////////////////////////////////////////////////////////////////////
	// Field
	/////////////////////////////////////////////////////////////////////
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="MovingOfKitId")
	private int movingOfKitId;
	
	@Column(name="kitId")
	private int kitId;
	
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
	
	///////////////////////////////////////////////////////////////////////////////////
	// Getters and setters
	///////////////////////////////////////////////////////////////////////////////////
	
	public int getMovingOfKitId() {
		return movingOfKitId;
	}

	public int getKitId() {
		return kitId;
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

	public void setMovingOfKitId(int movingOfKitId) {
		this.movingOfKitId = movingOfKitId;
	}

	public void setKitId(int kitId) {
		this.kitId = kitId;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
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
		return movingOfKitId + ","
				+ kitId + "," + beginDate + "," + endDate
				+ "," + expoName + "," + expoAdress
				+ "," + expoPhone + "," + personName;
	}


}
