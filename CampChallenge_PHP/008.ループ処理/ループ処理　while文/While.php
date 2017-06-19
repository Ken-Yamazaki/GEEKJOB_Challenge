<?php

$num = 1000;
$count = 1;
//1000を2で割り続け、100を下回ったら繰り返しから抜ける
while ($num > 100) {
  $num = $num / 2;
  $count++;
}

echo $count.'回ループしました';
