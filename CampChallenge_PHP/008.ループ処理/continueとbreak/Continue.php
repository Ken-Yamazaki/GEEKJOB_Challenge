<?php

$val1 = array(1,2,3,4,5,6,7,8,9);
$val2 = array(1,2,3,4,5,6,7,8,9);
$i = 0;
$j = 0;

foreach ($val1 as $value1) {
  foreach ($val2 as $value2) {
    //5の段のみ非表示にする
    if ($i == 4) {
      continue;
    }
    echo $val1[$i],'×',$val2[$j],'=',$value1*$value2;
    echo "　";
    $j++;
  }
  echo '<br>';
  $i++;
  $j=0;
}
