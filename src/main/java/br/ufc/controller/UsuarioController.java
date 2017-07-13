	package br.ufc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.dao.UsuarioDao;
import br.ufc.model.Usuario;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@GetMapping("/usuarios")
	public String listaContatos(Model model) {
		List<Usuario> lista = usuarioDao.getLista();
		model.addAttribute("usuarios", lista);
		return "lista_usuarios";
	}
	
	@GetMapping("/usuarios/add")
	public String insereForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "insere_usuario";
	}
	
	@GetMapping("/usuarios/{id}/update")
	public String alteraForm(@PathVariable Integer id, Model model) {
		Usuario c = usuarioDao.getUsuario(id);
		System.out.println("usuario: " + c);
		model.addAttribute("usuario", c);
		return "altera_usuario";
	}

	@PostMapping("/usuarios")
	public String addContato(@Valid Usuario usuario, BindingResult result, 
			Model model, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			model.addAttribute("usuario", usuario);
			if (usuario.getId() == null) {
				return "insere_usuario";
			} else {
				return "altera_usuario";
			}
		}
		
		if (usuario.getId() == null) {
			usuarioDao.adiciona(usuario);
			redirectAttributes.addFlashAttribute("msg", "Usuario inserido com sucesso.");
		} else {
			usuarioDao.altera(usuario);
			redirectAttributes.addFlashAttribute("msg", "Usuario atualizado com sucesso.");
		}
		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios/{id}/delete")
	public String deleteContato(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		System.out.println("id: " + id);
		Usuario usuario = new Usuario(id);
		System.out.println("usuario: " + usuario);
		usuarioDao.remove(usuario);
		redirectAttributes.addFlashAttribute("msg", "Usuario removido com sucesso.");
		return "redirect:/usuarios";
	}
	
}
