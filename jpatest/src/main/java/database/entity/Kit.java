package database.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//////////////////////////////////////////////////////////
//Kit of exhibits. Required for database and hibernate
//////////////////////////////////////////////////////////
@Entity
@Table(name="kit")
@NamedQueries({@NamedQuery(name = "kits.getAll", query = "SELECT c from Kit c"),
	@NamedQuery(name = "kits.getFromFund", query = "SELECT c from Kit c where c.fundId= :fundId")
	})
public class Kit {
	
	/////////////////////////////////////////////////////////
	// Fields
	/////////////////////////////////////////////////////////
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
