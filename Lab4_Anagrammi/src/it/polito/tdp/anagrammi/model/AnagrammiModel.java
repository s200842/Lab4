package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Parola;

public class AnagrammiModel {
	
	private Parola parola;
	
	public List<String> creaAnagrammi(String parola){
		this.parola = new Parola(parola);
		List<Character> poolLettere = this.parola.getLettere();
		List<Character> copiaPool = new ArrayList<Character>(poolLettere);
		List<Character> parolaAttuale = new ArrayList<Character>();
		List<List<Character>> tutte = new ArrayList<List<Character>>();
		
		anagramma(copiaPool, poolLettere, parolaAttuale, 0, tutte, this.parola.size());
		
		return convertitore(tutte);
	}

	//Algoritmo ricorsivo per la creazione di anagrammi
	public void anagramma(List<Character> copiaPool, List<Character> poolLettere, List<Character> parolaAttuale, int passo, List<List<Character>> tutte, int lunghezza){
		//Condizione di uscita: lunghezza anagramma = lunghezza parola
		if(passo == lunghezza){
			//Evito doppioni con if
			if(tutte.contains(parolaAttuale)==false){
				tutte.add(new ArrayList<>(parolaAttuale));
			}
			
		}
		else{
			for(int posizione=0; posizione<lunghezza; posizione++){
				//Controllo se ho inserito la lettera in questione tante volte quante sono le sue occorrenze
				if(contaOccorrenze(poolLettere.get(posizione), copiaPool)!= contaOccorrenze(poolLettere.get(posizione), parolaAttuale)){
					//Uso come prima lettera la lettera in pos "posizione"
					parolaAttuale.add(poolLettere.get(posizione));
					//Passo successivo con un pool lettere minore
					anagramma(copiaPool, poolLettere, parolaAttuale, passo+1, tutte, lunghezza);
					//Tolgo l'ultima lettera aggiunta per fare i tentativi successivi
					parolaAttuale.remove(parolaAttuale.size()-1);
				}
			}
		}
	}
	
	//Trasforma la lista di Caratteri in Stringhe
	public List<String> convertitore(List<List<Character>> listaLettere){
		String parola = "";
		ArrayList<String> parole = new ArrayList<String>();
		for(List<Character> lc : listaLettere){
			for(Character c : lc){
				parola +=c;
			}
			parole.add(parola);
			parola = "";
		}
		return parole;
	}
	
	//Conta le occorrenze delle lettere in una lista di caratteri
	public int contaOccorrenze(Character c, List<Character> list){
		int conta = 0;
		for(int i=0; i<list.size(); i++){
			if(c == list.get(i)){
				conta ++;
			}
		}
		return conta;
	}
}
