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
// Fund of museum. Required for database and hibernate
//////////////////////////////////////////////////////////

@Entity
@Table(name="fund")
@NamedQueries({@NamedQuery(name = "funds.getAll", query = "SELECT c from Fund c")
	})

public class Fund {
	
	//////////////////////////////////////////////////////////////
	// Fields
	//////////////////////////////////////////////////////////////
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="fundId")
	private int fundId;
	
	@Column(name="fundName")
	private String fundName;
	
	//////////////////////////////////////////////////////////////
	// Getters and setters
	//////////////////////////////////////////////////////////////
	
	public int getFundId() {
		return fundId;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	@Override
	public String toString() {
		return fundId + "," + fundName+",";
	}

	
}
