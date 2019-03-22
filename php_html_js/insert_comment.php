<?php

if ($_REQUEST['type'] == 'send') {
  $user_name = utf8_decode(urldecode($_REQUEST['uname']));
  $msg  = utf8_decode(urldecode($_REQUEST['msg']));

  $myfile = fopen("logs.txt", "a") or die("Unable to open file!");
  $message_with_user =  $user_name . ":" . $msg;
  fwrite($myfile, "\n". $message_with_user);
  fclose($myfile);

}


$my_file = fopen("logs.txt", "r");
if ($my_file) {
  while (($line = fgets($my_file)) !== false) {
    $message_pieces = explode(":", $line);
    echo "<span class='uname'>" . $message_pieces[0] . " : " . "</span:<span class='msg'>" . $message_pieces[1] . "</span><br>";
  }

  fclose($my_file);
}
?>
