package app.hospital.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.hospital.entity.Values;

@RestController
@RequestMapping(path = "/test")
public class TestController {
	
	@Value("${val.label.one}")
	public String value;
	
	@Value("${val.label.two}")
	public String value2;
	
	@Value("Welcome to Ooty")
	public String value3;
	
	@Value("${val.list}")
	public List<String> values;
	
	@Value("${val.label.two : default value}")
	public String defaultValue;
	
	@Value("#{${val.db.values}}")
	public Map<String, String> db;
	
	private Values val;
	
	@Autowired
	public TestController(Values val) {
		this.val = val;
	}
	
	@GetMapping(path = "/value")
	public String functionCheck() {
		return value;
	}
	
	@GetMapping(path = "/value2")
	public String functionCheck2() {
		return value2;
	}
	
	@GetMapping(path = "/value3")
	public String functionCheck3() {
		return value3;
	}
	
	@GetMapping(path = "/list")
	public List<String> values() {
		return values;
	}
	
	@GetMapping(path = "/default")
	public String functionDefault() {
		return defaultValue;
	}

	@GetMapping(path = "/db")
	public Map<String, String> db() {
		return db;
	}
	
	@GetMapping(path = "/conf")
	public String configurationProperties() {
		return "" + val.getData() + val.getInfo() + val.getNumber();
	}
}
