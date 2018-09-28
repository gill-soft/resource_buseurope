package com.gillsoft;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gillsoft.abstract_rest_service.AbstractScheduleService;
import com.gillsoft.cache.IOCacheException;
import com.gillsoft.client.RestClient;
import com.gillsoft.model.Channel;
import com.gillsoft.model.request.ScheduleRequest;
import com.gillsoft.model.response.ScheduleResponse;

@RestController
public class ScheduleServiceController extends AbstractScheduleService {

	@Autowired
	private RestClient client;

	@Override
	public ScheduleResponse getScheduleResponse(ScheduleRequest request) {
		ScheduleResponse response = new ScheduleResponse();
		boolean cacheError = true;
		do {
			try {
				Channel channel = client.getCachedSchedule();
				if (channel != null && channel.getGroup() != null && channel.getGroup().getThreads() != null
						&& channel.getGroup().getThreads().getThread() != null
						&& !channel.getGroup().getThreads().getThread().isEmpty()) {
					client.addScheduleRoute(channel.getGroup().getThreads().getThread(), response);
				}
				break;
			} catch (IOCacheException e) {
				try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException ie) {
				}
			}
		} while (cacheError);
		return response;
	}

}
