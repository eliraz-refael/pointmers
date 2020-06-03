(ns main.app
  (:require [reagent.dom :as rd]
            [reagent.core :as r]
            ["@material-ui/core" :as mui]))

(def functional-compiler (r/create-compiler {:function-components true}))

(defn app []
  [:div "hello world"
   [:> mui/Button "Hello3"]])

(defn mount []
 (rd/render [app] (. js/document getElementById "app") functional-compiler))

(defn start []
  (js/console.log "Starting...")
  (.appendChild js/document.body (doto (.createElement js/document "div")
                                   (-> (.setAttribute "id" "app"))))
  (mount))

(defn ^:export init []
  (start))

(defn ^:export reload! []
  (mount))
