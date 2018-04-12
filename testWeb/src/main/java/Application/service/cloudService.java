package Application.service;

import Application.Dao.LogDao;
import Application.entity.*;
import Application.App;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class cloudService {
	
	//拨打号码，拨打情况反馈时常，对话文字，语音；
	public dialplanRespond getDilaplanFromCloud(dialplan dp) {
		dialplanRespond dpRes= new dialplanRespond();
		
		//第一步：分配线路，dp，将任务分成1，2，3.。。。分别建立task。dialine（1，2，3.。。)
		
		
		
		return dpRes;
	}
	
	//代理信息 帐号 线路；
	
	//拨打设置，时间点，工作日，节假日，；
	
	//话术，json
}
