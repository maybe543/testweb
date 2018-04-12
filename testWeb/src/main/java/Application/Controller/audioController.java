package Application.Controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.*;

import javax.sound.sampled.*;
import Application.Dao.audioDao;
import Application.service.audioService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/audio")
public class audioController {

	@Autowired
	audioService audioServ;
	@RequestMapping(method = RequestMethod.GET)
	public JSONObject audio() throws Exception {

		JSONObject jsonresp=audioServ.test();
		
		return jsonresp;
		
	}

	// @RequestMapping(method=RequestMethod.POST)
	// public String api(@RequestBody String s){
	// //j=jsonbean;
	//
	// return s;
	//
	//
	// }

}
