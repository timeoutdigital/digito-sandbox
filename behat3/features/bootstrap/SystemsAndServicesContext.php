<?php

use Behat\Behat\Tester\Exception\PendingException;

/**
 * TODO: Description of SystemsAndServicesContext
 *
 * @author Wayne Peacock
 */
class SystemsAndServicesContext extends BaseContext {

    private $http_status;
    
    /**
     * @When I ask to see the :city homepage
     */
    public function getCityHomepageStatus($city) {
        $url = WebContext::combineUrl(array($this->base_url, $city));
        echo "Checking '".$url."'";
        $this->http_status = WebContext::getHttpStatus($url);
    }

    /**
     * @Then the request should be successful
     */
    public function requestShouldBeSuccessful() {
        assert("$this->http_status != NULL", "No HTTP status returned");
        assert("$this->http_status < 400", sprintf("HTTP status code [%s]", $this->http_status));
    }

}
