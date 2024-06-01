package com.Parcial3_Java_R_D.app.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import com.Parcial3_Java_R_D.app.Services.InterfaceAsociacionService;
import com.Parcial3_Java_R_D.app.entidades.*;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("asociacion")
public class AsociacionController {

	@Autowired
	private InterfaceAsociacionService asociacionservice;

	@GetMapping("/formAsociacion")
	public String llamarfAsociacion(Map<String, Object> model) {
		Asociacion asociacion = new Asociacion();
		model.put("asociacion", asociacion);
		return "formAsociacion";
	}

	@PostMapping("/formAsociacion")
	public String guardarAsociacion(@Valid Asociacion asociacion, BindingResult result, Model model,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "formAsociacion";
		}

		asociacionservice.save(asociacion);
		status.setComplete();
		return "redirect:/listarAsociacion";
	}

	@GetMapping("/listarAsociacion")
	public String mostrarlistarAsociacion(Model model) {
		model.addAttribute("asociacion", asociacionservice.findAll());
		return "listarAsociacion";
	}

	@GetMapping("/eliminarAsociacion/{id}")
	public String borrarAsociacion(@PathVariable("id") Long id) {
		if (id > 0) {
			asociacionservice.delete(id);
		}
		return "redirect:/listarAsociacion";
	}

	@GetMapping("formAsociacion/{id}")
	public String editarAsociacion(@PathVariable("id") Long id, Map<String, Object> model) {
		Asociacion asociacion = null;
		if (id > 0) {
			asociacion = asociacionservice.findOne(id);
		} else {
			return "redirect:/listarAsociacion";
		}
		model.put("asociacion", asociacion);
		return "formAsociacion";
	}

}
