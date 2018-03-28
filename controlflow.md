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

## When

When é uma combinação de if e do em um só comando:

(when true
  (println "Success!")
  "abra cadabra")
; => Success!
; => "abra cadabra"

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

## Operadores

Operador de igualdade `=`:

```clojure
(= 1 1) ;; retorna true
```

Operador `or`:

```clojure
(or false nil :large_I_mean_venti :why_cant_I_just_say_large) ;; retorna :large_I_mean_venti
```

Nesse caso :large_I_mean_venti é o primeiro valor verdadeiro, então já é retornado

```clojure
(or (= 0 1) (= "yes" "no")) ;; retorna false
```

Neste exemplo não temos nenhum valor verdadeiro, por isso é retornado a última avaliação
que é `false` por causa da comparação `(= "yes" "no")`

```clojure
(or nil) ;; retorna nil
```

Neste caso acontece o mesmo, retornando o último valor (e único)

Operador `and`:

```clojure
(and :free_wifi :hot_coffee) ;; retorna :hot_coffee
```

Como todos os valores são verdadeiros, o and retorna o último verdadeiro

```clojure
(and :feelin_super_cool nil false) ;; retorna nil
```

Como existe um `falsey` no meio, então ele é retornado (nesse caso o nil)