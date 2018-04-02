package Application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autodialer_timegroup")
public class autodialer_timegroup {

	private String uuid;
	private String name;
	private String domain;

	// -----------uuid---------//
	@Id
	@Column(name = "uuid")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String u) {
		this.uuid = u;
	}

	// -----------name---------//
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String n) {
		this.name = n;
	}
	// -----------domain---------//

	@Column(name = "domain")
	public String getDomain() {
		return domain;
	}

	public void setDomain(String d) {
		this.domain = d;
	}
}
