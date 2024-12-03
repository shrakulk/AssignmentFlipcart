package Hallyal;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.List;

public class OTPFetch{
	public static  String getOTP() {
    // Replace with your Twilio SID and Auth Token
    final String ACCOUNT_SID = "ACa8a50dbe590d47fbaa2361887de16155";
    final String AUTH_TOKEN = "1304c1d654f8a45cbf523d0ee374f23d";
    
   
    
   // public static void main(String[] args) {
        // Initialize Twilio
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Fetch messages (OTP messages from Flipkart)
        ResourceSet<Message> messages = Message.reader()
            .setTo(new PhoneNumber("9373689834"))  // Your Twilio phone number
            .read();

        String otp = null;
		// Loop through the messages and extract OTP
        for (Message message : messages) {
            String messageBody = message.getBody();
            otp = extractOTP(messageBody);
            if (otp != null) {
                System.out.println("OTP received: " + otp);
                break;  // Stop once the OTP is found
            }
        }
		return otp;
   }

    // Extract OTP from message using regex (assuming 6-digit OTP)
    private static String extractOTP(String message) {
        // Regex to match a 6-digit OTP
        String otpRegex = "\\b\\d{6}\\b";
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(otpRegex).matcher(message);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
    
}

