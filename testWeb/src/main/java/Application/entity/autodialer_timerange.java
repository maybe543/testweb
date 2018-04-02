package Application.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "autodialer_timerange")
public class autodialer_timerange {

	private String uuid;
	@DateTimeFormat(pattern = "HH:mm:ss")
	@JSONField(format = "HH:mm:ss")
	private Time begin_datetime;
	@DateTimeFormat(pattern = "HH:mm:ss")
	@JSONField(format = "HH:mm:ss")
	private Time end_datetime;
	private String group_uuid;

	// -----------uuid---------//
	@Id
	@Column(name = "uuid")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String u) {
		this.uuid = u;
	}

	// -----------begin_datetime
	@Column(name = "begin_datetime")
	public Time getBegin_datetime() {
		return begin_datetime;
	}

	public void setBegin_datetime(Time b) {
		this.begin_datetime = b;
	}

	// -----------end_datetime
	@Column(name = "end_datetime")
	public Time getEnd_datetime() {
		return end_datetime;
	}

	public void setEnd_datetime(Time e) {
		this.end_datetime = e;
	}

	// -----------group_uuid---------//

	@Column(name = "group_uuid")
	public String getGroup_uuid() {
		return group_uuid;
	}

	public void setGroup_uuid(String gu) {
		this.group_uuid = gu;
	}
}
