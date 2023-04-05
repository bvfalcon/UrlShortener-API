# UrlShortener-API

This is an API for Url shortener service like tiny url. 

Url shortener is service that converts long urls into short aliases to save space when sharing urls in messages, twitter, presentations etc.
When user opens short url, it will be automatically redirected to original (long) url.

# How to use 
+ With Docker and docker-compose: 

```sh
$ git clone https://github.com/bvfalcon/UrlShortener-API.git url-shortener
$ cd url-shortener
$ docker-compose build 
$ docker-compose up 
```

Use it with browser add-ons for which custom server can be configured (like [Copy ShortURL](https://copy-shorturl.readthedocs.io/en/latest/index.html) add-on for Firefox)

URL for Service: `http://localhost:8080/v1/create-short?longUrl=%URL%`
