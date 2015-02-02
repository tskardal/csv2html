(ns csv2html.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn parse-csv [csv-str]
  (let [lines (str/split-lines csv-str)
        headers (str/split (first lines) #",")
        values (rest lines)]    
    {:headers  headers :values (vec (map #(str/split % #",") values))}))

(defn to-html [headers values]
  (let [pairs (map vector headers values)]
    (for [[h p] pairs]
      (str "<h3>" h "</h3><p>" p "</p>"))))

(defn csv-to-html [in]
  (let [s (slurp in)
        parsed (parse-csv s)
        headers (:headers parsed)
        values (:values parsed)]
    (->> values
         (map #(to-html headers %))
         flatten)))

(defn -main [& args]
  (let [result (flatten (csv-to-html (first args)))]    
    (spit (second args) (apply str result))))
