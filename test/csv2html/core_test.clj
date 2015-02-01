(ns csv2html.core-test
  (:use midje.sweet)
  (:use [csv2html.core]))

(facts "about `parse-csv`"  
  (fact "it expects the first row to be column headers"
        (:headers (parse-csv "a,b")) => ["a" "b"])
  (fact "all but the first row are value rows"
        (:values (parse-csv "a,b\n0,1\n2,3")) => [["0" "1"] ["2" "3"]]))

(comment (facts "about `to-pages`"
                 (fact "it should create one page for each value row"
                       (to-pages (parse-csv "a,b\n0,1\n2,3")) => [])))
