<?php

function profile() {
  $prof = array();
  $prof['id'] = 1;
  $prof['name'] = '山崎健';
  $prof['birthday'] = '1988-08-13';
  $prof['address'] = '東京都';
  return $prof;
}

$prof = profile();
echo '名前：'.$prof['name'].'<br>';
echo '生年月日：'.$prof['birthday'].'<br>';
echo '住所：'.$prof['address'];
