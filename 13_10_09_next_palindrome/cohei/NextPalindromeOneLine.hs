module NextPalindromeOneLine ( nextPalindromeOneLine ) where

import Control.Applicative ( (<*>) )

nextPalindromeOneLine :: Int -> Int
nextPalindromeOneLine = head . filter (((==) <*> reverse) . show) . enumFrom . succ
