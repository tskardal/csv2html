(defproject csv2html "0.0.1-SNAPSHOT"
  :description "Cool new project to do things and stuff"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clojure-csv "2.0.1"]]
  :profiles {:dev {:dependencies [[midje "1.5.1"]]}}
  :main csv2html.core
  :aot [csv2html.core])
  
