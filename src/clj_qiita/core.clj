(ns clj-qiita.core
  ;;(:gen-class)
  (:use [cheshire.core])
)

(def base "http://qiita.com/api/v2/")

(defn call
  ([method] (call method ""))
  ([method params]
   (parse-string (slurp (str base method "/" params)))))

(def ms
[
 "users"
 "items"
]
)

(doseq [m ms] (intern *ns* (symbol m) (fn [params] (call m params))))
