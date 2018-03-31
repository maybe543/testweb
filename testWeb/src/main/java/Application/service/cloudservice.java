package Application.service;

import Application.Dao.LogDao;
import Application.entity.*;
import Application.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class cloudservice {
	@Autowired
	private LogDao logdao;

	public void insertOne(String uuid, String content) {

		autodialer_log al = new autodialer_log();
		al.setContent(content);
		logdao.save(al);

	}

	public autodialer_log reOne(String uuid) {
		System.out.println(uuid + "************");
		System.out.println(logdao.exists(uuid));
		return this.logdao.getOne(uuid);
	}

//	public static void main(String[] args) {
//		SpringApplication.run(cloudservice.class, args);
//	}

}
