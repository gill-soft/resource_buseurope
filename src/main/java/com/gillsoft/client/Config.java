package com.gillsoft.client;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Config {

	private static Properties properties;

	static {
		try {
			Resource resource = new ClassPathResource("resource.properties");
			properties = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getUrl() {
		return properties.getProperty("url");
	}
	
	public static String getUrlSchedule() {
		return properties.getProperty("url.schedule");
	}

	public static String getLogin() {
		return properties.getProperty("login");
	}

	public static String getPassword() {
		return properties.getProperty("password");
	}

	public static String getMinutesLeftToStart() {
		return properties.getProperty("minutes_left_to_start");
	}
	
	public static String getCurrency() {
		return properties.getProperty("default.currency");
	}

	public static String getTicketEmail() {
		return properties.getProperty("ticket.email");
	}

	public static String getLocalIpAddress() {
		return properties.getProperty("local.ip.address");
	}

	public static int getRequestTimeout() {
		return Integer.valueOf(properties.getProperty("request.timeout"));
	}

	public static int getSearchRequestTimeout() {
		return Integer.valueOf(properties.getProperty("request.search.timeout"));
	}

	public static int getReadTimeout() {
		return Integer.valueOf(properties.getProperty("request.read.timeout"));
	}

	public static long getCacheTripTimeToLive() {
		return Long.valueOf(properties.getProperty("cache.trip.time.to.live"));
	}

	public static long getCacheTripUpdateDelay() {
		return Long.valueOf(properties.getProperty("cache.trip.update.delay"));
	}

	public static long getCacheStationsUpdateDelay() {
		return Long.valueOf(properties.getProperty("cache.stations.update.delay"));
	}
	
	public static long getCacheScheduleUpdateDelay() {
		return Long.valueOf(properties.getProperty("cache.schedule.update.delay"));
	}
	
	public static long getCacheScheduleTimeToLive() {
		return Long.valueOf(properties.getProperty("cache.schedule.time.to.live"));
	}

	public static long getCacheErrorTimeToLive() {
		return Long.valueOf(properties.getProperty("cache.error.time.to.live"));
	}

	public static long getCacheErrorUpdateDelay() {
		return Long.valueOf(properties.getProperty("cache.error.update.delay"));
	}

}
