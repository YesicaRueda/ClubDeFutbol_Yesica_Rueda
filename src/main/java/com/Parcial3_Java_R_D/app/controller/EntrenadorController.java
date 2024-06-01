package com.Parcial3_Java_R_D.app.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import com.Parcial3_Java_R_D.app.Services.InterfaceEntrenadorService;
import com.Parcial3_Java_R_D.app.entidades.*;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("entrenador")
public class EntrenadorController {

	@Autowired
	private InterfaceEntrenadorService entrenadorservice;

	@GetMapping("/formEntrenador")
	public String llamarfEntrenador(Map<String, Object> model) {
		Entrenador entrenador = new Entrenador();
		model.put("entrenador", entrenador);
		return "formEntrenador";
	}

	@PostMapping("/formEntrenador")
	public String guardarEntrenador(@Valid Entrenador entrenador, BindingResult result, Model model,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "formEntrenador";
		}

		entrenadorservice.save(entrenador);
		status.setComplete();
		return "redirect:/listarEntrenador";
	}

	@GetMapping("/listarEntrenador")
	public String mostrarlistarEntrenador(Model model) {
		model.addAttribute("entrenador", entrenadorservice.findAll());
		return "listarEntrenador";
	}

	@GetMapping("/eliminarEntrenador/{id}")
	public String borrarEntrenador(@PathVariable("id") Long id) {
		if (id > 0) {
			entrenadorservice.delete(id);
		}
		return "redirect:/listarEntrenador";
	}

	@GetMapping("formEntrenador/{id}")
	public String editarEntrenador(@PathVariable("id") Long id, Map<String, Object> model) {
		Entrenador entrenador = null;
		if (id > 0) {
			entrenador = entrenadorservice.findOne(id);
		} else {
			return "redirect:/listarEntrenador";
		}
		model.put("entrenador", entrenador);
		return "formEntrenador";
	}

}
