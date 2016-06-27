package mapreduce;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EstacoesPais {

	public static EstacoesPais getInstance()
    {
    return instance;
    }

 /**
  * singleton instance
  * created when class is loaded.
  */
	private static EstacoesPais instance = new EstacoesPais();

 /**
  * private constructor, prevents direct instantiation of this class.
  */
	private EstacoesPais()
    {
    }
	
	private static List<String> listaEstacoes = new LinkedList<String>();
	
	public static void criaListaEstacoes(String caminho, String pais) throws FileNotFoundException{
		if(!pais.equals("ZZ"))
		{
			File f = new File(caminho +"/Paises/"+pais+".txt");
			Scanner scan = new Scanner(f);
			while(scan.hasNext()){
				listaEstacoes.add(scan.next());
			}
			scan.close();
		}
		
		
	}
	
	public static List<String> getLista()
	{
		return listaEstacoes;
	}
	
	public static boolean encontraNaLista(String estacao)
	{
		for(int i = 0; i < listaEstacoes.size(); i++)
		{
			if(listaEstacoes.get(i).equals(estacao))
				return true;
		}
		return false;
	}
}