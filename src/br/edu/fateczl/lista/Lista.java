package br.edu.fateczl.lista;

public class Lista {
	
	No primeiro;

	public Lista() {
		primeiro = null; //Inicializamos a LISTA - E, aqui o primeiro aponta para nulo!
	}
	//Teste de LISTA vazia
	public boolean isEmpty(){//Aqui nosso teste mais imediato! Saber se a LISTA é vazia!
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
	private No getNo(int pos) throws Exception {//O método getNo será private e não public
		//Porque trata-se de uma operação auxiliar para a Classe - um método para ajudar outros.
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();//Lembrando aqui para verificar os limites! Testes de Limite!
		if (pos < 0 || pos > tamanho -1) {
			throw new Exception("Posição Inválida");
		}
		No auxiliar = primeiro;
		int cont = 0;
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return auxiliar;
	}
	
	//INICIANDO AS OPERAÇÕES
	
	//Adicionar elemento no início
	//Colocando um elemento no início da LISTA
	public void addFirst(int valor) {
		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}
	//Adicionar elemento no fim
	public void addLast (int valor) throws Exception {
		int tamanho = size();
		
		if (isEmpty()) {//Verificação para fins concentuais!
			throw new Exception("Lista Vazia");
		}
		
		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = null;
		
		No ultimo = getNo(tamanho - 1);//Aqui é para saber quem é o último No.
		ultimo.proximo = elemento;
	}
	//Adicionar elemento em qualquer posição válida 
	public void add(int valor, int posicao) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho) {//Usar o tamanho que permita inserir na última posição.
			throw new Exception("Posição Inválida");
		}
		if (posicao == 0) {//Inserir no início da LISTA.
			addFirst(valor);
		} else if(posicao == tamanho) {//Inserir no final entre o último e o null.
			addLast(valor);
		} else {//Se não for nem um e nem o outro.
			No elemento = new No();
			elemento.dado = valor;//O ponteiro será definido pela posição.
			No anterior = getNo(posicao - 1);/*O anterior apontará para o novo e
			o novo apontará para onde o anterior estava apontando.*/
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}
	//Remover elemento do Início
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
		if(tamanho == 1) {//Lista de um elemento, remover o último é remover o primeiro.
			removeFirst();
			
		} else {//Lista de 2 ou mais elementos, o penúltimo nó passa a ser o último.
			No penultimo = getNo(tamanho - 2);//Tamanho - 1 é a posição do último elemento.
			penultimo.proximo = null;
		}
	
	}
	//Remover elemento de qualquer posição válida
	public void remove(int pos) throws Exception {
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Inválida");
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
			throw new Exception("Posiçã Inválida");
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
	
	











