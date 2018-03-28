## Utilizando filter em Clojure

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