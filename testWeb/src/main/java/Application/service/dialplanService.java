package Application.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import Application.Dao.autodialTaskDao;
import Application.Dao.autodialer_numberDao;
import Application.entity.autodialer_task;

@Service
public class dialplanService {

	@Autowired
	private autodialTaskDao taskdao;
	String uu;
	@Resource
	autodialer_numberDao autodialer_numberdao;
	// 例1：任务名：test，最大并发：100，坐席队列号：7000，电话应答后先进入IVR菜单：7000放音，用户按键后转接坐席，每个空闲坐席同时呼叫10个号码,对接中继:192.168.1.100:5060
	// INSERT INTO
	// autodialer_task(`uuid`,`name`,`create_datetime`,`maximumcall`,`destination_extension`,`destination_dialplan`,`destination_context`,
	// `scheduling_policy_ratio`,`scheduling_queue`,`dial_format`)
	// VALUES
	// (UUID(),'test',NOW(),100,'7000','XML','IVR',10,'7000','sofia/external/%s@192.168.1.100:5060')

	public void dialplan1() throws ParseException {
		autodialer_task adt = new autodialer_task();
		adt.setUuid(UUID.randomUUID().toString());
		adt.setName("wszdialpalntest1");

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(Calendar.getInstance().getTime());
		Date nowDate = df.parse(now);
		adt.setCreate_datetime(nowDate);
		adt.setAlter_datetime(nowDate);
		adt.setMaximumcall(2);
		adt.setDestination_extension("8888");
		adt.setDestination_dialplan("XML");
		adt.setDestination_context("public");
//		adt.setScheduling_policy_ratio(10);
		adt.setScheduling_queue("");
//		adt.setDial_format("sofia/external/%s@192.168.31.180:5060");
		adt.setDial_format("user/goip1");
		adt.set_Origination_caller_id_number("CHINAUNICOM");
		adt.setStart(1);
		uu = adt.getUuid();
		//创建拨号号码表
		autodialer_numberdao.create(uu);
		autodialer_numberdao.importphone(uu);
		taskdao.save(adt);
	}

	public void del() {
		
		autodialer_numberdao.drop(uu);
		if(taskdao.exists(uu))
			taskdao.delete(uu);
	}
}
