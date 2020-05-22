(ns ray-tracer.core
  (:gen-class))

(defn rpoint? [[_ _ _ w]]
  (= w 1.0))

(defn rvector? [[_ _ _ w]]
  (= w 0.0))

(defn rpoint [x y z]
  [x y z 1.0])

(defn rvector [x y z]
  [x y z 0.0])

(defn rx [[x _ _ _]]
  x)

(defn ry [[_ y _ _]]
  y)

(defn rz [[_ _ z _]]
  z)

(defn rw [[_ _ _ w]]
  w)

(def epsilon 0.00001)

(defn req? [a b]
  (let [delta (- a b)
        abs-delta (Math/abs delta)]
    (< abs-delta epsilon)
    ))

(defn rtuple-eq? [t1 t2]
  ;; There is most likely a better way to do this
  (let [pairs (map vector t1 t2)]
    (every? (fn [[a b]] (req? a b)) pairs)))

(defn +rtuple [t1 t2]
  (vec (map + t1 t2)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
