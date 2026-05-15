# Projeto CP3 - Java POO | Celular

## Informações do Aluno

- **Nome:** [Seu Nome Completo]
- **RM:** [Seu RM]
- **Turma:** [Sua Turma]
- **Curso:** Análise e Desenvolvimento de Sistemas - FIAP
- **GitHub:** [@seu-usuario]

---

## Descrição do Projeto

Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, onde desenvolvemos um sistema de modelagem de **celulares** com hierarquia de tipos (Android e iPhone), associação com o objeto `Dono`, e comportamentos compartilhados via interface `Carregavel`.

---

## Estrutura de Classes

```
Celular (abstract)
├── Android (extends Celular, implements Carregavel)
└── Iphone  (extends Celular, implements Carregavel)

Dono
Powerbank (implements Carregavel)

<<interface>> Carregavel
    └── implementado por: Android, Iphone, Powerbank
```

---

## O que cada classe representa

### `Celular` (Superclasse Abstrata)
Representa um celular genérico no mundo real. É abstrata pois não faz sentido existir um celular sem ser de um sistema operacional específico. Contém os atributos comuns a todo celular: `cor`, `marca`, `bateria` e `dono`.

**Atributos:**
| Atributo | Tipo | Descrição |
|---|---|---|
| `cor` | `String` | Cor do aparelho |
| `marca` | `String` | Fabricante do aparelho |
| `bateria` | `int` | Nível de bateria (0 a 100%) |
| `dono` | `Dono` | Objeto que representa o proprietário |

**Métodos:**
| Método | Descrição | Regra de negócio |
|---|---|---|
| `carregarBateria(int)` | Aumenta o nível de bateria | Não ultrapassa 100%; rejeita valores ≤ 0 |
| `usarBateria(int)` | Diminui o nível de bateria | Não vai abaixo de 0%; rejeita valores ≤ 0 |
| `exibirInfo()` | Retorna dados do celular formatados | — |
| `tipoDeConector()` | **Abstrato** — cada subclasse define seu conector | Obrigatório nas filhas |

---

### `Android` (Subclasse)
Especialização de `Celular` que representa aparelhos com sistema Android.

**Atributo exclusivo:**
| Atributo | Tipo | Descrição |
|---|---|---|
| `versaoAndroid` | `String` | Versão do sistema Android instalado |

**Regra:** `setVersaoAndroid()` não aceita valores nulos ou vazios.  
**Conector:** retorna `"USB-C"` no `tipoDeConector()`.

---

### `Iphone` (Subclasse)
Especialização de `Celular` que representa aparelhos Apple.

**Atributo exclusivo:**
| Atributo | Tipo | Descrição |
|---|---|---|
| `versaoIOS` | `String` | Versão do sistema iOS instalado |

**Regra:** `setVersaoIOS()` não aceita valores nulos ou vazios.  
**Conector:** retorna `"Lightning"` no `tipoDeConector()`.

---

### `Dono`
Representa o proprietário de um celular.

**Atributos:**
| Atributo | Tipo | Descrição |
|---|---|---|
| `nome` | `String` | Nome completo do dono |
| `cpf` | `String` | CPF do dono |

**Regra:** `setCpf()` rejeita CPFs nulos ou com comprimento diferente de 11 dígitos.

---

### `Powerbank`
Classe independente que representa um carregador portátil. Não herda de `Celular`, mas implementa `Carregavel`.

**Atributos:**
| Atributo | Tipo | Descrição |
|---|---|---|
| `marca` | `String` | Fabricante do powerbank |
| `carga` | `int` | Carga atual em mAh |
| `capacidadeMaxima` | `int` | Capacidade máxima em mAh |

**Regra:** `setCapacidadeMaxima()` aceita apenas valores entre 1000 e 30000 mAh.

---

### `<<interface>>` `Carregavel`
Define o contrato de comportamento para qualquer objeto que pode ser carregado.

```java
public interface Carregavel {
    void carregar(int quantidade);
    int getNivelCarga();
}
```

Implementado por: `Android`, `Iphone` e `Powerbank`.

---

## Como usar

```java
// 1. Criar o Dono
Dono dono = new Dono("João Silva", "12345678901");

// 2. Criar o celular passando o Dono no construtor
Android meuCelular = new Android("preto", "samsung", dono, "Android 14");

// 3. Usar os métodos
meuCelular.usarBateria(30);
meuCelular.carregarBateria(50);
System.out.println(meuCelular.exibirInfo());
System.out.println(meuCelular.tipoDeConector()); // USB-C

// 4. Polimorfismo com interface
List<Carregavel> carregaveis = new ArrayList<>();
carregaveis.add(new Android("preto", "samsung", dono, "Android 14"));
carregaveis.add(new Iphone("branco", "apple", dono, "iOS 17"));
carregaveis.add(new Powerbank("Anker", 20000));

for (Carregavel c : carregaveis) {
    c.carregar(50);
    System.out.println("Carga: " + c.getNivelCarga());
}
```

