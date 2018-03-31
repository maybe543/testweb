package Application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "autodialer_task")
public class autodialer_task {
	private String uuid;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date create_datetime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date alter_datetime;
	private int start;
	private int maximumcall;
	private int recycle_limit;
	private int random_assignment_number;
	private String disable_dial_timegroup;
	private String destination_extension;
	private String destination_dialplan;
	private String destination_context;
	private float scheduling_policy_ratio;
	private String scheduling_queue;
	private String dial_format;
	private String domain;
	private String remark;
	private String originate_variables;
	private int _originate_timeout;
	private String _origination_caller_id_number;
	private String _ignore_early_media;
	

	//-----------uuid
	@Id
	@Column(name = "uuid")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String u) {
		this.uuid = u;
	}

	//-----------name
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String n) {
		this.name = n;
	}
	//-----------create_datetime
	@Column(name = "create_datetime")
	public Date getCreate_datetime() {
		return create_datetime;
	}

	public void setCreate_datetime(Date c) {
		this.create_datetime = c;
	}
	//-----------alter_datetime
	@Column(name = "alter_datetime")
	public Date getAlter_datetime() {
		return alter_datetime;
	}

	public void setAlter_datetime(Date a) {
		this.alter_datetime = a;
	}
	//-----------start
	@Column(name = "start")
	public int getStart() {
		return start;
	}

	public void setStart(int s) {
		this.start = s;
	}
	//-----------maximumcall
	@Column(name = "maximumcall")
	public int getMaximumcall() {
		return maximumcall;
	}

	public void setMaximumcall(int m) {
		this.maximumcall = m;
	}
	//-----------recycle_limit
	@Column(name = "recycle_limit")
	public int getRecycle_limit() {
		return recycle_limit;
	}

	public void setRecycle_limit(int r) {
		this.recycle_limit = r;
	}
	//-----------random_assignment_number
	@Column(name = "random_assignment_number")
	public int getRandom_assignment_number() {
		return random_assignment_number;
	}

	public void setRandom_assignment_number(int r) {
		this.random_assignment_number = r;
	}
	//-----------disable_dial_timegroup
	@Column(name = "disable_dial_timegroup")
	public String geDisable_dial_timegroup() {
		return disable_dial_timegroup;
	}

	public void setDisable_dial_timegroup(String d) {
		this.disable_dial_timegroup = d;
	}
	//-----------destination_extension
	@Column(name = "destination_extension")
	public String getDestination_extension() {
		return destination_extension;
	}

	public void setDestination_extension(String d) {
		this.destination_extension = d;
	}
	//-----------destination_dialplan
	@Column(name = "destination_dialplan")
	public String getDestination_dialplan() {
		return destination_dialplan;
	}

	public void setDestination_dialplan(String d) {
		this.destination_dialplan = d;
	}
	//-----------destination_context
	@Column(name = "destination_context")
	public String getDestination_context() {
		return destination_context;
	}

	public void setDestination_context(String s) {
		this.destination_context = s;
	}
	//-----------scheduling_policy_ratio
	@Column(name = "scheduling_policy_ratio")
	public float getScheduling_policy_ratio() {
		return scheduling_policy_ratio;
	}

	public void setScheduling_policy_ratio(float s) {
		this.scheduling_policy_ratio = s;
	}
	//-----------scheduling_queue
	@Column(name = "scheduling_queue")
	public String getScheduling_queue() {
		return scheduling_queue;
	}

	public void setScheduling_queue(String s) {
		this.scheduling_queue = s;
	}
	//-----------dial_format
	@Column(name = "dial_format")
	public String getDial_format() {
		return dial_format;
	}

	public void setDial_format(String d) {
		this.dial_format = d;
	}
	//-----------domain
	@Column(name = "domain")
	public String getDomain() {
		return domain;
	}

	public void setDomain(String d) {
		this.domain = d;
	}
	//-----------remark
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String r) {
		this.remark = r;
	}
	//-----------originate_variables
	@Column(name = "originate_variables")
	public String getOriginate_variables() {
		return originate_variables;
	}

	public void setOriginate_variables(String o) {
		this.originate_variables = o;
	}
	//-----------_originate_timeout
	@Column(name = "_originate_timeout")
	public int get_Originate_timeout() {
		return _originate_timeout;
	}

	public void set_Originate_timeout(int o) {
		this._originate_timeout = o;
	}
	//-----------_origination_caller_id_number
	@Column(name = "_origination_caller_id_number")
	public String get_Origination_caller_id_number() {
		return _origination_caller_id_number;
	}

	public void set_Origination_caller_id_number(String o) {
		this._origination_caller_id_number = o;
	}
	//-----------_ignore_early_media
	@Column(name = "_ignore_early_media")
	public String get_Ignore_early_media() {
		return _ignore_early_media;
	}

	public void set_Ignore_early_media(String i) {
		this._ignore_early_media = i;
	}

}
