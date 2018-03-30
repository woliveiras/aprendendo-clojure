## Funções em Clojure

Uma função, em Clojure, segue a seguinte estrutura:

```clojure
(f [] retorno)
```

Onde, temos o nome da função `f`, os parâmetros `[]` e o retorno da função `retorno`.

Mas também podemos criar uma função anônima com a sintaxe `(fn [] retorno)`. Mais para frente entenderemos melhor.

Exemplo:

```clojure
(defn hello [] "Hello")
```

Podemos criar uma função anônima e atribuir a uma "variável":

```clojure
(def hello (fn [] "Hello"))
```

E para executar essas funções basta fazer:

```clojure
(hello) ;; retorna "Hello"
```

Pois elas não recebem nenhum argumento.

Em Clojure, toda função espera um retorno e sempre irá retornar a última declaração, caso nada mude seu fluxo.

Exemplo de função com parâmetros:

```clojure
(defn hello [name] (str "Hello, " name))
(hello "William") ;; retorna "Hello, William"
```

Exemplo com múltiplos parâmetros;

```clojure
(defn sum [x, y] (+ x y))
(sum 2 2) ;; retorna 4
```

Repare que para passar os argumentos para uma função, não precisamos de colchetes e vírgula, basta colocar seu nome e os valores, `sum 2 2`.

Funções podem receber docstrings opcionalmente:

```clojure
(defn sum 
    "Return the sum of two values"
    [x, y]
    (+ x y))
```

Agora, para acessar a docstring, rodamos:

```shell
(doc sum)
```

E o retorno seria:

```shell
user=> (doc sum)
-------------------------
user/sum
([x y])
  Return the sum of two values
nil
```

Podemos utilizar da aridade para criar funções com multiplos comportamentos.

Exemplo:

```clojure
(defn hello
    ([] "Hello, world!")
    ([name] (str "Hello, "name)))
```

Onde, se invocarmos a função sem parâmetros `(hello)`, teremos o primeiro retorno, se invocarmos com um parâmetro `(hello "William")`, teremos o segundo retorno.

## Destructuring

Utilizamos destructuring para extrair valores de uma estrutura de dados.

Podemos fazer:

```clojure
(defn hello [config]
    (str "Hello, " (:name config)))
```

E na hora de invocar:

```clojure
(hello {:name "William" :age 27 :profession "Developer"}) ;; retorna "Hello, William"
```

Também poderíamos ter feito:

```clojure
(defn hello [name :name]
    (str "Hello, " name))
```

Onde declaramos um novo parâmetro, `name`, com o valor da chave `:name`.

Poderíamos pegar multiplos valores com a seguinte sintaxe:

```clojure
(defn hello [{name :name, profession :profession}]
    (str name " is a " profession))

(hello {:name "William" :age 27 :profession "Developer"}) ;; retorna "William is a Developer"
```

Também podemos pegar mais de um valor de dentro de um vetor com a seguinte sintaxe:

```clojure
(defn hello [[name title]]
    (str "Hello, " title " " name))
    
(hello ["William" "mr."])
```

## Utilizando o reduce

O `reduce`, recebe 3 argumentos: 

1. uma função
2. o valor inicial
3. uma lista de valores

```clojure
(reduce (fn [total numbers] (+ total numbers)) 0 [0 1 2 3 4]) ;; retorna 10
```

O que acontece aqui é que o `reduce` passa os valores do segundo e terceiro argumentos para dentro da função recebida como primeiro argumento, então é isso o que acontece por baixo dos panos:

```clojure
(reduce (fn [total numbers] (+ total numbers)) 0 [0 1 2 3 4])
(fn [0 [0 1 2 3 4]] (+ 0 [0 1 2 3 4]))
```

E internamente acontece esse processamento:

```clojure
(+ (+ (+ (+ (+ 0 0 ) 1) 2 ) 3) 4) ;; retorna 10
```

Mas, nesse caso, poderíamos ter feito:

```clojure
(reduce + [0 1 2 3 4])
```

Afinal, o + é uma função em Clojure.

## Utilizando filter

O `filter`, recebe 2 argumentos: 

1. uma função
2. uma lista de valores

Poderíamos criar uma função que filtra valores par e utilizar um reduce para rodar essa função para cada item de um array:

```clojure
(defn even-numbers [acc next-val]
    (if (even? next-val)
        (conj acc next-val)
        acc))
```

Onde, `even-numbers` recebe um acumulador (um vetor para guardar os valores) e o próximo valor, que vamos checar com a função `even` do Clojure, que retorna verdadeiro se o valor for par. Se `even? próximo valor` for verdadeiro, então juntamos o valor ao acumulador, senão retornamos o acumulador.

Rodando essa função:

```clojure
(reduce even-numbers [] [0 1 2 3 4 5 6]) ;; retorna [0 2 4 6]
```

Poderíamos, então, utilizar o `filter` no lugar de criarmos uma função para tal:

```clojure
(filter even? [0 1 2 3 4 5 6]) ;; retorna (0 2 4 6)
```

## Utilizando map

O `filter`, recebe 2 argumentos: 

1. uma função
2. uma lista de valores

Imagina que precisamos incrementar cada valor de um array.

Em uma abordagem estrutural poderíamos criar um loop e ir acrescentando a cada iteração.

Poderíamos, também, criar uma funçã para incrementarmos utilizando a função `inc` de Clojure:

```clojure
(defn my-inc [acc next-val]
    (conj acc (inc next-val)))
```

E então podemos utilizar um reduce para rodar `my-inc` em cada item do vetor:

```clojure
(reduce my-inc [] [0 1 2 3 4]) ;; retorna [1 2 3 4 5]
```

Ao invés disso, poderíamos utilizar a função `map`:

```clojure
(map inc [0 1 2 3 4]) ;; retorna (1 2 3 4 5)
```