---

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Celular`? Não seria mais fácil apenas criar variáveis soltas no main?

**Resposta:**
Variáveis soltas funcionam para um único objeto, mas quebram completamente ao escalar. Se o sistema precisar gerenciar mil celulares, teríamos `String cor1`, `String cor2`... até o infinito, sem nenhuma organização ou reutilização. A classe `Celular` resolve isso encapsulando estado e comportamento em uma única unidade coesa. Cada instância carrega seus próprios dados de forma independente, e a lógica de negócio (como as regras de bateria) fica centralizada na classe, não espalhada pelo código principal. É a diferença entre uma gaveta organizada e uma mesa com tudo jogado.

---

### Aula 2 - Métodos

**Pergunta:** Por que criar `carregarBateria(valor)` em vez de alterar `bateria` diretamente?

**Resposta:**
Alterar `bateria` diretamente no `main` significa que qualquer parte do código pode colocar o valor -50 ou 999 sem que ninguém impeça. O método `carregarBateria()` centraliza a regra: bateria não pode ultrapassar 100% nem ir abaixo de 0%. Se essa regra precisar mudar, alteramos em um único lugar. Sem o método, a mesma verificação teria que ser repetida em todo lugar onde a bateria é modificada — o que é frágil, propenso a erros e impossível de manter em sistemas grandes.

---

### Aula 3 - Encapsulamento

**Pergunta:** Por que é seguro deixar o `get` público, mas perigoso deixar o atributo original público?

**Resposta:**
O `getCor()` entrega uma cópia do valor — quem recebe não consegue alterar o atributo original. Já deixar `cor` como `public` é entregar o documento original: qualquer código externo pode escrever `meuCelular.cor = null` sem passar por nenhuma validação. No nosso projeto, o `setBateria()` tem a regra que rejeita valores fora de 0-100. Se `bateria` fosse público, essa regra seria ignorável por qualquer linha do `main`, tornando a proteção inútil. O encapsulamento garante que o estado do objeto só muda por caminhos controlados.

---

### Aula 4 - Construtores

**Pergunta:** Por que é um erro gerar getters e setters para tudo automaticamente?

**Resposta:**
No nosso projeto, `marca` e `cor` são identidades do aparelho — não faz sentido um Samsung virar Apple depois de instanciado. Gerar setter para tudo automaticamente expõe atributos que deveriam ser imutáveis após a criação. Além disso, setters gerados automaticamente não têm regras de negócio: o `setBateria()` padrão aceitaria -500 sem reclamar. As decisões de quais setters existem e o que eles validam definem a integridade do objeto. Delegar isso para a IDE é abrir mão do controle sobre o comportamento da sua própria classe.

---

### Aula 5 - Associação

**Pergunta:** Por que exigir o objeto `Dono` inteiro em vez de apenas o nome como String?

**Resposta:**
Se `Celular` guardasse apenas `String nomeDono`, ele saberia identificar o dono, mas não conseguiria interagir com ele. No nosso modelo, o `Dono` tem CPF e outros dados que podem ser necessários em regras futuras — como verificar titularidade ou bloquear o aparelho. Passar o objeto inteiro mantém a referência viva: qualquer operação que precise do `Dono` real (não só do nome) está disponível via `getDono()`. Uma String é um dado morto; o objeto é uma entidade com comportamento e estado acessíveis.

---

### Aula 6 - Herança

**Pergunta:** Por que o Java não deixa a filha alterar variáveis `private` da mãe diretamente?

**Resposta:**
Porque `private` significa que aquele dado pertence exclusivamente à classe que o declarou — nem as filhas têm acesso direto. Isso protege o encapsulamento mesmo dentro da hierarquia. Se `Android` pudesse fazer `this.bateria = -50` diretamente, a regra do `setBateria()` definida em `Celular` seria completamente bypassável por qualquer subclasse. Ao forçar o uso de `super()` e dos setters, o Java garante que as regras da mãe sempre serão respeitadas, independentemente de quantas filhas existam.

---

### Aula 7 - Polimorfismo

**Pergunta:** Se esquecêssemos de declarar `exibirInfo()` na classe mãe `Celular`, conseguiríamos chamá-lo no loop `for (Celular c : celulares)`?

**Resposta:**
Não. O compilador analisa o tipo declarado da variável, que é `Celular`. Se o método não existe em `Celular`, o compilador rejeita a chamada — mesmo que o objeto em runtime seja um `Android` que tem o método. O contrato precisa existir na base da hierarquia porque é ele que garante ao compilador que todo objeto que entrar naquele loop, seja `Android` ou `Iphone`, terá aquele método disponível. Sem o contrato na mãe, o polimorfismo não funciona.

---

### Aula 8 - Classes Abstratas

**Pergunta:** Por que precisamos declarar `Celular` como `abstract` explicitamente? Por que o Java não deduz sozinho?

**Resposta:**
O Java não deduz porque a decisão de abstração é de negócio, não técnica. Uma classe pode ter todos os métodos implementados e ainda assim ser abstrata por intenção do arquiteto. Se esquecêssemos o `abstract` em `Celular`, qualquer parte do código poderia instanciar `new Celular("preto", "samsung", dono)` — um objeto genérico sem `tipoDeConector()` definido, que quebraria a lógica do sistema. O `abstract` é uma declaração explícita de intenção: esta classe existe apenas para ser herdada, nunca instanciada diretamente.

---

### Aula 9 - Interfaces

**Pergunta:** Por que Java permite herança simples mas múltipla implementação de interfaces?

**Resposta:**
A herança múltipla de classes cria o "problema do diamante": se `Android` herdasse de `Celular` e de `Powerbank`, e ambas tivessem um método `carregar()` com implementações diferentes, o Java não saberia qual usar. As interfaces resolvem isso porque definem apenas o contrato — a assinatura do método — sem implementação (com exceção de `default methods`). Quando `Android` implementa `Carregavel`, ele é obrigado a fornecer sua própria implementação de `carregar()`, eliminando a ambiguidade. No nosso projeto, `Android`, `Iphone` e `Powerbank` implementam `Carregavel` cada um à sua maneira, sem conflito.
