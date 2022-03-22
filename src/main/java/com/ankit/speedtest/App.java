package com.ankit.speedtest;

public class App {
    public static void main( String[] args ) {
		String url = "https://www.commonfloor.com/listing-search?city=Bangalore&search_intent=sale";
		Boolean[] TestDrivers = new Boolean[]{ false, false, true, true, false, false, false};
		Result[] results = new Result[7];
		int i = 0;

		// Selenium with Chrome
		if(TestDrivers[0]) {
			SeleniumChrome seleniumChrome = new SeleniumChrome(false, url, false);
			results[i] = new Result(seleniumChrome.toString(), seleniumChrome.getResult(), seleniumChrome.getStats());
			i++;
		}
		
		// Selenium + Chrome Headless
		if(TestDrivers[1]) {
			SeleniumChrome seleniumChromeHeadless = new SeleniumChrome(true, url, false);
			results[i] = new Result(seleniumChromeHeadless.toString(), seleniumChromeHeadless.getResult(), seleniumChromeHeadless.getStats());
			i++;
		}
		
		// Selenium + Chrome + Proxy
		if(TestDrivers[2]) {
			SeleniumChrome seleniumChromeProxy = new SeleniumChrome(false, url, true);
			results[i] = new Result(seleniumChromeProxy.toString(), seleniumChromeProxy.getResult(), seleniumChromeProxy.getStats());
			i++;
		}
		
		// Selenium + Chrome Headless + Proxy
		if(TestDrivers[3]) {
			SeleniumChrome seleniumChromeHeadlessProxy = new SeleniumChrome(true, url, true);
			results[i] = new Result(seleniumChromeHeadlessProxy.toString(), seleniumChromeHeadlessProxy.getResult(), seleniumChromeHeadlessProxy.getStats());
			i++;
		}
		
		// HTMLUnit + JavaScript
		if(TestDrivers[4]) {
			HTMLUnit htmlwithjs = new HTMLUnit(true, url);
			results[i] = new Result(htmlwithjs.toString(), htmlwithjs.getResult(), htmlwithjs.getStats());
			i++;
		}
		
		// HTMLUnit without JavaScript
		if(TestDrivers[5]) {
			HTMLUnit htmlwithoutjs = new HTMLUnit(false, url);
			results[i] = new Result(htmlwithoutjs.toString(), htmlwithoutjs.getResult(), htmlwithoutjs.getStats());
			i++;

		}
		
		// JSoup
		if(TestDrivers[6]) {
			JSoup jsoup = new JSoup(url);
			results[i] = new Result(jsoup.toString(), jsoup.getResult(), jsoup.getStats());
			i++;
		}

		
		for(Result result: results) {
			System.out.println(result != null ? result : "");
		}
    }
}