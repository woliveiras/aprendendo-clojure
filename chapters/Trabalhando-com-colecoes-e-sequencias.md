## Trabalhando com coleções e sequências em Clojure

Coleções são imutaveis e persistentes.

Sempre que vamos "mudar" algo, precisamos fazer uma cópia dos valores e retornar uma nova coleção.

Exemplo:

```clojure
(def x (list 1 2 3))

;; acrescentar algo ao início da lista
(cons 0 x) ;; retorna (0 1 2 3)
```

`cons` acrescenta um valor ao início da lista, mas, se imprimirmos a lista original, vemos que nada mudou.

```clojure
(print x) ;; (1 2 3)
```

Podemos utilizar as funções de Clojure para trabalhar com nossa lista:

```clojure
(nth x 2) ;; retorna o número 3, que é a segunda posição da lista '(0 1 2)
(first x) ;; retorna o número 1
(last x) ;; retorna o número 3
(cons 0 x) ;; retorna (0 1 2 3)
(conj x 0) ;; retorna (0 1 2 3)
```

Poderíamos fazer o mesmo com vetores:

```clojure
(def v [1 2 3])

(nth v 2) ;; retorna o número 3, que é a segunda posição da lista '(0 1 2)
(first v) ;; retorna o número 1
(last v) ;; retorna o número 3
(cons 0 v) ;; retorna (0 1 2 3)
(conj v 0) ;; retorna [0 1 2 3]
```

Aqui percebemos uma diferença no resultado de `cons`. Ela não fez um clone de vector, mas retornou uma lista. Isso acontece porque **cons** sempre retorna uma lista com os valores passados por parâmetro.

Outras funções maneiras:

```clojure
(def x (list 1 2 3))
(def v [1 2 3])

(concat x v) ;; retorna (1 2 3 1 2 3)
```

Podemos unir mapas ou adicionar valores ao final do mapa com `assoc`.

```clojure
(def m {:a 1})

(assoc m :b 2) ;; retorna {:a 1, :b 2}
```

E, quando temos mapas alinhados, podemos fazer:

```clojure
(assoc-in {:settings {:a 1 :b 2}} [:settings :a] "eita") ;; retorna {:settings {:a "eita", :b 2}}
```

Onde, "modificamos" o valor de `[:settings :a]`.

Podemos, ainda, utilizar a função `update-in` para retornar um mapa "modificado":

```clojure
(update-in {:settings {:a 1 :b 2}} [:settings :a] inc) ;; retorna {:settings {:a 2, :b 2}}
```

Podemos executar as mesmas funções com sets.

```clojure
(def s #{1 2 3})
(conj s 4) ;; #{1 2 3 4}
(disj s 3) ;; #{1 2}
```

Podemos checar se existe um valor dentro de um conjunto com `contains?`

```clojure
(def s #{1 2 3})
(contains? s 4) ;; false
```