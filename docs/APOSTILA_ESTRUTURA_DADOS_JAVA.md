# Apostila de Estrutura de Dados com Java
**FATEC - 2026/1**  
*Prof. Me. Alexandre Gomes*

---

## Sumário
1. [Introdução e Nivelamento](#1-introdução-e-nivelamento)
2. [Algoritmos de Busca](#2-algoritmos-de-busca)
3. [Algoritmos de Ordenação](#3-algoritmos-de-ordenação)
4. [Recursividade](#4-recursividade)
5. [Estruturas de Dados Lineares](#5-estruturas-de-dados-lineares)
6. [Estruturas de Dados Encadeadas](#6-estruturas-de-dados-encadeadas)
7. [Árvores Binárias de Busca (BST)](#7-árvores-binárias-de-busca-bst)

---

## 1. Introdução e Nivelamento

### Variáveis e Tipos de Dados
Em Java, ao contrário do JavaScript, os tipos de dados são estáticos e devem ser declarados. Trabalhamos com tipos primitivos (int, double, boolean) e classes (String, Integer).

### Arrays vs. ArrayList
- **Arrays (`int[]`):** Possuem tamanho fixo após a criação. São rápidos mas pouco flexíveis.
- **ArrayList:** Parte do framework de Coleções do Java. Possui tamanho dinâmico, permitindo crescer conforme a necessidade (`add()`, `remove()`).

### Programação Orientada a Objetos (POO)
Java é uma linguagem orientada a objetos pura. Tudo deve estar dentro de uma **Classe**. 
- **Atributos:** Variáveis que definem o estado do objeto.
- **Métodos:** Funções que definem o comportamento.
- **Encapsulamento:** Uso de modificadores `private` e métodos `get/set` para proteger os dados.

---

## 2. Algoritmos de Busca

### Busca Sequencial
O algoritmo percorre o vetor do início ao fim, comparando cada elemento com o valor desejado.
- **Melhor caso:** O elemento está na primeira posição. O(1).
- **Pior caso:** O elemento não existe ou está na última posição. O(n).

### Busca Binária
Requer que o vetor esteja **ordenado**. Divide o espaço de busca pela metade a cada iteração.
- **Eficiência:** Muito superior à busca sequencial para grandes volumes de dados. O(log n).

---

## 3. Algoritmos de Ordenação

### Bubble Sort (Ordenação por Bolha)
Compara elementos adjacentes e os troca se estiverem na ordem errada. Os maiores valores "flutuam" para o final.
- **Complexidade:** O(n²). Não recomendado para grandes conjuntos de dados.

### Selection Sort (Ordenação por Seleção)
Encontra o menor valor do vetor e o coloca na primeira posição, depois o segundo menor e assim por diante.
- **Diferencial:** Realiza muito menos trocas que o Bubble Sort.

### Merge Sort (Ordenação por Intercalação)
Utiliza a estratégia "Dividir para Conquistar". Divide o vetor recursivamente até ter unidades simples e depois as mescla em ordem.
- **Complexidade:** O(n log n). Muito estável e eficiente.

### Quick Sort
Escolhe um elemento como "pivô" e organiza o vetor de forma que elementos menores fiquem à esquerda e maiores à direita.
- **Performance:** Geralmente o mais rápido na prática. O(n log n) em média.

---

## 4. Recursividade
Um método é recursivo quando chama a si mesmo. Toda recursão precisa de:
1. **Caso Base (Saída):** Uma condição que interrompe as chamadas.
2. **Passo Recursivo:** A chamada do método com um estado reduzido do problema.

---

## 5. Estruturas de Dados Lineares

### Pilha (Stack)
Segue o princípio **LIFO** (*Last In, First Out*). O último a entrar é o primeiro a sair.
- **Operações:** `push` (empilhar), `pop` (desempilhar), `peek` (observar topo).

### Fila (Queue)
Segue o princípio **FIFO** (*First In, First Out*). O primeiro a entrar é o primeiro a sair.
- **Operações:** `enqueue` (enfileirar), `dequeue` (desenfileirar).

### Deque (Double-Ended Queue)
Uma fila que permite inserções e remoções em ambas as extremidades (início e fim).

---

## 6. Estruturas de Dados Encadeadas

### Lista Encadeada (Linked List)
Em vez de usar posições contíguas na memória (como vetores), cada elemento (Nodo) aponta para o próximo.
- **Vantagem:** Inserções e remoções rápidas sem necessidade de deslocar outros elementos.

### Lista Duplamente Encadeada
Cada Nodo possui ponteiros para o próximo e para o **anterior**, permitindo percorrer a lista em ambos os sentidos.

---

## 7. Árvores Binárias de Busca (BST)
Estrutura não linear onde cada Nodo tem, no máximo, dois filhos.
- **Regra:** O filho à esquerda é sempre menor que o pai, e o filho à direita é sempre maior.
- **Percursos:**
  - **Em-ordem:** Resulta nos dados em sequência crescente.
  - **Pré-ordem:** Processa a raiz antes dos filhos.
  - **Pós-ordem:** Processa os filhos antes da raiz.

---
*Material desenvolvido para a disciplina de Estrutura de Dados - FATEC.*
