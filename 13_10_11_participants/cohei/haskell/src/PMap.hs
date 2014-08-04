module PMap
    ( participantsMap
    , showParticipantsMap
    , unparticipants
    ) where

import Control.Applicative ( (<$>) )
import Control.Arrow ( first )
import Data.Function ( on )
import qualified Data.Map.Strict as Map
import Data.Maybe ( fromJust, fromMaybe )
import Data.Monoid ( First(..), (<>) )
import Data.List ( nub, (\\), sortBy )
import Data.Ord ( comparing )

import Date
import PParser

type Line = (Date, Title, Name)

participantsMap :: [Line] -> Map.Map Date (Title, [Name])
participantsMap = foldr insertParticipants Map.empty

insertParticipants :: Line -> Map.Map Date (Title, [Name]) -> Map.Map Date (Title, [Name])
insertParticipants (date, title, name) = Map.insertWith f date (title, [name])
  where
    f :: (Title, [Name]) -> (Title, [Name]) -> (Title, [Name])
    f = (fromMonoid .) . (<>) `on` toMonoid
      where
        toMonoid :: (Title, [Name]) -> (First Title, [Name])
        toMonoid = first $ First . Just
        fromMonoid :: (First Title, [Name]) -> (Title, [Name])
        fromMonoid = first $ fromJust . getFirst

allParticipants :: Map.Map Date (Title, [Name]) -> [Name]
allParticipants = nub . concatMap snd . Map.elems

unparticipants :: Date -> Map.Map Date (Title, [Name]) -> [Name]
unparticipants d m = fromMaybe [] $ (allParticipants m \\) . snd <$> Map.lookup d m

showParticipantsMap :: Map.Map Date (Title, [Name]) -> String
showParticipantsMap = unlines . concatMap f . sortBy (comparing fst) . Map.assocs
    where
      f (date, (title, names)) = [show date, title] ++ map (' ':) names
