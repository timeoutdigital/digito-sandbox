<?php

use Behat\Behat\Context\SnippetAcceptingContext;

/**
  * Provides the base Behat context for suite-specific contexts 
 *
 * @author Wayne Peacock
 */
class BaseContext implements SnippetAcceptingContext {
    
    public $base_url;

    //TODO: This is not working! Uses default instead of parameter from YAML!
    public function __construct($baseurl = "http://www.timeout.com") {
        $this->base_url = $baseurl;
//TODO:        echo("\$base_url "); var_dump($baseurl);
    }

}
