package br.edu.fateczl.lista;

public class Lista {
	
	No primeiro;

	public Lista() {
		primeiro = null; //Inicializamos a LISTA - E, aqui o primeiro aponta para nulo!
	}
	//Teste de LISTA vazia
	public boolean isEmpty(){//Aqui nosso teste mais imediato! Saber se a LISTA � vazia!
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}
	}
	//Tamanho da LISTA
	public int size() {
		int cont = 0; 
		if (!isEmpty()) {
			No auxiliar = primeiro;
			while(auxiliar != null) {
				cont ++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}
	//Retornar No
	private No getNo(int pos) throws Exception {//O m�todo getNo ser� private e n�o public
		//Porque trata-se de uma opera��o auxiliar para a Classe - um m�todo para ajudar outros.
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();//Lembrando aqui para verificar os limites! Testes de Limite!
		if (pos < 0 || pos > tamanho -1) {
			throw new Exception("Posi��o Inv�lida");
		}
		No auxiliar = primeiro;
		int cont = 0;
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return auxiliar;
	}
	
	//INICIANDO AS OPERA��ES
	
	//Adicionar elemento no in�cio
	//Colocando um elemento no in�cio da LISTA
	public void addFirst(int valor) {
		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}
	//Adicionar elemento no fim
	public void addLast (int valor) throws Exception {
		int tamanho = size();
		
		if (isEmpty()) {//Verifica��o para fins concentuais!
			throw new Exception("Lista Vazia");
		}
		
		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = null;
		
		No ultimo = getNo(tamanho - 1);//Aqui � para saber quem � o �ltimo No.
		ultimo.proximo = elemento;
	}
	//Adicionar elemento em qualquer posi��o v�lida 
	public void add(int valor, int posicao) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho) {//Usar o tamanho que permita inserir na �ltima posi��o.
			throw new Exception("Posi��o Inv�lida");
		}
		if (posicao == 0) {//Inserir no in�cio da LISTA.
			addFirst(valor);
		} else if(posicao == tamanho) {//Inserir no final entre o �ltimo e o null.
			addLast(valor);
		} else {//Se n�o for nem um e nem o outro.
			No elemento = new No();
			elemento.dado = valor;//O ponteiro ser� definido pela posi��o.
			No anterior = getNo(posicao - 1);/*O anterior apontar� para o novo e
			o novo apontar� para onde o anterior estava apontando.*/
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}
	//Remover elemento do In�cio
	public void removeFirst() throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		primeiro = primeiro.proximo;
	}
	//Remover elemento do Fim
	public void removeLast() throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if(tamanho == 1) {//Lista de um elemento, remover o �ltimo � remover o primeiro.
			removeFirst();
			
		} else {//Lista de 2 ou mais elementos, o pen�ltimo n� passa a ser o �ltimo.
			No penultimo = getNo(tamanho - 2);//Tamanho - 1 � a posi��o do �ltimo elemento.
			penultimo.proximo = null;
		}
	
	}
	//Remover elemento de qualquer posi��o v�lida
	public void remove(int pos) throws Exception {
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posi��o Inv�lida");
		}
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		if (pos == 0) {
			removeFirst(); 
		} else if (pos == tamanho - 1){
			removeLast();
		} else {
			No anterior = getNo(pos - 1);
			No atual = getNo(pos);
			anterior.proximo = atual.proximo;
			
		}
	}
	//Acessando elementos da LISTA
	public int get(int pos) throws Exception {
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posi�� Inv�lida");
		}
		No auxiliar = primeiro;
		int cont = 0;
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		int valor = auxiliar.dado;
		return valor;
	}
}
	
	











