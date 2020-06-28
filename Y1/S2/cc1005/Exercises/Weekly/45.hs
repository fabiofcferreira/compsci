-- 30
twoPowN :: Int -> Int
twoPowN 0 = 1
twoPowN n = 2 * twoPowN (n - 1)

-- 39
f :: Integer -> Integer
f n = n

maxFun :: (Integer -> Integer) -> Integer -> Integer
maxFun f n = maximum [ f x | x <- [0..n] ]

-- 40
anyZero :: (Integer -> Integer) -> Integer -> Bool
anyZero f n = or [ f x == 0 | x <- [0..n] ]

-- 41
sumFun :: (Integer -> Integer) -> Integer -> Integer
sumFun f n = sum [ f x | x <- [0..n] ]

-- 42
insert :: Ord a => a -> [a] -> [a]
insert a [] = [a]
insert a (x:x':xs) | x <= a && a <= x' = (x:a:x':xs)
                   | otherwise         = insert a (x:x':xs)