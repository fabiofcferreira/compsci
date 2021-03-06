-- ex. 2
triangle a b c = if (a < b+c && b < a+c && c < a+b) then True
                 else False

-- ex. 3
triangleArea a b c = sqrt (s * (s - a) * (s - b) * (s - c))
                      where s = (a+b+c) / 2;

-- ex. 4
-- when the list has an odd length, the last element is not present in any
-- of the arrays in the tuple
halfs a = (take num a, take num (drop num a))
            where num = (length a) `div` 2;

-- ex. 5 
-- a)
lastalt a = head (reverse a)

-- b)
droplast a = reverse (drop 1 (reverse a))

-- ex. 6
binom n k = product [1..n] / (product ([1..k] ++ [1..(n-k)]))
binomsimplified n k = product [n-k+1..n] / product [1..k]

-- ex. 7
-- a)
max3 a b c = if (a > b) then 
              if (b > c) then a
              else c
             else
              if (b > c) then b
              else c

min3 a b c = if (a < b) then -- a < b | b > c
              if (b < c) then a -- b > c
              else 
                if (a < c) then a
                else c
             else
              if (c < b) then c
              else b

-- b)
simplemax3 a b c = max a (max b c)
simplemin3 a b c = min a (min b c)


-- ex. 9
gradeConditional :: Int -> String
-- Using ifs
-- gradeConditional a = if a <= 9 then "Failed"
--                      else if a >= 10 && a <= 12 then "OK"
--                      else if a > 13 && a <= 15 then "Good"
--                      else if a > 16 && a <= 18 then "Very good"
--                      else if a > 18 && a <= 20 then "Excellent"
--                      else "Not valid"

-- Using guards
gradeConditional a
  | a <= 9 = "Failed"
  | a <= 12 = "OK"
  | a <= 15 = "Good"
  | a <= 18 = "Very good"
  | a <= 20 = "Excellent"

-- ex. 10
xor :: Bool -> Bool -> Bool
xor p q = if (p && not q) || (not p && q) then True
          else False

-- ex. 11
safetail :: [a] -> [a]

-- Using IFs
-- safetail x = if (length x) == 0 then [] else tail x

-- Using cases
-- safetail x = case length x of
--   0 -> []
--   _ -> tail x

-- Using guards
-- safetail x
--   | length x == 0 = []
--   | otherwise = tail x

-- Using patterns
safetail [] = []
safetail (x:xs) = xs

-- ex. 12
short :: [a] -> Bool
-- Using guards
-- short x
--   | length x == 0 = True
--   | length x == 1 = True
--   | length x == 2 = True
--   | otherwise = False

-- short x = if (length (safetail (safetail x))) > 0 then False else True

-- Using patterns
short [] = True
short (x:[]) = True
short (x:y:[]) = True
short (x:y:zs) = False