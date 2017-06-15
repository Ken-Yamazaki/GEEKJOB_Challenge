<?php

$val = array(10,100,"soeda","hayashi",-20,118,"END");

echo "変更前<br>";
print_r($val);
echo "<br><br>";

$val[2] = 33;
echo "変更後<br>";
print_r($val);
