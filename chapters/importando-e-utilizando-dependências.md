# Importando e utilizando dependências

Importando uma dependência com `require`:

```clojure
(require 'clojure.string)
```

Poderemos utilizar depois:

```clojure
(clojure.string/split "a,b,c" #",")
```

Isso aqui é uma expressão regular em Clojure `#""`.

Para que não seja necessário digitar todo o namespace toda hora, podemos nomear o import utilizando o `:as`:

```clojure
(require '[clojure.string :as s])
```

E poderemos utilizar assim:

```clojure
(s/split "a,b,c" #",")
```

Mas, ao invés de renomear o namespace e correr o risco de entrar em um código que não encontramos as coisas durante a leitura por isso num futuro não muito distânte, podemos importar somente aquilo que formos utilizar com o `:refer`:

```clojure
(require '[clojure.string :refer [split]])
```

E poderemos utilizar assim:

```clojure
(split "a,b,c" #",")
```

Também podemos pegar todas as funções de um namespace com o `:all`:

```clojure
(require '[clojure.string :refer :all])
```

E também poderemos utilizar assim:

```clojure
(split "a,b,c" #",")
```

Existe ainda o `import` para classes Java:

```clojure
(import 'java.util.Date)
```

E poderemos utilizar assim:

```clojure
(Date.)
```

Podemos importar somente os métodos que quisermos de uma classe Java da seguinte maneira:

```clojure
(import '[java.util Date Calendar])
```

Podemos ainda utilizar os imports como argumentos do nosso namespace:

```clojure
(ns sample.core
    (:require [clojure.string :refer [split]]))
```