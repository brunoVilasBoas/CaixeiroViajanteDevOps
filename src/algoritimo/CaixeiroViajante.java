package algoritimo;

import java.util.ArrayList;

public class CaixeiroViajante {
	
	
	private ArrayList<Cidade> cidades;
	
	private Integer[][] custos;

	private int numeroCidades;
	
	public int[] precos; 
	
    private boolean[] visitas;
    
    private int contadorParaChecar;
    
    private int contadorParaPreco;
	
	
    public CaixeiroViajante() {
		
		numeroCidades = 5;
		cidades = new ArrayList<Cidade>();
		custos = new Integer[numeroCidades][numeroCidades];
		
		precos = new int[numeroCidades];
        visitas = new boolean[numeroCidades];
        contadorParaPreco = 0;
        contadorParaChecar = 0;
		
		
		
	}
	
	public void algoritmoGanancioso() {
		
        for (int v = 0; v < numeroCidades; v++) visitas[v] = false;

        for (int i = 0; i < numeroCidades;) {
            
        	if (!visitas[i]) {
                i = buscaMenorPeso(i);
            }
        	
            else if (visitas[i] && i != numeroCidades) {
                
            	if(checarVisitas()) {
                    ++i;
                } else {
                    int j = 0;
                    for (boolean value : visitas) {
                        if(!value)
                            i = j;

                        j++;
                    }
                }
            }
        }
    }
	
	public boolean checarVisitas() {
		
        for (contadorParaChecar = 0; contadorParaChecar < numeroCidades; contadorParaChecar++) {
            if (!visitas[contadorParaChecar]) {
                return false;
            }
        }    
        return true;
    }
	
	public int buscaMenorPeso(int i) {
        int valor = 0;
        
        int temp = 10000;

        if (i == contadorParaChecar && !checarVisitas()) {
            
        	visitas[i] = true;

            if (checarVisitas()) {
            
            	precos[contadorParaPreco] = custos[i][0];
                visitas[i] = true;
                System.out.println(cidades.get(i).getNome() + " -> " + cidades.get(0).getNome());
                return valor = numeroCidades - 1; 
            } else {
                
            	visitas[i] = false;
            }
        }

        for (int j = 1; j < numeroCidades; j++) {
        	
            if (custos[i][j] < temp && i != j && !visitas[j]) {
                temp = custos[i][j];
                precos[contadorParaPreco] = custos[i][j];
                valor = j;
                
                
            } else if (i == j && i != numeroCidades - 1) {
            
            	if (i != 0 && i != numeroCidades - 1 && j != numeroCidades - 1) {
            		
                    continue;
                }
            
            } else if (i == j && i == numeroCidades - 1 && j == numeroCidades - 1){
            	
                if (checarVisitas()) {
                	
                	precos[contadorParaPreco] = custos[j][0];
                    visitas[i] = true;
                    System.out.print(cidades.get(i).getNome() + " -> ");
                    return valor = numeroCidades - 1;
                
                } else {
                	
                    visitas[i] = true;
                    ++contadorParaPreco;
                    System.out.print(cidades.get(i).getNome() + " -> ");
                    return contadorParaPreco;
                }
            
            } else if (i == j && i == numeroCidades - 1 && j != numeroCidades - 1 && !visitas[j]) {
            	
                continue;
            }
        }

        visitas[i] = true;
        ++contadorParaPreco;
        
        System.out.print(cidades.get(i).getNome() + " -> ");
        return valor;
    }
	
	public void somaDaMelhorPreco() {
        
		int soma = 0;
        int ultimoPreco = precos.length - 1;
        
        for (int i = 0; i < ultimoPreco; i++) {
        	System.out.print(precos[i] + " + ");
            soma += precos[i];
        }
        
        soma += precos[ultimoPreco];
        System.out.println(precos[ultimoPreco] + " = " + soma);
    }
	
	public void imprimirCustosDasRotasDoGrafo() {
        
		for (int i = 0; i < numeroCidades; i++) {
			System.out.println("Partindo da Cidade: " + cidades.get(i).getNome());
            for (int j = 0; j < numeroCidades; j++) {
            	System.out.println(cidades.get(i).getNome() + " -> " + cidades.get(j).getNome() + " = " + custos[i][j]);
            }

            
        }
    }
	
	public void carregarCusto() {
		
		custos[0][0] = 0; 	// A-A
		custos[0][1] = 185; // A-B 
		custos[0][2] = 119; // A-C
		custos[0][3] = 152; // A-D
		custos[0][4] = 133; // A-E
		
		custos[1][0] = 185;	// B-A
		custos[1][1] = 0; 	// B-B 
		custos[1][2] = 121; // B-C
		custos[1][3] = 150; // B-D
		custos[1][4] = 200; // B-E
		
		custos[2][0] = 119; // C-A
		custos[2][1] = 121; // C-B
		custos[2][2] = 0;	// C-C
		custos[2][3] = 174; // C-D
		custos[2][4] = 120; // C-E
		
		custos[3][0] = 152; // D-A
		custos[3][1] = 150; // D-B
		custos[3][2] = 174; // D-C
		custos[3][3] = 0; 	// D-D
		custos[3][4] = 199; // D-E
		
		custos[4][0] = 133; // E-A
		custos[4][1] = 200; // E-B
		custos[4][2] = 120; // E-C
		custos[4][3] = 199; // E-D
		custos[4][4] = 0; 	// E-E
		
	}
	
	public void carregarCidades() {
		
		cidades.add(new Cidade(0,"A", false));
		cidades.add(new Cidade(1,"B", false));
		cidades.add(new Cidade(2,"C", false));
		cidades.add(new Cidade(3,"D", false));
		cidades.add(new Cidade(4,"E", false));	
	}

	public int getPrecos(int i) {
		return precos[i];
	}

	public void setPrecos(int[] precos) {
		this.precos = precos;
	}

	public Integer[][] getCustos() {
		return custos;
	}

	public void setCustos(Integer[][] custos) {
		this.custos = custos;
	}
	
	

}
