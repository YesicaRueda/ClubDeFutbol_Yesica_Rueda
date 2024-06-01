package com.Parcial3_Java_R_D.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.*;
import com.Parcial3_Java_R_D.app.Services.InterfaceClubService;
import com.Parcial3_Java_R_D.app.entidades.*;


import jakarta.validation.Valid;

@Controller
@SessionAttributes("club")
public class ClubController {

	@Autowired
	private InterfaceClubService clubservice;

	@GetMapping("/formClub")
	public String llamarfclub(Map<String, Object> model) {
		Club Club = new Club();
		model.put("club", Club);
		return "formClub";
	}
	@PostMapping("/formClub")
	public String guardarClub(@Valid Club Club, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			return "formClub";
		}

		clubservice.save(Club);
		status.setComplete();
		return "redirect:/listarclub";
	}

	@GetMapping("/listarclub")
	public String mostrarlistarClub(Model model) {
		model.addAttribute("club", clubservice.findAll());
		return "listarclub";
	}

	@GetMapping("/eliminarclub/{id}")
	public String borrarClub(@PathVariable("id") Long id) {
		if (id > 0) {
			clubservice.delete(id);
		}
		return "redirect:/listarclub";
	}

	@GetMapping("/formClub/{id}")
	public String editarClub(@PathVariable("id") Long id, Map<String, Object> model) {
		Club Club = null;
		if (id > 0) {
			Club = clubservice.findOne(id);
		} else {
			return "redirect:/listarclub";
		}
		model.put("club", Club);
		return "formClub";
	}

}