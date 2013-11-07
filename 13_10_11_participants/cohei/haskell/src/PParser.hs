module PParser
       ( parseParticipants
       , Title
       , Name
       ) where

import Control.Applicative ( (<$>), (<*>), (<$), (<*) )
import Data.Monoid ( mempty )
import Text.Trifecta

import Date

parseParticipants :: String -> (Date, Title, Name)
parseParticipants = parse parser

parse :: Parser a -> String -> a
parse p = fromSuccess . parseString p mempty
  where
    fromSuccess (Success x) = x

type Title = String
type Name  = String

parser :: Parser (Date, Title, Name)
parser = (,,) <$ string "./" <*> date <*> title <* char '/' <*> name

date :: Parser Date
date = listToDate <$> count 3 (digit2 <* char '_')
  where
    digit2 = read <$> count 2 digit
    listToDate [y,m,d] = Date (2000+y) m d

title :: Parser Title
title = some $ noneOf "/"

name :: Parser Name
name = some anyChar
