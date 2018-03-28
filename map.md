## Utilizando map em Clojure

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