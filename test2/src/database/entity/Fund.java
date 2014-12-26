package database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//////////////////////////////////////////////////////////
// Fund of museum. Required for database and hibernate
//////////////////////////////////////////////////////////

@Entity
@Table(name="fund")
public class Fund {
	
	//////////////////////////////////////////////////////////////
	// Fields
	//////////////////////////////////////////////////////////////
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
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
