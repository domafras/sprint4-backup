package com.compassouol.sprint4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class GuideController {

	@RequestMapping("/")
	@ResponseBody
	public String guide() {
		return "Endpoints:"
				+ " /auth,"
				+ " /actuator/**,"
				+ " /pessoa/**,"
				+ " /protected/produto/**,"
				+ " /protected/pedido/**;";
	}
}
