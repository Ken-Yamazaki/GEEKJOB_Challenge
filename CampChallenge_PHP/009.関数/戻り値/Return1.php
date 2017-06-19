<?php

function myprofile() {
  $name = '山崎健';
  $birthday = '1988-8-13';
  $comment = 'SEになるため勉強中です';
  echo "名前：".$name."<br>";
  echo "誕生日：".$birthday."<br>";
  echo "コメント：".$comment."<br>";
  return true;
}

$myprof = myprofile();
if ($myprof) {
  echo "この処理は正しく実行できました";
} else {
  echo "正しく実行できませんでした";
}
