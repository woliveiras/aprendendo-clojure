(ns learningclojure)

(print "Hello World")

(+ 1 2)
(- 5 3)
(* 2 2)
(/ 10 2)

;; nested evaluations
(* 3 (- 2 5))

;; Types
(type 1)
(type (int 1))
(type 1.1)
(type true)
(type false)
(type nil)

(nth (vector 1 2 3 4) 3)

{:a 1 :b 2 :c 3 :d 4}

(:a {:a 1 :b 2 :c 3 :d 4})

(type {:a 1 :b 2 :c 3 :d 4})

(type #{1 2 3})

(def x "Hiii")

;; (def x "Hiii")

(if (empty? x)
    "X is empty"
    "X is not empty and your value is: ")

(if (empty? x)
    nil
    (do
        (println "OK")
        :ok))