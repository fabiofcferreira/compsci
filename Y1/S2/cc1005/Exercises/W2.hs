-- ex. 14
-- a) [char]
-- b) (char, char, char)
-- c) [(Bool, Char)]
-- d) ([Bool], [Char])
-- e) [a]

-- ex. 17
-- b)
exchange :: (a, a) -> (a, a)
exchange (a,b) = (b,a)
-- c)
pair :: a -> b -> (a, b)
pair a b = (a,b)
-- d)
double a = a * 2
-- e)
half x = x / 2
-- f)
lower x = x >= 'a' && x <= 'z'

-- i)
twice f x = f (f x)