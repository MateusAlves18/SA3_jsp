package model;

public class Product {
	public Product(String name, int quantidade, double valor, String linkImg) {
		
		this.name = name;
		this.quantidade = quantidade;
		this.valor = valor;
		this.linkImg = linkImg;
	}
	public Product() {
	}
	private int idProduto;
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getLinkImg() {
		return linkImg;
	}
	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
	private String name;
	private int quantidade;
	private double valor;
	private String linkImg;

}
