package org.daniels.samples.client;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DanielsWebClientGet {

	private static final Logger logger = Logger.getLogger(DanielsWebClientGet.class);
	
	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/services/api/people/Witzka");

			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

		
			logger.info("Output from Server .... \n");
			logger.info(output);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

}