package info;
import java.util.Date;

///////////////////////////////////////////////////////////////////
// Information about exposition
///////////////////////////////////////////////////////////////////

public class ExpoInfo {
	
	////////////////////////////////////////////////////////////////////////
	// Fields
	////////////////////////////////////////////////////////////////////////
	private String expoName;
	private String expoAdress;
	private String expoPhone;
	private String personName;
	private Date beginDate;
	private Date endDate;
	
	/////////////////////////////////////////////////////////////////////////
	// Constructor
	/////////////////////////////////////////////////////////////////////////
	
	public ExpoInfo(String expoName, String expoAdress, String expoPhone,
			String personName, Date beginDate, Date endDate) {	
		this.expoName = expoName;
		this.expoAdress = expoAdress;
		this.expoPhone = expoPhone;
		this.personName = personName;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	//////////////////////////////////////////////////////////////////////////
	// Getters
	//////////////////////////////////////////////////////////////////////////
	
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
	public Date getBeginDate() {
		return beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}

	@Override
	public String toString() {
		return expoName + "," + expoAdress
				+ "," + expoPhone + "," + personName
				+ "," + beginDate + "," + endDate;
	}

}
