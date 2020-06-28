-- 22
sumQuad :: Int -> Int -> Int
sumQuad a b = sum [ x*x | x <- [a..b] ]

-- 24
divprop :: Int -> [Int]
divprop n = [x | x <- [1..n-1], n `mod` x == 0]

-- 25
perfeitos :: Int -> [Int]
perfeitos n = [x | x <- [1..n], x == sum (divprop x) ]

-- 26
primo :: Int -> Bool
primo n = divprop n == [1]

-- 28
dotprod :: [Float] -> [Float] -> Float
dotprod as bs = sum [ a * b | (a, b) <- list ]
                where list = zip as bs

-- 30
forte :: String -> Bool
forte str = if (length str >= 8 && upperChars > 0 && lowerChars > 0 && digits > 0) then True
            else False
            where 
              upperChars = length [ c | c <- str, c >= 'A' && c <= 'Z' ]
              lowerChars = length [ c | c <- str, c >= 'a' && c <= 'z' ]
              digits = length [ d | d <- str, d >= '0' && d <= '9' ]