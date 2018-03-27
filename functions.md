## Functions

Funções são forms como os demais. Uma função, em Clojure, segue a seguinte estrutura:

```clojure
(fn [] "Hello")
```

Onde, temos o nome da função `fn`, os parâmetros `[]` e o retorno da função `"Hello"`.

Mas, nesse caso, criamos uma função anônima `(fn [] "")`.

Podemos dar um nome a essa função da seguinte maneira:

```clojure
(def hello (fn [] "Hello"))
(hello) ;; retorna "Hello"
```

Mas usamos a seguinte sintaxe para criação de funções nomeadas:

```clojure
(defn hello [] "Hello")
```

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

Funções podem receber docstrings opcionalmente:

```clojure
(defn sum 
    "Return the sum of two values"
    [x, y]
    (+ x y))
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