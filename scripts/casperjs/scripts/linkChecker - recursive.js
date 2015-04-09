/**
 * This casper scipt checks for 404 internal links for a given root url.
 *
 * Usage:
 *
 *     $ casperjs 404checker.js http://mysite.tld/
 *     $ casperjs 404checker.js http://mysite.tld/ --max-links=42
 */

/*global URI*/

var casper = require("casper").create({
    pageSettings: {
        loadImages: false,
        loadPlugins: false
    }
});
var checked = [];
var currentLink = 0;
var fs = require('fs');
var maxLinks = ~~casper.cli.get('max-links') || 100;
var url = casper.cli.get(0);
var baseUrl = url;
var links = [url];
var utils = require('utils');
var f = utils.format;
var broken = [];

function absPath(url, base) {
    return new URI(url).resolve(new URI(base)).toString();
}

function cleanLinks(urls, base) {
    return utils.unique(urls).filter(function(url) {
        return url.indexOf(baseUrl) === 0 || !new RegExp('^(#|ftp|javascript|http)').test(url);
    }).map(function(url) {
        return absPath(url, base);
    }).filter(function(url) {
        return checked.indexOf(url) === -1;
    });
}

function crawl(link) {
    this.start().then(function() {
        this.echo(link, 'COMMENT');
        this.open(link);
        checked.push(link);
    });
    this.then(function() {
        if (this.currentHTTPStatus === 404) {
            this.warn(link + ' is missing (HTTP 404)');
            broken.push(link);
        } else if (this.currentHTTPStatus === 500) {
            this.warn(link + ' is broken (HTTP 500)');
            broken.push(link);
        } else {
            this.echo(link + f(' is okay (HTTP %s)', this.currentHTTPStatus));
        }
    });
    this.then(function() {
        var newLinks = searchLinks.call(this);
        links = links.concat(newLinks).filter(function(url) {
            return checked.indexOf(url) === -1;
        });
        this.echo(newLinks.length + " new links found on " + link);
    });
}

// Fetch all <a> elements from the page and return
// the ones which contains a href starting with 'http://'
function searchLinks() {
    return cleanLinks(this.evaluate(function _fetchInternalLinks() {
        return [].map.call(__utils__.findAll('a[href]'), function(node) {
            return node.getAttribute('href');
        });
    }), this.getCurrentUrl());
}

function check() {
    if (links[currentLink] && currentLink < maxLinks) {
        crawl.call(this, links[currentLink]);
        currentLink++;
        this.run(check);
    }
    else {
        this.echo("\n========   END OF RUN   ========\n");
        if (currentLink >= maxLinks) {
            this.echo("Reached maximum link limit.")
        }
        this.echo("All done, " + checked.length + " links checked.");
        if (broken.length === 0) {
            this.echo("All links were ok.");
        } else {
            this.echo(broken.length + " were broken, list of URLs follows...");
            this.echo(broken);
        }
this.echo(links.join(','));
        this.exit();
    }
}

if (!url) {
    casper.warn('No url passed, aborting.').exit();
}

casper.start('https://js-uri.googlecode.com/svn/trunk/lib/URI.js', function() {
    var scriptCode = this.getPageContent() + '; return URI;';
    window.URI = new Function(scriptCode)();
    if (typeof window.URI === "function") {
        this.echo('URI.js loaded');
    } else {
        this.warn('Could not setup URI.js').exit();
    }
});

casper.run(process);

function process() {
    casper.start().then(function() {
        this.echo("\n========  START OF RUN  ========\n");

    }).run(check);
}