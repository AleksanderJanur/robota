<html>
<head>
	<title> Dodaj wpis</title>
	<META HTTP-EQUIV="content-type" CONTENT="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" title="Domyślny styl" href="style.css">
	<link rel="alternate stylesheet" type="text/css" title="Styl2" href="style2.css" />
	<link rel="alternate stylesheet" type="text/css" title="Styl3" href="style3.css" />
	<script type="text/javascript" src="scripts.js" ></script>
</head>
<body onload="onReload()">
<?php
$upload_dir  = './upload/';
$num_files = count($_FILES['upload']['name']);
echo "Wpis przyjęty!";
for ($i=0; $i < $num_files; $i++) {
    $upload_file = $upload_dir . urlencode(basename($_FILES['upload']['name'][$i]));

    
        if (is_uploaded_file($_FILES['upload']['tmp_name'][$i])) {
            if (move_uploaded_file($_FILES['upload']['tmp_name'][$i], 
                $upload_file)) {
                /* Great success... */
                echo "Dodano plik! <br/>";
                //$content = file_get_contents($upload_file);
                //print $content;
            } else {
                echo "Błąd(1)! Nie dodano pliku.";
            }
        }  
}
?>
</body>
</html>