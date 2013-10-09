import Data.Maybe ( fromMaybe )

binSearch :: Ord a => a -> [a] -> Maybe Int
binSearch y xs = binSearch' 0 (length xs - 1)
  where
    binSearch' min max
      | min > max = Nothing
      | otherwise = let mid = (min + max) `div` 2
                    in case compare y (xs !! mid) of
                      EQ -> Just mid
                      LT -> binSearch'  min   (mid-1)
                      GT -> binSearch' (mid+1) max

toResult :: Maybe Int -> Int
toResult = fromMaybe (-1)
