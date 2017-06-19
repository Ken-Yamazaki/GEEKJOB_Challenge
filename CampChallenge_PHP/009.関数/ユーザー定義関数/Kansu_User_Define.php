<?php

function myprofile() {
  $name = '山崎健';
  $birthday = '1988-8-13';
  $comment = 'SEになるため勉強中です';
  echo "名前：".$name."<br>";
  echo "誕生日：".$birthday."<br>";
  echo "コメント：".$comment."<br>";
}

for($i=0; $i<10; $i++) {
  echo $i+1,"回目<br>";
  myprofile();
  echo "<br>";
}
