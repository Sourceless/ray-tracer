(ns steps-definitions.tuples [:require
                              [ray-tracer.core :as r]
                              [lambdaisland.cucumber.dsl :refer :all]
                              [clojure.test :refer :all]])

(Given "a <- tuple\\({double}, {double}, {double}, {double})" [state x y z w]
       (assoc state
              :a
              [x y z w]))

(Then "a.x = {double}" [state x]
      (is (= x (nth (:a state) 0)))
      state)

(And "a.y = {double}" [state y]
     (is (= y (nth (:a state) 1)))
     state)

(And "a.z = {double}" [state z]
     (is (= z (nth (:a state) 2)))
     state)

(And "a.w = {double}" [state w]
     (is (= w (nth (:a state) 3)))
     state)

(And "a is a point" [state]
     (is (r/rpoint? (:a state)))
     state)

(And "a is not a vector" [state]
     (is (not (r/rvector? (:a state))))
     state)

(And "a is not a point" [state]
     (is (not (r/rpoint? (:a state))))
     state)

(And "a is a vector" [state]
     (is (r/rvector? (:a state)))
     state)

(Given "p <- point\\({double}, {double}, {double})" [state x y z]
       (assoc state
              :p
              (r/rpoint x y z)))

(Then "p = tuple\\({double}, {double}, {double}, {double})" [state x y z w]
      (is (= [x y z w] (:p state)))
      state)

(Given "v <- vector\\({double}, {double}, {double})" [state x y z w]
       (assoc state
              :v
              (r/rvector x y z)))

(Then "v = tuple\\({double}, {double}, {double}, {double})" [state x y z w]
      (is (= [x y z w] (:v state)))
      state)

(Given "t{int} <- tuple\\({double}, {double}, {double}, {double})" [state num x y z w]
       (assoc state
              (keyword (str "t" num))
              [x y z w]))

(Then "t{int} = t{int}" [state a b]
      (is (r/rtuple-eq? ((keyword (str "t" a)) state) ((keyword (str "t" b)) state)))
      state)

(Then "t{int} != t{int}" [state a b]
      (is (not (r/rtuple-eq? ((keyword (str "t" a)) state) ((keyword (str "t" b)) state))))
      state)

;; (Then "t{int} + t{int} = tuple\\({double}, {double}, {double}, {double})" [state a b x y z w]
;;       (let [a (keyword (str "t" a) state)
;;             b (keyword (str "t" b) state)
;;             expected [x y z w]
;;             actual (r/+rtuple a b)]
;;         (is (r/rtuple-eq? actual expected)))
;;       state)

(Then "t{int} + t{int} = tuple\\({double}, {double}, {double}, {double})" [state a b x y z w]
      (let [a ((keyword (str "t" a)) state)
            b ((keyword (str "t" a)) state)
            expected [x y z w]
            actual (r/+rtuple a b)]
            (is (r/rtuple-eq? actual expected)))
      state)
