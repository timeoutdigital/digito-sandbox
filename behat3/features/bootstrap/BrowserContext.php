<?php

use Behat\Mink\Driver\Selenium2Driver,
    Behat\Mink\Session,
    Behat\Behat\Tester\Exception\PendingException;

/**
 * TODO: Description of BrowserContext
 *
 * @author Wayne Peacock
 */
class BrowserContext extends BaseContext {

    private $session;

    public function __construct() {
        echo("\$this->base_url "); var_dump($this->base_url);
        $desiredCapabilities = array(
            'browserName' => 'firefox',
            'version' => '28',
            'platform' => 'ANY',
            'browserVersion' => '28',
            'browser' => 'firefox',
            'name' => 'Behat Test',
            'deviceOrientation' => 'portrait',
            'deviceType' => 'tablet',
            'selenium-version' => '2.39.0'
        );
        $driver = new Selenium2Driver('firefox', $desiredCapabilities, 'http://127.0.0.1:4444/wd/hub');
        $this->session = new Session($driver);
        $this->session->start();
    }

    /**
     * @Given I am on the :city homepage
     */
    public function setCityHomepage($city) {
        $this->session->visit($city);
        assert("$this->session->getStatusCode() < 400");
    }

    /**
     * @When I ask for each item in the top level navigation menu
     */
    public function requestEachItemInTheTopLevelNavigationMenu() {
//        $dom = new DOMDocument();
//        @$dom->loadHTML($this->html_contents);
//        $x = new DOMXPath($dom);
//        $menu = array();
//
//        foreach ($x->query("//*[@class='navTopMenu//li[1]//a[1]']") as $node) {
//            var_dump($node);
//            $menu[] = $node->getAttribute("href");
//        }
        echo("\$menu ");
        var_dump($menu);
        throw new PendingException();
    }

    /**
     * @Then the request should be successful
     */
    public function requestShouldBeSuccessful() {
        throw new PendingException();
    }

}
