package com.lti.pojogladiator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

public class OTP {
	
	private String otpMessage;

	public String getOtpMessage() {
		return otpMessage;
	}

	public void setOtpMessage(String otpMessage) {
		this.otpMessage = otpMessage;
	}

	
	
	public String generateOTP(int length) {		// Method to generate OTP randomnly

		Random random = new Random();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++) {
			sb.append(random.nextInt(10));
		}

		String otp = sb.toString();

		return otp;
	}
	
	
	public void sendOTP(String message, String number) {		// Method to send OTP with customized message

		try {
			
			String apiKey = "f4KesZW8ioT3L1Agl2XDb97m5IOhyMrFUHRzuSEa6CGVvYPxnQqRaIK3AheuTklUY47scX9rnMdyStOQ";

			String sendId = "FSTSMS";
			String language = "english";
			String route = "p";

			message = URLEncoder.encode(message, "UTF-8");

			String myUrl = "https://www.fast2sms.com/dev/bulk?authorization=" + apiKey + "&sender_id=" + sendId
					+ "&message=" + message + "&language=" + language + "&route=" + route + "&numbers=" + number;

			URL url = new URL(myUrl);

			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			con.setRequestMethod("GET");
			con.addRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("cache-control", "no-cache");

			int responseCode = con.getResponseCode();
			System.out.println("Response code :" + responseCode);

			StringBuffer response = new StringBuffer();

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			while (true) {
				String line = br.readLine();

				if (line == null) {
					break;
				}

				response.append(line);
			}
			System.out.println(response);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}