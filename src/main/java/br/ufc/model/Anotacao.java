package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name="anotacao")
public class Anotacao {
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_anotacao")
	private Integer id;
	
	@NotNull 
	@Size(min=2, max=50, message="O tamanho deve ser entre {min} e {max}")
	private String nome;
	
	@NotNull
	@Size(min=5, max=100, message="O tamanho deve ser entre {min} e {max}")
	private String descricao;
	
	private String estado;

//	@Column(name = "usuario_id", nullable = false, insertable = false, updatable = false)
//	private Long usuarioId;
//	
//	@ManyToOne(optional = false)
//	@JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
//	private Usuario usuario;
	
	@ManyToOne
	private Usuario usuario;
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Anotacao (){}
	
	public Anotacao(Integer id){
		this.id = id;
	}
	public Anotacao(Integer id, String nome, String descricao, String estado) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.estado = estado;
	}
	
}
