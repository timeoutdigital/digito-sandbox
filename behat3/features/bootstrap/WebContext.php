<?php

namespace Context;

class WebContext {

    /**
     * Safely combine URL parts
     * @param type $array as string
     * @return type $string
     */
    static function combineUrl($array) {
        $url = array();
        foreach ($array as $part) {
            array_push($url, ltrim(rtrim($part, "/"), "/"));
        }
        return implode("/", $url);
    }

    /**
     * Request a webpage and return the HTTP status code
     * @param type $url as string
     * @return type $string
     */
    static function getHttpStatus($url) {
        file_get_contents($url);
        return explode(" ", strstr($http_response_header[0], "HTTP"))[1];
    }

}
