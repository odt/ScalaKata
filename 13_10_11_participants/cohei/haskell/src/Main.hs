module Main where

import Control.Applicative ( (<$>) )
import Control.Monad ( (>=>) )
import Data.List ( sort )
import System.Directory ( setCurrentDirectory, getHomeDirectory )
import System.Process ( readProcess )

import Date
import PMap
import PParser

main :: IO ()
main = do
  es <- exercises
  let m = participantsMap $ map parseParticipants es

  putStr $ showParticipantsMap m
  putStrLn ""

  let d = Date 2013 10 8
  putStrLn $ "unparticipants at " ++ show d
  mapM_ (putStrLn . (' ':)) $ unparticipants d m

-- ./13_10_09_next_palindrome/joker1007
exercises :: IO [String]
exercises = do
  setCurrentDirectory . (++ "/projects/ScalaKata") =<< getHomeDirectory
  let command = readProcess "find" (words ". -maxdepth 2 -mindepth 2") >=>
                readProcess "grep" ["-v", ".git"] >=>
                readProcess "grep" ["-v", "README.md"] >=>
                readProcess "grep" ["-v", "target"]
  sort . lines <$> command ""
