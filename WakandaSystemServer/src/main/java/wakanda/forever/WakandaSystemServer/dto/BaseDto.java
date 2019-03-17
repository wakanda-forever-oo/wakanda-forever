package wakanda.forever.WakandaSystemServer.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class BaseDto {

	protected String convertDtoDate(Timestamp date) {
//		System.out.println("Called convertDtoDate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		dateFormat.setTimeZone(TimeZone.getTimeZone("EET"));
		return dateFormat.format(date.getTime());		
	}
}
