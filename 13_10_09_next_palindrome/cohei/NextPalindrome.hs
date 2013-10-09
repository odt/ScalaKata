module NextPalindrome ( nextPalindrome ) where

import Data.Tuple         ( swap )
import Data.List          ( unfoldr )
import System.Environment ( getArgs )

-- 逆順になるが今回は関係ない
digits :: Int -> [Int]
digits = unfoldr (\n -> if n == 0 then Nothing else Just $ swap $ divMod n 10)

isPalindrome :: Int -> Bool
isPalindrome n = let ds = digits n in ds == reverse ds

nextPalindrome :: Int -> Int
nextPalindrome n = head $ filter isPalindrome [n+1..]

main :: IO ()
main = print . nextPalindrome . read . head =<< getArgs
