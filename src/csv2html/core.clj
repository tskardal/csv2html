(ns csv2html.core
  (:require [clojure.string :as str]))

(defn parse-csv [csv-str]
  (let [lines (str/split-lines csv-str)
        headers (str/split (first lines) #",")
        values (rest lines)]    
    {:headers  headers :values (vec (map #(str/split % #",") values))}))

(defn to-html [headers values]
  (let [pairs (map vector headers values)]
    (for [[h p] pairs]
      (str "<h3>" h "</h3><p>" p "</p>"))))


