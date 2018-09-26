package com.gillsoft.client;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.gillsoft.cache.IOCacheException;
import com.gillsoft.cache.RedisMemoryCache;
import com.gillsoft.model.Locality;
//import com.gillsoft.model.ArrayOfCityS;
import com.gillsoft.util.ContextProvider;

public class UpdateTaskStations implements Runnable, Serializable {
	
	private static final long serialVersionUID = -447739350784487326L;

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		Map<String, Object> params = new HashMap<>();
		params.put(RedisMemoryCache.OBJECT_NAME, RestClient.STATIONS_CACHE_KEY);
		params.put(RedisMemoryCache.IGNORE_AGE, true);
		params.put(RedisMemoryCache.UPDATE_DELAY, Config.getCacheStationsUpdateDelay());
		
		RestClient client = ContextProvider.getBean(RestClient.class);
		try {
			List<Entry<Locality, List<String>>> stations = client.getAllStations();
			if (stations == null) {
				stations = (List<Entry<Locality, List<String>>>) client.getCache().read(params);
			}
			params.put(RedisMemoryCache.UPDATE_TASK, this);
			client.getCache().write(stations, params);
		} catch (ResponseError | IOCacheException e) {
			e.printStackTrace();
		}
	}

}
