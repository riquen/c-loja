(ns c-loja.core
  (:require [c-loja.db :as l.db]
            [c-loja.logic :as l.logic]))

(defn gastou-bastante?
  [info-do-usuario]
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println (keep gastou-bastante? resumo)))

(defn filter-one
  [x]
  (println "filter-one" x)
  x)

(defn filter-two
  [x]
  (println "filter-two" x)
  x)

(->> (range 50)
     (mapv filter-one)
     (map filter-two)
     println)

(->> '(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9)
     (map filter-one)
     (map filter-two)
     println)