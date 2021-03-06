package entidades;

public abstract class ContribuenteEntidade {
	
	private String nome;
	protected Double rendaAnual;
	
	public ContribuenteEntidade() {
	}
	
	public ContribuenteEntidade(String nome, double rendaAnual) {
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}
	
	public abstract Double calcImposto();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}
	
	
	
	

}
