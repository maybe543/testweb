package Application.Controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Application.service.dialplanService;

@RestController
@RequestMapping("/dial")
public class dialplanController {

	@Autowired
	dialplanService dps;

	@RequestMapping(method = RequestMethod.GET)
	public String api() throws ParseException {

		dps.dialplan1();
		return "begin to dial";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String del() throws ParseException {

		dps.del();
		return "del number";

	}
}
