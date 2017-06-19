<?php

$val1 = array(1,2,3,4,5,6,7,8,9);
$val2 = array(1,2,3,4,5,6,7,8,9);
$i = 0;
$j = 0;

foreach ($val1 as $value1) {
  //7の段に差し掛かる前にループ処理を離脱する
  if ($i == 6) {
    break;
  }
  foreach ($val2 as $value2) {
    echo $val1[$i],'×',$val2[$j],'=',$value1*$value2;
    echo "　";
    $j++;
  }
  echo '<br>';
  $i++;
  $j=0;
}
