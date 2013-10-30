module SortingBalls
       ( R(..)
       , Rack -- Rack の値コンストラクタはエクスポートせず、 R のインターフェースを使うようにします
       ) where

class R f where
  initial :: f a
  balls   :: f a -> [a]
  add     :: Ord a => a -> f a -> f a

newtype Rack a = Rack { unRack :: [a] }

instance R Rack where
  initial       = Rack []
  balls         = unRack
  add ball rack = Rack $ insert ball $ balls rack

infixl 5 &
(&) = flip ($) -- メソッドチェーンっぽく書ける演算子

-- この main 関数は型クラス R のインスタンスなら何でも動きます
main = do
  let initial' = initial :: Rack a
  print $ initial' & balls == ([] :: [Int])
  print $ initial' & add 20 & balls == [20]
  print $ initial' & add 20 & add 10 & balls == [10, 20]
  print $ initial' & add 20 & add 10 & add 30 & balls == [10, 20, 30]

insert :: Ord a => a -> [a] -> [a]
insert y [] = [y]
insert y xxs@(x:xs)
  | y > x     = x : insert y xs
  | otherwise = y : xxs
