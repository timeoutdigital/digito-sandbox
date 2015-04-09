var page = require('webpage').create();
var baseurl = 'http://www.timeout.com';
var city = "london";

page.open(baseurl + "/" + city, function(status) {
    if ( status === "success" ) {

	    var links = page.evaluate(function() {
	        return [].map.call(document.querySelectorAll('a'), function(link) {
	            return link.getAttribute('href');
	        });
	    });

	    console.log(links.join(','));
	    phantom.exit();
	}
});
