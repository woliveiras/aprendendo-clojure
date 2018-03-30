## Tipos de dados em Clojure

Clojure utiliza os tipos de Java.

### Números

Se fizermos `(type 1)` teremos o resultado `java.lang.Long`
`(type (int 1))` teremos o resultado `java.lang.Integer`
`(type 1.1)` teremos o resultado `java.lang.Double`

### Boolean

`(type true)` teremos o resultado `java.lang.Boolean`
`(type false)` teremos o resultado `java.lang.Boolean`

### String

`(type "Hello")` teremos o resultado `java.lang.String`

### Coleções

**Keywords e Symbols**

`(type :a)` teremos o resultado `clojure.lang.Keyword`
`(type (quote a))` teremos o resultado `clojure.lang.Symbol`
`(type 'a)` teremos o resultado `clojure.lang.Symbol`

**Vetores**

`(type (vector [1 2 3 4]))` teremos o resultado `clojure.lang.PersistentVector`
`(type (vector 1 2 3 4))` teremos o resultado `clojure.lang.PersistentVector`

**Listas**

`(type (list 1 2 3))` teremos o resultado `clojure.lang.PersistentList`
`(type '(1 2 3))` teremos o resultado `clojure.lang.PersistentList` - se não tivermos o ', Clojure avaliaria o 1 como uma função
Uma lista é Linked List e o vetor é um Array

**Mapas**

`{:a 1 :b 2 :c 3 :d 4}` é a estrutura de um Mapa em Clojure

`(type (hash-map :a 1 :b 2 :c 3 :d 4))` teremos o resultado `clojure.lang.PersistentArrayMap`
`(type {:a 1 :b 2 :c 3 :d 4})` teremos o resultado `clojure.lang.PersistentArrayMap`
 
E acessamos os valores do mapa da seguinte maneira:

```clojure
(:a {:a 1 :b 2 :c 3 :d 4}) ;; retorna o valor 1 que está na chave :a do mapa passado como parâmetro
```

**Sets**

`(type (hash-set 1 2 3))` teremos o resultado `clojure.lang.PersistentHashSet`
`(type #{1 2 3})` teremos o resultado `clojure.lang.PersistentHashSet`

Para buscar um valor, utilizando funções nativas do Clojure conseguimos uma performance melhor:

```clojure
(nth (vector 1 2 3 4) 2) ;; retorna o número 3, que é a segunda posição do vetor (0 1 2)
(first (list 1 2 3 4)) ;; retorna o número 1
(last (list 1 2 3 4)) ;; retorna o número 4
```

Também podemos utilizar o `get`:

```clojure
(get {:a 0 :b 1} :b) ;; retorna 1
(get [3 2 1] 0) ;; retorna 3
(get ["a" {:name "William"} "c"] 1) ;; retorna {:name "William"}
```

Ou `get-in` em nested maps:

```clojure
(get-in {:a 0 :b {:c "chave :c" :d "chave d"}} [:b :c]) ;; retorna "chave :c"
```

O `get-in` pegou a chave `:c` de `:b`.