package com.Parcial3_Java_R_D.app.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import com.Parcial3_Java_R_D.app.Services.InterfaceCompeticionService;
import com.Parcial3_Java_R_D.app.entidades.*;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("competicion")
public class CompeticionController {

	@Autowired
	private InterfaceCompeticionService competicionservice;


	@GetMapping("/formCompeticion")
	public String llamarfCompeticion(Map<String, Object> model) {
		Competicion competicion = new Competicion();
		model.put("competicion", competicion);
		return "formCompeticion";
	}

	@PostMapping("/formCompeticion")
	public String guardarCompeticion(@Valid Competicion competicion, BindingResult result, Model model,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "formCompeticion";
		}

		competicionservice.save(competicion);
		status.setComplete();
		return "redirect:/listarCompeticion";
	}

	@GetMapping("/listarCompeticion")
	public String mostrarlistarCompeticion(Model model) {
		model.addAttribute("competicion", competicionservice.findAll());
		return "listarCompeticion";
	}

	@GetMapping("/eliminarCompeticion/{id}")
	public String borrarCompeticion(@PathVariable("id") Long id) {
		if (id > 0) {
			competicionservice.delete(id);
		}
		return "redirect:/listarCompeticion";
	}

	@GetMapping("formCompeticion/{id}")
	public String editarCompeticion(@PathVariable("id") Long id, Map<String, Object> model) {
		Competicion competicion = null;
		if (id > 0) {
			competicion = competicionservice.findOne(id);
		} else {
			return "redirect:/listarCompeticion";
		}
		model.put("competicion", competicion);
		return "formCompeticion";
	}

}
