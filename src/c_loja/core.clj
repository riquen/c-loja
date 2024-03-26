(ns c-loja.core
  (:require [c-loja.db :as l.db]
            [c-loja.logic :as l.logic]))

(defn resumo-por-usuario-ordenado
  [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println (some #(> (:preco-total %) 500) resumo)))