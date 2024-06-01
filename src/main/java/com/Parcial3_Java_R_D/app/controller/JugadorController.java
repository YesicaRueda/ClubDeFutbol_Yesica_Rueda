package com.Parcial3_Java_R_D.app.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import com.Parcial3_Java_R_D.app.Services.InterfaceJugadorService;
import com.Parcial3_Java_R_D.app.entidades.*;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("jugador")
public class JugadorController {
	@Autowired
	private InterfaceJugadorService jugadorservice;


	@GetMapping("/formJugador")
	public String llamarfJugador(Map<String, Object> model) {
		Jugador jugador = new Jugador();
		model.put("jugador", jugador);
		return "formJugador";
	}

	@PostMapping("/formJugador")
	public String guardarJugador(@Valid Jugador jugador, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			return "formJugador";
		}

		jugadorservice.save(jugador);
		status.setComplete();
		return "redirect:/listarJugador";
	}

	@GetMapping("/listarJugador")
	public String mostrarlistarJugador(Model model) {
		model.addAttribute("jugador", jugadorservice.findAll());
		return "listarJugador";
	}

	@GetMapping("/eliminarJugador/{id}")
	public String borrarJugador(@PathVariable("id") Long id) {
		if (id > 0) {
			jugadorservice.delete(id);
		}
		return "redirect:/listarJugador";
	}

	@GetMapping("formJugador/{id}")
	public String editarEntrenador(@PathVariable("id") Long id, Map<String, Object> model) {
		Jugador jugador = null;
		if (id > 0) {
			jugador = jugadorservice.findOne(id);
		} else {
			return "redirect:/listarJugador";
		}
		model.put("jugador", jugador);
		return "formJugador";
	}

}