data Fraction = Frac Integer Integer

num, denom :: Fraction -> Integer
num   (Frac p q) = p
denom (Frac p q) = q

(%) :: Integer -> Integer -> Fraction
p % q
  | q==0 = error "%: division by zero"
  | q<0 = (-p) % (-q)
  | otherwise = Frac (p `div` d) (q `div` d)
  where d = mdc p q

mdc :: Integer -> Integer -> Integer
mdc a 0 = a
mdc a b = mdc b (a `mod` b)

instance Eq Fraction where
  (Frac p q) == (Frac r s) = p==r && q==s

instance Show Fraction where
  show (Frac p q) = show p ++ ('%': show q)