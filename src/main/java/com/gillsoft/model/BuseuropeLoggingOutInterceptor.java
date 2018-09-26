package com.gillsoft.model;

import java.io.OutputStream;
import java.util.concurrent.CopyOnWriteArraySet;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.message.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BuseuropeLoggingOutInterceptor extends LoggingOutInterceptor {

	private CopyOnWriteArraySet<String> ids;

	private static final Logger LOGGER = LogManager.getLogger();
	private static final String LOG_SETUP = LoggingOutInterceptor.class.getName() + ".log-setup";

	// список логируемых методов
	private static final String[] LOGGED_METHOD_NAMES = { "login", "searchRacesWithSearchStat", "isSearchComplete",
			"getFoundRaces", "getSystemCurrency", "getRaceFreeSeats", "startSale", "reserve", "registerTickets",
			"getTicketPDF", "calculateBuyback", "buyback" };

	public BuseuropeLoggingOutInterceptor(CopyOnWriteArraySet<String> ids) {
		this.ids = ids;
	}

	public void handleMessage(Message message) throws Fault {
		OutputStream os = (OutputStream) message.getContent(OutputStream.class);
		if (os == null) {
			return;
		}
		boolean hasLogged = message.containsKey(LOG_SETUP);
		if (!hasLogged) {
			message.put(LOG_SETUP, Boolean.TRUE);
			CacheAndWriteOutputStream newOut = new CacheAndWriteOutputStream(os);
			message.setContent(OutputStream.class, newOut);
			newOut.registerCallback(new BuseuropeLoggingOutInterceptor.MyLoggingCallback(this, message, os));
		}
	}

	public static void logInfo(String logInfo) {
		try {
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
			StackTraceElement e = stacktrace[2];
			LOGGER.info("CLASS/METHOD NAME=" + e.getClassName() + "." + e.getMethodName() + ":" + e.getLineNumber()
					+ " - " + logInfo);
		} catch (Throwable e) {
			LOGGER.info(logInfo);
		}
	}

	class MyLoggingCallback implements CachedOutputStreamCallback {

		private final Message message;
		private final OutputStream origStream;

		public MyLoggingCallback(BuseuropeLoggingOutInterceptor paramLoggingOutInterceptor, Message msg,
				OutputStream os) {
			this.message = msg;
			this.origStream = os;
		}

		@Override
		public void onClose(CachedOutputStream cos) {
			String id = (String) this.message.getExchange().get(LoggingMessage.ID_KEY);
			if (id == null) {
				id = LoggingMessage.nextId();
				this.message.getExchange().put(LoggingMessage.ID_KEY, id);
			}

			LoggingMessage buffer = new LoggingMessage("Buseurope Outbound Message\n---------------------------", id);

			Integer responseCode = (Integer) this.message.get(Message.RESPONSE_CODE);
			if (responseCode != null) {
				buffer.getResponseCode().append(responseCode);
			}
			String encoding = (String) this.message.get(Message.ENCODING);
			if (encoding != null) {
				buffer.getEncoding().append(encoding);
			}
			String address = (String) this.message.get(Message.ENDPOINT_ADDRESS);
			if (address != null) {
				buffer.getAddress().append(address);
			}
			String ct = (String) this.message.get(Message.CONTENT_TYPE);
			if (ct != null) {
				buffer.getContentType().append(ct);
			}
			Object headers = this.message.get(Message.PROTOCOL_HEADERS);
			if (headers != null) {
				buffer.getHeader().append(headers);
			}
			if (cos.getTempFile() == null) {
				if (cos.size() > getLimit()) {
					buffer.getMessage().append("(message truncated to " + getLimit() + " bytes)\n");
				}
			} else {
				buffer.getMessage().append("Outbound Message (saved to tmp file):\n");
				buffer.getMessage().append("Filename: " + cos.getTempFile().getAbsolutePath() + "\n");
				if (cos.size() > getLimit()) {
					buffer.getMessage().append("(message truncated to " + getLimit() + " bytes)\n");
				}
			}
			try {
				writePayload(buffer.getPayload(), cos, encoding, ct);
			} catch (Exception ex) {
			}
			if (isLogged(this.message.get("java.lang.reflect.Method").toString())) {
				ids.add(id);
				BuseuropeLoggingOutInterceptor.logInfo(transform(buffer.toString()));
			}
			try {
				cos.lockOutputStream();
				cos.resetOut(null, false);
			} catch (Exception ex) {
			}
			this.message.setContent(OutputStream.class, this.origStream);
		}

		private boolean isLogged(String methodName) {
			boolean logged = false;
			for (String name : LOGGED_METHOD_NAMES) {
				if (methodName.contains(name)) {
					logged = true;
					break;
				}
			}
			return logged;
		}

		@Override
		public void onFlush(CachedOutputStream arg0) {

		}

	}

}
