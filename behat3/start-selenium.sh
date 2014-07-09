#!/bin/sh
cd ./vendor/netwing/selenium-server-standalone
java -jar selenium-server-standalone-2.39.0.jar -port 4444 -Dwebdriver.firefox.bin="/usr/bin/firefox" -Dwebdriver.chrome.driver="/usr/bin/google-chrome"
#-log ~/SeleniumServer.log
