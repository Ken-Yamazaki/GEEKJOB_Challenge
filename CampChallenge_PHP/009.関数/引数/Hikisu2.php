<?php

function judge($num1,$num2=5,$num3=false) {
  echo $num1*$num2."<br>";
  if ($num3==true) {
    echo "上記の数値を2乗します<br>";
    echo $num1*$num2*$num1*$num2;
  }
}

judge(2,6,true);
