(ns recfun.core
	(:require clojure.pprint)
	(:use clojure.pprint))

(defn pascal [column row]
	(cond 
		(or (= row 0) (= column 0) (= row column)) 1
		:else (+ (pascal (- column 1) (- row 1)) (pascal column (- row 1)))))

(defn balance [chars]
	(= 0
		(loop [c chars balance 0]
			(cond
				(or (< balance 0) (empty? c)) balance
				:else (recur (rest c)
					(cond
						(= (first c) \( ) (+ balance 1)
						(= (first c) \) ) (- balance 1)
						:else balance))))))

(defn countChange [money coins]
	(cond 
		(= money 0) 1
		(or (< money 0) (empty? coins)) 0
		:else (+ (countChange money (rest coins)) (countChange (- money (first coins)) coins))))

(defn -main [& args]
	(println "Pascal's Triangle")
	(doall 
		(pprint
			(for [row (range 0 11)]
				(for [col (range 0 (+ row 1))]
					(pascal col row))))))

