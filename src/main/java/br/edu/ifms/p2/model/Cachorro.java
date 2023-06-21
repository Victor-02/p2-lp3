package br.edu.ifms.p2.model;

public class Cachorro {

	private String raca;
	private int tamanho;
	private int idade;
	private long id;
	
	public Cachorro(String raca, int tamanho, int idade) {
		this.raca = raca;
		this.tamanho = tamanho;
		this.idade = idade;
	}
	
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
