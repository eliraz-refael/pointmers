(ns devcards.main
  (:require-macros
   [devcards.core :refer [defcard]])
  (:require [reagent.core :as r]
            [devcards.core :as dv]))

(def functional-compiler (r/create-compiler {:function-components true}))

(reagent.core/set-default-compiler! functional-compiler)

(defn hello-component []
  [:div "hello-world"])

(defcard hello
  (dv/reagent hello)
  {:inspect-data true
   :frame true
   :history true})

(defcard test
  [:div "kuki"])

(defn ^:export init [] (devcards.core/start-devcard-ui!))

(defn ^:export reload []
  (println "Refreshing Devcards!"))
