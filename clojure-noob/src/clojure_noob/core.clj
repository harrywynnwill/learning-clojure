(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot"))
  (println "Cleanliness is next to godliness")

(defn train
  []
  (println "Choo choo!"))

  (defn weird-arity
    ([]
       "Destiny dressed you this morning, my friend, and now Fear is
       trying to pull off your pants. If you give up, if you give in,
       you're gonna end up naked with Fear just standing there laughing
       at your dangling unmentionables! - the Tick")
    ([number]
       (inc number)))

       (defn codger-communication
         [whippersnapper]
         (str "Get off my lawn, " whippersnapper "!!!"))

       (defn codger
       ➊   [& whippersnappers]
         (map codger-communication whippersnappers))
