package com.compassouol.sprint4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuideController {

	@RequestMapping("/")
	@ResponseBody
	public String guide() {
		return "Endpoints:"
				+ "/pessoa "
				+ "/produto "
				+ "/pedido";
	}
}
