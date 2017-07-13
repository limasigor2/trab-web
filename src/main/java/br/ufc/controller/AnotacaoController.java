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

import br.ufc.dao.AnotacaoDao;
import br.ufc.model.Anotacao;

@Controller
public class AnotacaoController {
	
	@Autowired
	private AnotacaoDao anotacaoDao;
	
	@GetMapping("/anotacoes")
	public String listaAnotacoes(Model model){
		List<Anotacao> lista = anotacaoDao.getList();
		model.addAttribute("anotacoes", lista);
		return "lista_anotacao";
	}
	@GetMapping("/anotacoes/add")
	public String insereForm(Model model){
		model.addAttribute("anotacao", new Anotacao());
		return "insere_anotacao";
	}
	@GetMapping("/anotacoes/{id}/update")
	public String alteraForm(@PathVariable Integer id, Model model){
		Anotacao a = anotacaoDao.getAnotacao(id);
		model.addAttribute("anotacao", a);
		return "altera_anotacao";
	}
	@PostMapping("/anotacoes")
	public String addAnotacao(@Valid Anotacao anotacao, BindingResult result,
			Model model, RedirectAttributes redirectAtribures){
		if(result.hasErrors()){
			model.addAttribute("anotacao", anotacao);
			if(anotacao.getId() == null)
				return "insere_anotacao";
			else
				return "altera_anotacao";
		}
		if(anotacao.getId() == null){
			anotacaoDao.insereAnotacao(anotacao);
			redirectAtribures.addFlashAttribute("msg", "Anotacao inserida com sucesso");	
		}
		else{
			anotacaoDao.alteraAnotacao(anotacao);
			redirectAtribures.addFlashAttribute("msg", "Anotacao atualizada com sucesso");
		}
		return "redirect:/anotacoes";
	}
	@GetMapping("/anotacoes/{id}/delete")
	public String deleteAnotacao(@PathVariable Integer id, RedirectAttributes redirectAttributes){
		Anotacao anotacao = new Anotacao(id);
		anotacaoDao.removeAnotacao(anotacao);
		redirectAttributes.addFlashAttribute("msg", "Anotacao excluida com sucesso");
		return "redirect:/anotacoes";
	}
}
