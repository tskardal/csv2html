(ns csv2html.core-test
  (:use midje.sweet)
  (:use [csv2html.core]))

(facts "about `parse-csv`"
  (fact "it sucks"
    (parse-csv "") => nil))
