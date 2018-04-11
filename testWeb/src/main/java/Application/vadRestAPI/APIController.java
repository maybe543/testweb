package Application.vadRestAPI;

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

import Application.Dao.LogDao;
import Application.service.smartService;


@RestController
@RequestMapping("/api")
public class APIController {
	@Resource
	smartService smts;

	


	@RequestMapping(method=RequestMethod.POST)
    public String api(@RequestBody  String s){
		
		JSONObject smart=JSON.parseObject(s);
		System.out.println(smart);
		System.out.println("begin to send to respondse");
				
		return JSON.toJSONString(smts.responseToSmartivr(smart));
        
       
    }
	
//	@RequestMapping(method=RequestMethod.POST)
//    public String api(@RequestBody  String s){
//		//j=jsonbean;
//		
//		return s;
//        
//       
//    }
	@RequestMapping(method=RequestMethod.GET)
    public String api(){
	
		
        return "hhh";
       
    }
	

	// public static void main(String[] args) {
	// SpringApplication.run(testController.class, args);
	// }

}
