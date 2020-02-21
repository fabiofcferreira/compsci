triangle a b c = if (a < b+c && b < a+c && c < a+b) then True
                 else False