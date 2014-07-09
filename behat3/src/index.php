<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/2000/REC-xhtml1-20000126/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head></head>
<body>
<?php

class Index
{
    function helloWorld()
    {
        return("Hello World!");
    }
}    
        
$index = new Index();
echo($index->helloWorld());
    
?>
    
</body>