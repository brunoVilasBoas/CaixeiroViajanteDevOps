package algoritimo;

public class Cidade {
	
	private Integer id;
	
	private String nome;
	
	private boolean visita;
	
	
	public Cidade(Integer id, String nome, boolean visita) {
		super();
		this.id = id;
		this.nome = nome;
		this.visita = visita;
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
	
	public boolean isVisita() {
		return visita;
	}
	
	public void setVisita(boolean visita) {
		this.visita = visita;
	}
	
	
}
