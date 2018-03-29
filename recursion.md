## Recursividade

Vamos imaginar uma função que soma todos os valores de dentro de uma estrutura de dados.

Em Python poderíamos trabalhar com recursividade, porém seria comum fazermos algo do tipo:

```python
def my_func (numbers):
    total = 0
    for number in numbers:
        total += number
    return total
```

Utilizando um acumulador (`total`) e um for.

Em Clojure devemos utilizar recursividade para tal.

Fazemos:

```clojure
(defn my-recursive-sum [total numbers]
    (if (empty? numbers)
        total
        (my-recursive-sum (+ (first numbers) total) (rest numbers))))

(my-recursive-sum 0 [0 1 2 3 4])
```

O que acontece aqui é:

- recebemos o valor inicial do contador `0` e a estrutura a qual iremos trabalhar em cima
- colocamos o finalizador para a recursão logo no começo, `(if (empty? numbers)`, se numbers estiver vazio, finaliza retornando `total`
- agora utilizamos recursividade e chamamos novamente `my-recursive-sum` com os parâmetros
    - ` (+ (first numbers) total)` somamos o primeiro valor de numbers ao acumulador e retornamos esse valor
    - retornamos o restante dos valores dentro da estrutura `(rest numbers)`

Então, o que acontece é:

```
1. (my-recursive-sum 0 [0 1 2 3 4])
2. (my-recursive-sum 0 [1 2 3 4])
3. (my-recursive-sum 1 [2 3 4])
4. (my-recursive-sum 3 [3 4])
5. (my-recursive-sum 6 [4])
6. (my-recursive-sum 10 [])
```

E quando recebemos `(my-recursive-sum 10 [])` caímos na condicional de que `se numbers for vazio, retorne o total`.

Isso funciona porque first retorna o primeiro valor e rest retorna os demais.

Então sempre temos:

```
first de [0 1 2 3 4], retorna 0
rest de [0 1 2 3 4], retorna [1 2 3 4]
first de [1 2 3 4], retorna 1
rest de [1 2 3 4], retorna [2 3 4]
```

Imagine a seguinte função:

```clojure
(defn first-rest-sample [numbers]
    (if (empty? numbers)
        "Is empty!"
        (str "First: " (first numbers) " and rest: " (rest numbers))))
```

Agora, ao usarmos ela, vejamos o que acontece:

```clojure
(first-rest-sample [0 1 2 3 4]) ;; retorna "First: 0 and rest: (1 2 3 4)"
```

Mas nada mudou em nosso vetor `numbers` inicial, ele continua sendo `[0 1 2 3 4]` e isso acontece porque (além de que em Clojure é tudo imutável) [0 1 2 3 4], [1 2 3 4], [2 3 4], [3 4] e [4] são os valores que estamos passando como parâmetro para a função `my-recursive-sum` quando ela é executada novamente.

Mas daria para criar a função `my-recursive-sum` sem que o usuário da função tivesse que passar a posição inicial do acumulador toda vez.

```clojure
(defn my-recursive-sum
    ([numbers] (my-recursive-sum 0 numbers))
    ([total numbers]
        (if (empty? numbers)
            total
            (my-recursive-sum (+ (first numbers) total) (rest numbers)))))
```

Agora o usuário pode passar:

```clojure
(my-recursive-sum 0 [0 1 2 3 4])
```

Ou:

```clojure
(my-recursive-sum [0 1 2 3 4])
```

Aqui o que acontece é que transformamos `my-recursive-sum` em uma **multi-arity function**, uma função que pode trabalhar de modo diferente dependendo da quantidade de parâmetros recebidos.

Se ela receber somente um valor ([numbers]), então ela executa a própria função, recursivamente, com dois parâmetros (0 e numbers) e então cai na segunda branch, que é quando temos todo o processo de soma.

```
([numbers] (my-recursive-sum 0 numbers))
```

Uma melhoria em nossa função seria utilizar o recurso da própria linguagem chamado `recur`.

```clojure
(defn my-recursive-sum
    ([numbers] (my-recursive-sum 0 numbers))
    ([total numbers]
        (if (empty? numbers)
            total
            (recur (+ (first numbers) total) (rest numbers)))))
```

Utilizamos `recur` porque é um recurso otimizado da linguagem. O `recur`, ao invés de adicionar mais uma chamada de função a pilha, ele reutiliza a mesma posição da pilha evitando stack overflow.

Isso e uma otimização de Clojure para trabalhar com grandes quantidades de dados.

O resultado não é alterado, mas a utilização de `recur` é sempre encorajada para evitar problemas. Sempre que for fazer recursão, utilize `recur`.

Referências sobre `recur`:

- https://clojurebridge.github.io/community-docs/docs/clojure/recur/
- https://stackoverflow.com/questions/27673874/clojure-recur-vs-imperative-loop
- https://forum.freecodecamp.org/t/clojure-loop-recur/18418
- https://en.wikibooks.org/wiki/Clojure_Programming/By_Example
- https://clojure.org/about/functional_programming