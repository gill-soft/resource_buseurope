package com.gillsoft.model;

import java.io.InputStream;
import java.util.concurrent.CopyOnWriteArraySet;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;

public class BuseuropeLoggingInInterceptor extends LoggingInInterceptor {

	private CopyOnWriteArraySet<String> ids;

	public BuseuropeLoggingInInterceptor(CopyOnWriteArraySet<String> ids) {
		this.ids = ids;
	}

	public void handleMessage(Message message) throws Fault {
		logging(message);
	}

	private void logging(Message message) throws Fault {
		if (message.containsKey(LoggingMessage.ID_KEY)) {
			return;
		}
		String id = (String) message.getExchange().get(LoggingMessage.ID_KEY);
		if (id == null) {
			id = LoggingMessage.nextId();
			message.getExchange().put(LoggingMessage.ID_KEY, id);
		}
		message.put(LoggingMessage.ID_KEY, id);
		LoggingMessage buffer = new LoggingMessage("Buseurope Inbound Message\n----------------------------", id);

		Integer responseCode = (Integer) message.get(Message.RESPONSE_CODE);
		if (responseCode != null) {
			buffer.getResponseCode().append(responseCode);
		}
		String encoding = (String) message.get(Message.ENCODING);
		if (encoding != null) {
			buffer.getEncoding().append(encoding);
		}
		String ct = (String) message.get(Message.CONTENT_TYPE);
		if (ct != null) {
			buffer.getContentType().append(ct);
		}
		Object headers = message.get(Message.PROTOCOL_HEADERS);
		if (headers != null) {
			buffer.getHeader().append(headers);
		}
		String uri = (String) message.get(Message.REQUEST_URI);
		if (uri != null) {
			buffer.getAddress().append(uri);
		}

		InputStream is = (InputStream) message.getContent(InputStream.class);
		if (is != null) {
			CachedOutputStream bos = new CachedOutputStream();
			try {
				IOUtils.copy(is, bos);

				bos.flush();
				is.close();

				message.setContent(InputStream.class, bos.getInputStream());
				if (bos.getTempFile() != null) {
					buffer.getMessage().append("\nMessage (saved to tmp file):\n");
					buffer.getMessage().append("Filename: " + bos.getTempFile().getAbsolutePath() + "\n");
				}
				if (bos.size() > getLimit()) {
					buffer.getMessage().append("(message truncated to " + getLimit() + " bytes)\n");
				}
				writePayload(buffer.getPayload(), bos, encoding, ct);

				bos.close();
			} catch (Exception e) {
				throw new Fault(e);
			}
		}
		if (ids.contains(id)) {
			BuseuropeLoggingOutInterceptor.logInfo(transform(buffer.toString()));
		}
	}

}
