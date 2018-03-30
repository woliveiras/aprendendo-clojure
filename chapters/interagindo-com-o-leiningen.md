# Interagindo com o Leiningen

Criando um novo projeto

```shell
lein new nome-do-projeto
```

O lein criará a seguinte estrutura:

doc/
resources/
src/
test/
LICENSE
project.clj
README.md

Onde:

- **doc** são os arquivos de documentação
- **resources** são os arquivos estáticos, arquivos SQL ou qualquer outra coisa que não seja código do nosso projeto
- **src** onde vamos colocar nossos códigos
- **test** onde vamos colocar os arquivos de testes do nosso projeto
- **LICENSE** o arquivo de licença do nosso projeto
- **project.clj** o arquivo de configuração do nosso projeto
- **README** que é o arquivo de documentação inicial de todo projeto

Para executar nosso projeto, entramos na pasta criada e rodamos o comando: `lein run -m namespace`.

Exemplo:

```
lein run -m learnclojure.core
```

Se colocarmos em nosso project.clj qual o método para main, então poderemos rodar somente `lein run`.

```clojure
(defproject learnclojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main learnclojure.core)
```

O legal é que, se quisermos instalar um framework e já iniciar um projeto baseado nele, podemos somente rodar um comando e o lein faz tudo pra gente.

Um exemplo é a instalação e utilização do Pedestal, um framework web:

```shell
lein new pedestal-service nome-do-servico
```