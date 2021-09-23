package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PlanetasDAO;
import com.example.demo.models.Planeta;


@RestController //Esta clase va a ser un servicio REST
@RequestMapping("/planetarium") //En esta URL se van a exponer los servicios de esta clase
//URL: http://localhost:8080/planetarium (ESTA URL NO DA INFORMACIÓN PERO SIRVE DE BASE PARA LAS CONSULTAS)
public class ControllerRest {

	@Autowired //Inyección de dependencias
	private PlanetasDAO planetasDAO;

	//METODOS CRUD PARA CONSULTAR LOS PLANETAS
	
	@GetMapping("planetas") //planetas GET todos
	//URL: http://localhost:8080/planetarium/planetas/
	public ResponseEntity<List<Planeta>> getPlanetas() {
		List<Planeta> planetas = planetasDAO.findAll();
		return ResponseEntity.ok(planetas);
	}
	
	@RequestMapping(value="planetas/{planetaId}")  //planetas GET por ID
	//URL: http://localhost:8080/planetarium/planetas/1
	public ResponseEntity<Planeta> getPlanetaById(@PathVariable("planetaId") Long planetaId) {
		Optional<Planeta> optionalPlaneta = planetasDAO.findById(planetaId);
		if (optionalPlaneta.isPresent()) {
			return ResponseEntity.ok(optionalPlaneta.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("planetas") //planetas POST (insertar nuevo planeta)
	public ResponseEntity<Planeta> crearPlaneta(@RequestBody Planeta planeta) {
		Planeta newPlaneta = planetasDAO.save(planeta);
		return ResponseEntity.ok(newPlaneta);
	}
	
	@PutMapping("planetas") //planetas PUT (modificar planeta existente)
	public ResponseEntity<Planeta> updatePlaneta(@RequestBody Planeta planeta) {
		Optional <Planeta> optionalPlaneta = planetasDAO.findById(planeta.getId());
		if (optionalPlaneta.isPresent()) {
			Planeta updatePlaneta = optionalPlaneta.get();
			updatePlaneta.setName(planeta.getName());
			planetasDAO.save(updatePlaneta);
			return ResponseEntity.ok(updatePlaneta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="planetas/{planetaId}") //planetas DELETE (eliminar planeta existente)
	public ResponseEntity<Void> deletePlanetas(@PathVariable("planetaId") Long planetaId) {
		planetasDAO.deleteById(planetaId);
		return ResponseEntity.ok(null);
	}
}

