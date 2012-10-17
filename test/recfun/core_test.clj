(ns recfun.core-test
  (:use clojure.test
        recfun.core))

(deftest pascal-test
	(testing "col=0,row=2"
		(is (= (pascal 0 2) 1)))
	(testing "col=1,row=2"
		(is (= (pascal 1 2) 2)))
	(testing "col=1,row=3"
		(is (= (pascal 1 3) 3))))

(deftest balance-test
	(testing "(if (zero? x) max (/ 1 x)) is balanced?"
		(is (balance (seq "(if (zero? x) max (/ 1 x))"))))
	(testing "'I told him ...' is balanced?"
		(is (balance (seq "I told him (that it's not (yet) done).\n(But he wasn't listening)"))))
	(testing "':-)' is unbalanced?"
		(is (not (balance (seq ":-)")))))
	(testing "Counting is not enough"
		(is (not (balance (seq "())("))))))

(deftest count-change-test
	(testing "manual"
		(is (= (countChange 4 (list 1 2)) 3)))
	(testing "sorted CHF"
		(is (= (countChange 300 (list 5 10 20 50 100 200 500)) 1022)))
	(testing "no pennies"
		(is (= (countChange 301 (list 5 10 20 50 100 200 500)) 0)))
	(testing "unsorted CHF"
		(is (= (countChange 300 (list 500 5 50 100 20 200 10)) 1022))))
