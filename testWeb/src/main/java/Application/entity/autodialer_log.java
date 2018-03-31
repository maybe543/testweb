package Application.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "autodialer_log")

public class autodialer_log implements Serializable{

	private String uuid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")  
	private Date create_datetime;
	
	private String table_name;
	private String related_id;
	private String domain;
	private String content;
	
    //-----------uuid---------//
	@Id
	@Column(name = "uuid")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String u) {
		this.uuid = u;
	}
	
	//-----------create_datetime---------//
	
	@Column(name = "create_datetime")

	public Date getCreate_datetime() {
		return create_datetime;
	}

	public void setCreate_datetime(Date c) {
		this.create_datetime = c;
	}
	
	//-----------table_name---------//
	@Column(name = "table_name")
	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String t) {
		this.table_name = t;
	}
	
	
	//-----------related_id---------//
	@Column(name = "related_id")
	public String getRelated_id() {
		return related_id;
	}

	public void setRelated_id(String r) {
		this.related_id = r;
	}
	
	
	//-----------domain---------//
	@Column(name = "domain")
	public String getDomain() {
		return domain;
	}

	public void setDomain(String d) {
		this.domain = d;
	}
	
	
	//-----------content---------//
		@Column(name = "content")
		public String getContent() {
			return content;
		}

		public void setContent(String c) {
			this.content = c;
		}
		
		@Override
		public String toString() {
			return "autodialer_log [uuid" + uuid + ", create_datetime=" + create_datetime.toString() + ", table_name=" + table_name + ", related_id=" + related_id + ", domain="
					+ domain + ", content=" + content + "]";
		}
	
}

