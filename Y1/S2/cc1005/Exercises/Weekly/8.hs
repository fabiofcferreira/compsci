-- 57
fact :: Integer -> Integer
fact 0 = 1
fact n = n * fact (n - 1)

factorialInf :: [Integer]
factorialInf = [ fact x | x <- [1..] ]