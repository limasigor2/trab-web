package br.ufc.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="usuario") 
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull 
	@Size(min=2, max=50, message="O tamanho deve ser entre {min} e {max}")
	private String nome;
	
	@NotNull
	@Size(min=5, max=100, message="O tamanho deve ser entre {min} e {max}")
	private String login;
	
	private String senha;
	
	/*Relacionamento de Usuario com Postagem*/
	//@OneToMany(mappedBy = "usuario", targetEntity = Anotacao.class, fetch = FetchType.LAZY)
	//private List<Anotacao> anotacoes;

	public Usuario() {}
	
	public Usuario(Integer id) {
		this.id = id;

	}
	
	public Usuario(Integer id, String nome, String login, String senha) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}