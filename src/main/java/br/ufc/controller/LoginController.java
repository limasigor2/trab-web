package br.ufc.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufc.dao.UsuarioDao;
import br.ufc.model.Usuario;
@Controller
public class LoginController{
	@Autowired
	private UsuarioDao usuarioDao;
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(){
		return "login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String verifyLogin(@RequestParam String login,@RequestParam String senha, HttpSession session){
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		if(usuarioDao.existeUsuario(usuario)){
			session.setAttribute("logado", usuario);
			return "redirect:/";
		}
		session.setAttribute("msg_login", "Usuário não encontrado ou senha errada");
		return "login";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		session.setAttribute("msg", "Usuário deslogado");
		return "login";
	}
}