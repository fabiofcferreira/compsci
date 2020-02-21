double x = x + x
quadruple x = double (double x)
factorial n = product [1..n]
average x y = (x+y)/2

-- Zero function
-- zero x = case x of
--           0 -> True
--           otherwise -> False

min3 :: Int -> Int -> Int -> Int
min3 a b c = minimum [a, b, c]

eq3 :: Int -> Int -> Int -> Bool
eq3 a b c = if (a == b && b == c) then True else False

avg :: Float -> Float -> Float
avg a b = (a+b)/2

evenNumber :: Int -> Bool
evenNumber a = if (mod a 2) == 0 then True else False

sign :: Int -> Int
sign a = if (a < 0) then -1 else 1

-- Last composed function
lastalt :: [Int] -> Int
lastalt a = head (reverse a)