package com.portafolio.contactos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.portafolio.contactos.entities.Libreta;
import com.portafolio.contactos.repository.LibretaRepository;

@Controller
public class LibretaController {

	@Autowired
	LibretaRepository libretaRepository;

	@GetMapping("/contactos")
	public String listarContactos(Model model) {
		List<Libreta> listaContactos = libretaRepository.findAll();
		model.addAttribute("contactos", listaContactos);
		return "contactos";
	}

	@GetMapping("/contactos/nuevo")
	public String formContacto(Model model) {
		Libreta contacto = new Libreta();
		model.addAttribute("contacto", contacto);
		return "FormContacto";
	}

	@PostMapping("/contactos")
	public String GuardaContacto(Libreta contacto) {

		libretaRepository.save(contacto);
		return "redirect:/contactos";
	}

	@GetMapping("/contactos/{id}")
	public String FormUpdateContacto(@PathVariable Long id, Model model) {
		Libreta contactoActualizar = libretaRepository.findById(id).get();
		model.addAttribute("contacto", contactoActualizar);		
		return "Actualizar_Contacto";
		
	}
	
	@PostMapping("/contactos/actualizar")
	public String ActualizarContacto(Libreta contacto) {

		libretaRepository.save(contacto);
		return "redirect:/contactos";
	}

	@GetMapping("/contactos/borrar/{id}")
	public String BorrarContacto(@PathVariable Long id) {
		libretaRepository.deleteById(id);
		return "redirect:/contactos";
		
	}
	
}
