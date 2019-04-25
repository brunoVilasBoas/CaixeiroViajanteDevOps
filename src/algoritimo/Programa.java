package algoritimo;

public class Programa {

	
	private static CaixeiroViajante caixeiroViajante;
	
	public static void main(String[] args) {
		
		System.out.println("Buscando rota com melhor preço!");
		
		caixeiroViajante = new CaixeiroViajante();
		
		caixeiroViajante.carregarCidades();
		
		caixeiroViajante.carregarCusto();
		
		caixeiroViajante.imprimirCustosDasRotasDoGrafo();
		
		caixeiroViajante.algoritmoGanancioso();
		
		caixeiroViajante.somaDaMelhorPreco();

	}

}
