package Application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class autodialer_number_uuid {
	
	int id;
	String number;
	int state;
	String description;
	int recycle;
	String callid;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")  
	Date calldate;
	int bill;
	int duration;
	String hangupcase;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")  
	Date hangupdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")  
	Date  answerdate;


	//-------------id
	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}
	//-------------number
	@Column(name = "number")
	public String getNumber() {
		return number;
	}

	public void setNumber(String n) {
		this.number = n;
	}
	//-------------state
	@Column(name = "state")
	public int getState() {
		return state;
	}

	public void setState(int s) {
		this.state = s;
	}
	//-------------description
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String d) {
		this.description = d;
	}
	//-------------recycle
	@Column(name = "recycle")
	public int getRecycle() {
		return recycle;
	}

	public void setRecycle(int r) {
		this.recycle = r;
	}
	//-------------callid
	@Column(name = "callid")
	public String getCallid() {
		return callid;
	}

	public void setCallid(String c) {
		this.callid = c;
	}
	//-------------calldate
	@Column(name = "calldate")
	public Date getCalldate() {
		return calldate;
	}

	public void setCalldate(Date c) {
		this.calldate = c;
	}
	//-------------bill
	@Column(name = "bill")
	public int getBill() {
		return bill;
	}

	public void setBill(int b) {
		this.bill = b;
	}
	//-------------duration
	@Column(name = "duration")
	public int getDuration() {
		return duration;
	}

	public void setDuration(int d) {
		this.duration = d;
	}
	//-------------hangupcase
	@Column(name = "hangupcase")
	public String getHangupcase() {
		return hangupcase;
	}

	public void setHangupcase(String h) {
		this.hangupcase = h;
	}
	//-------------hangupdate
	@Column(name = "hangupdate")
	public Date getHangupdate() {
		return hangupdate;
	}

	public void setHangupdate(Date h) {
		this.hangupdate = h;
	}
	//-------------answerdate
	@Column(name = "answerdate")
	public Date getAnswerdate() {
		return answerdate;
	}

	public void setAnswerdate(Date a) {
		this.answerdate = a;
	}

}
