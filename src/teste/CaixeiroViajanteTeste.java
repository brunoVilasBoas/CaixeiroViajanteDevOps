package teste;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import algoritimo.CaixeiroViajante;

public class CaixeiroViajanteTeste {

    /**
     * Teste rigoroso
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void TesteExercicioMarco(){
        
    	CaixeiroViajante caixeiroViajante = new CaixeiroViajante();
    	
    	caixeiroViajante.carregarCidades();
    	Integer[][] custosTest = new Integer[5][5];
    	
    	custosTest[0][0] = 0; 	// A-A
    	custosTest[0][1] = 185; // A-B 
    	custosTest[0][2] = 119; // A-C
    	custosTest[0][3] = 152; // A-D
    	custosTest[0][4] = 133; // A-E
		
    	custosTest[1][0] = 185;	// B-A
    	custosTest[1][1] = 0; 	// B-B 
    	custosTest[1][2] = 121; // B-C
    	custosTest[1][3] = 150; // B-D
    	custosTest[1][4] = 200; // B-E
		
    	custosTest[2][0] = 119; // C-A
    	custosTest[2][1] = 121; // C-B
    	custosTest[2][2] = 0;	// C-C
    	custosTest[2][3] = 174; // C-D
    	custosTest[2][4] = 120; // C-E
		
    	custosTest[3][0] = 152; // D-A
    	custosTest[3][1] = 150; // D-B
    	custosTest[3][2] = 174; // D-C
    	custosTest[3][3] = 0; 	// D-D
    	custosTest[3][4] = 199; // D-E
		
    	custosTest[4][0] = 133; // E-A
    	custosTest[4][1] = 200; // E-B
    	custosTest[4][2] = 120; // E-C
    	custosTest[4][3] = 199; // E-D
    	custosTest[4][4] = 0; 	// E-E
    	
    	caixeiroViajante.setCustos(custosTest);

        caixeiroViajante.algoritmoGanancioso();

        Assert.assertTrue("Resultado A -> C = 119", caixeiroViajante.getPrecos(0) == 119);
        Assert.assertTrue("Resultado C -> E = 120", caixeiroViajante.getPrecos(1) == 120);
        Assert.assertTrue("Resultado E -> D = 199", caixeiroViajante.getPrecos(2) == 199);
        Assert.assertTrue("Resultado D -> B = 150", caixeiroViajante.getPrecos(3) == 150);
        Assert.assertTrue("Resultado B -> A = 185", caixeiroViajante.getPrecos(4) == 185);

    }
    
    @Test
    public void Teste2(){
        
    	CaixeiroViajante caixeiroViajante = new CaixeiroViajante();
    	
    	caixeiroViajante.carregarCidades();
    	Integer[][] custosTest = new Integer[5][5];

    	custosTest[0][0] = 0; 	// A-A
    	custosTest[0][1] = 185; // A-B 
    	custosTest[0][2] = 119; // A-C
    	custosTest[0][3] = 152; // A-D
    	custosTest[0][4] = 133; // A-E
		
    	custosTest[1][0] = 185;	// B-A
    	custosTest[1][1] = 0; 	// B-B 
    	custosTest[1][2] = 121; // B-C
    	custosTest[1][3] = 150; // B-D
    	custosTest[1][4] = 200; // B-E
		
    	custosTest[2][0] = 119; // C-A
    	custosTest[2][1] = 121; // C-B
    	custosTest[2][2] = 0;	// C-C
    	custosTest[2][3] = 174; // C-D
    	custosTest[2][4] = 120; // C-E
		
    	custosTest[3][0] = 152; // D-A
    	custosTest[3][1] = 150; // D-B
    	custosTest[3][2] = 174; // D-C
    	custosTest[3][3] = 0; 	// D-D
    	custosTest[3][4] = 199; // D-E
		
    	custosTest[4][0] = 133; // E-A
    	custosTest[4][1] = 200; // E-B
    	custosTest[4][2] = 120; // E-C
    	custosTest[4][3] = 199; // E-D
    	custosTest[4][4] = 0; 	// E-E

    	caixeiroViajante.setCustos(custosTest);
    	
        caixeiroViajante.algoritmoGanancioso();

        Assert.assertTrue("Resultado A -> C = 119", caixeiroViajante.getPrecos(0) == 119);
        Assert.assertTrue("Resultado C -> E = 120", caixeiroViajante.getPrecos(1) == 120);
        Assert.assertTrue("Resultado E -> D = 199", caixeiroViajante.getPrecos(2) == 199);
        Assert.assertTrue("Resultado D -> B = 150", caixeiroViajante.getPrecos(3) == 150);
        Assert.assertTrue("Resultado B -> A = 185", caixeiroViajante.getPrecos(4) == 185);

    }
    
}
