package database.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

//////////////////////////////////////////////////////////
//Kit of exhibits. Required for database and hibernate
//////////////////////////////////////////////////////////
@Entity
@Table(name="kit")
public class Kit {
	
	/////////////////////////////////////////////////////////
	// Fields
	/////////////////////////////////////////////////////////
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="kitId")
	private int kitId;
	
	@Column(name="kitName")
	private String kitName;
	
	@Column(name="fundId")
	private int fundId; // fund that owns a kit
	
	@Column(name="isFree")
	private boolean isFree; // flag, which show, can we or not move this kit
	
	///////////////////////////////////////////////////////////////
	// Getters and setters
	///////////////////////////////////////////////////////////////
	
	public int getKitId() {
		return kitId;
	}

	public String getKitName() {
		return kitName;
	}

	public int getFundId() {
		return fundId;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setKitId(int kitId) {
		this.kitId = kitId;
	}

	public void setKitName(String kitName) {
		this.kitName = kitName;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	@Override
	public String toString() {
		return kitId + "," + kitName + ","
				+ fundId + "," + isFree+",";
	}
	
}
