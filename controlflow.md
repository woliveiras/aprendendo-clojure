## Controle de fluxo em Clojure

Criando "variáveis":

```clojure
(def x "Hiii")
```

Também podemos usar `let`:

```clojure
(let [y "William"]
    (print "Hello", y))
```

`def` cria algo com escopo global e `let` com escopo local

## if

```clojure
(def x "Hiii")

(if (empty? x)
    "X is empty"
    "X is not empty")
```

Definimos o valor x e depois verificamos se ele está vazio (empty?), em seguida criamos duas branches, a primeira para o caso de verdadeiro ("X is empty") e a segunda para o caso de falso ("X is not empty")

Outro exemplo, utilizando `do`:

```clojure
(def x "Hiii")

(if (empty? x)
    nil
    (do
        (println "OK")
        :ok))   ;; retorna "OK"
```

## not

```clojure
(def x "Hiii")

(if-not (empty? x)
    nil
    (do
        (println "OK")
        :ok))   ;; retorna nil
```

Também podemos utilizar `when-not`

```clojure
(def x "Hiii")

(when-not (empty? x)
    (println "OK")
    :ok)
```

## case

Utilizamos a seguinte sintaxe:

```clojure
(def y "hello")

(case y
    "goodbye" :goodbye
    "hello" :hello
    :nothing) ;; retorna :hello
```

`:nothing`, aqui, é o valor default