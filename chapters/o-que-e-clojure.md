# O que é Clojure

Clojure é um dialeto de Lisp criada por Rich Hickey para ser uma alternativa moderna à Lisp.

A linguagem foi criada para trabalhar no paradigma funcional rodando sobre a JVM, a máquina virtual do Java, para favorecer a concorrência (quando vários processos disputam acesso a recursos compartilhados do computador).

Clojure é uma linguagem de propósito geral, encoraja o uso de estruturas de dados imutáveis e a imutabilidade de dados, possui tipagem dinâmica e encoraja que a manipulação de estado seja explícita.

Existe um compilador de Clojure para JavaScript (ECMAScript) chamado ClojureScript para desenvolvermos para client-side ou interagir com Nodejs utilizando a mesma linguagem.

Algumas empresas famosas utilizam a linguagem:

- Walmart
- Puppet Labs
- Thoughtworks
- Atlassian
- NuBank
- CircleCI
- B2W
- Amazon
- Apple
- Heroku

Dentre várias outras.

A sintaxe de Clojure é construída em S-Expressions, que é uma maneira de apresentar uma lista aninhada de dados. Quando colocamos algo sobre parênteses, `()`, sabemos que aquilo será interpretado e simboliza algum dado.

Exemplo:

```
(+ 10 (* 2 20))
```

O resultado da expressão será 50, pois temos a soma de 10, `(+ 10)`, com 40, o resultado de `(* 2 20)`.

## Referências

- [Clojure [site oficial]](https://clojure.org/)
- [Clojure [wikipedia]](https://en.wikipedia.org/wiki/Clojure)
- [ClojureScript](https://clojurescript.org/)
- [O que é concorrência em computação](https://pt.wikipedia.org/wiki/Concorr%C3%AAncia_(ci%C3%AAncia_da_computa%C3%A7%C3%A3o))
- [Casos de sucesso](https://clojure.org/community/)
- [S-Expressions](https://en.wikipedia.org/wiki/S-expression)
