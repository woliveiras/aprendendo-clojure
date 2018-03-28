## Utilizando o reduce em Clojure

Em Clojure, `reduce`, recebe 3 argumentos: 

1. uma função
2. o valor inicial
3. uma lista de valores

```clojure
(reduce (fn [total vals] (+ total vals)) 0 [0 1 2 3 4]) ;; retorna 10
```

O que acontece aqui é que o `reduce` passa os valores do segundo e terceiro argumentos para dentro da função recebida como primeiro argumento, então é isso o que acontece por baixo dos panos:

```clojure
(reduce (fn [total vals] (+ total vals)) 0 [0 1 2 3 4])
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