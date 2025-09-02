package in.anubhav.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.anubhav.entity.Result;
import in.anubhav.service.IResultService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private IResultService resultsrcv;

	@PostMapping("/saving-data")
	public String data(@RequestBody Result result) {
		System.out.println("reslut data rcv is ::" + result);
		// resultsrcv.save(result);
		resultsrcv.saveUser(result);
		return "success";

	}

	@GetMapping("/test")
	public String data() {

		return "success";

	}

}
