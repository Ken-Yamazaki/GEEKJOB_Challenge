<?php

function judge($num) {
  if ($num%2 == 0) {
    echo "偶数です";
  } else {
    echo "奇数です";
  }
}

//偶数を渡した場合
judge(2);

echo "<br>";

//奇数を渡した場合
judge(3);
