package org.daniels.samples.client;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DanielsWebJerseyClientPut {
	private static final Logger logger = Logger.getLogger(DanielsWebJerseyClientPut.class);
	public static void main(String[] args) {

		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/services/api/people/put");

			String input = 	"{\"id\":3,\"firstName\":\"Daniels\",\"lastName\":\"Horecki1\"}";
			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON) 
					.put(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			logger.info("Output from Server .... \n");
			String output = response.getEntity(String.class);
			logger.info(output);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

}
