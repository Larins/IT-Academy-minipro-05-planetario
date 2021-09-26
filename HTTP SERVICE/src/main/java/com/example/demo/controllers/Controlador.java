package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.Planeta;
import com.example.demo.bean.Usuario;
import com.example.demo.repository.BaseDatosService;

@Controller // Lo convertimos en un servlet que atiende peticiones HTTP
@RequestMapping("") // localhost:8080
public class Controlador {

	@GetMapping("/")
	public String iniciar(Model model) {
		model.addAttribute("titulo", "FORMULARIO DE ACCESO");
		model.addAttribute("info1", "Introduce los datos de acceso:");
		return "login";
	}

	Usuario usuario;

	@Autowired
	BaseDatosService bd;

	// HANDLER LOGIN
	@PostMapping("/")
	public String login(Usuario usuario, Model model) {
		if (bd.compruebaUsuario(usuario.getNombre(), usuario.getPassword())) {
			ArrayList<Planeta> planetas = bd.getPlanetas();
			model.addAttribute("usuario", usuario);
			this.usuario = usuario;
			model.addAttribute("planetas", planetas);
			model.addAttribute("planeta", new Planeta(0,"",0,0,0,0,0,0));
			model.addAttribute("boton", "Insertar planeta");
			model.addAttribute("action", "/insertar");
			return "consulta";
		} else
			model.addAttribute("titulo", "FORMULARIO DE ACCESO");
		return "login";
	}

	// HANDLER INSERCION
	@PostMapping("/insertar")
	public String insertar(Planeta planeta, Model model) {
		bd.inserta(planeta);
		ArrayList<Planeta> planetas = bd.getPlanetas();
		model.addAttribute("usuario", this.usuario);
		this.usuario = usuario;
		model.addAttribute("planetas", planetas);
		model.addAttribute("planeta", new Planeta(0,"",0,0,0,0,0,0));
		model.addAttribute("boton", "Insertar planeta");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}

	// Handler borrado
	@GetMapping("/borrado/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Planeta> planetas = bd.getPlanetas();
		model.addAttribute("usuario", this.usuario);
		this.usuario = usuario;
		model.addAttribute("planetas", planetas);
		model.addAttribute("planeta", new Planeta(0,"",0,0,0,0,0,0));
		model.addAttribute("boton", "Insertar planeta");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}

	// Handler modificar GET (rellenar formulario)
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Planeta planeta = bd.getPlaneta(id);
		ArrayList<Planeta> planetas = bd.getPlanetas();
		model.addAttribute("usuario", this.usuario);
		this.usuario = usuario;
		model.addAttribute("planetas", planetas);
		model.addAttribute("planeta", planeta);
		model.addAttribute("boton", "Actualizar planeta");
		model.addAttribute("action", "/modificar");
		return "consulta";
	}

	// Handler modificar POST (enviar formulario)
	@PostMapping("/modificar")
	public String modificar2(Planeta planeta, Model model) {
		bd.modifica(planeta);
		ArrayList<Planeta> planetas = bd.getPlanetas();
		model.addAttribute("usuario", this.usuario);
		// this.usuario = usuario;
		model.addAttribute("planetas", planetas);
		model.addAttribute("planeta", new Planeta(0,"",0,0,0,0,0,0));
		model.addAttribute("boton", "Actualizar planeta");
		model.addAttribute("action", "/insertar");
		return "consulta";
	}
}