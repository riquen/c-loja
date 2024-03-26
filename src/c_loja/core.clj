(ns c-loja.core
  (:require [c-loja.db :as l.db]
            [c-loja.logic :as l.logic]))

(defn resumo-por-usuario-ordenado
  [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))

(defn top-2
  [resumo]
  (take 2 resumo))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println resumo)
  (println (first resumo))
  (println (second resumo))
  (println (rest resumo))
  (println (count resumo))
  (println (class resumo))
  (println (nth resumo 1))
  (println (take 2 resumo))
  (println (top-2 resumo)))