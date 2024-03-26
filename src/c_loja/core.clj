(ns c-loja.core
  (:require [c-loja.db :as l.db]))

(defn total-do-item
  [[_ detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       (map total-do-item)
       (reduce +)))

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantidade-de-pedidos-e-gasto-total-por-usuario
  [[usuario, pedidos]]
  {:usuario-id       usuario
   :total-de-pedidos (count pedidos)
   :preco-total      (total-dos-pedidos pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map quantidade-de-pedidos-e-gasto-total-por-usuario)
     println)