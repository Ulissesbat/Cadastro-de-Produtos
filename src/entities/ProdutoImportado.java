package entities;

public class ProdutoImportado extends Produto {

	private double taxaCusto;

	public ProdutoImportado() {
		super();

	}

	public ProdutoImportado(String nome, double preco, double taxaCusto) {
		super(nome, preco);
		this.taxaCusto = taxaCusto;
	}

	public double getTaxaCusto() {
		return taxaCusto;
	}

	public void setTaxaCusto(double taxaCusto) {
		this.taxaCusto = taxaCusto;
	}
	

	public double precoTotal() {
		return getPreco() + taxaCusto;
	}
	
	@Override
	public String etiquetaPreco() {
		return getNome() 
				+ " R$ " 
				+ String.format("%.2f", precoTotal())
				+ " (taxa de custos: R$ " 
				+ String.format("%.2f", taxaCusto)
				+ ")";
				

	}

}
