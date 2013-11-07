{-# LANGUAGE RecordWildCards #-}
module Date ( Date(..) ) where

import Data.List ( intercalate )

data Date = Date { year :: Int, month :: Int, day :: Int } deriving (Eq, Ord)

instance Show Date where
  show Date{..} = intercalate "/" $ map show [year, month, day]
