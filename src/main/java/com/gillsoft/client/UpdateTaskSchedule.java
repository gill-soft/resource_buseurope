package com.gillsoft.client;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.gillsoft.cache.RedisMemoryCache;
import com.gillsoft.model.Channel;
//import com.gillsoft.model.ArrayOfCityS;
import com.gillsoft.util.ContextProvider;

public class UpdateTaskSchedule implements Runnable, Serializable {
	
	private static final long serialVersionUID = -447739350784487326L;

	@Override
	public void run() {
		Map<String, Object> params = new HashMap<>();
		params.put(RedisMemoryCache.OBJECT_NAME, RestClient.SCHEDULE_CACHE_KEY);
		params.put(RedisMemoryCache.IGNORE_AGE, true);
		params.put(RedisMemoryCache.UPDATE_DELAY, Config.getCacheScheduleUpdateDelay());
		params.put(RedisMemoryCache.TIME_TO_LIVE, Config.getCacheScheduleTimeToLive());
		
		RestClient client = ContextProvider.getBean(RestClient.class);
		try {
			Channel channel = client.loadSchedule();
			if (channel != null) {
				params.put(RedisMemoryCache.UPDATE_TASK, this);
				client.getCache().write(channel, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
