package sk.marekpecho.orders_service_v2.converters;

import jakarta.persistence.AttributeConverter;
import sk.marekpecho.orders_service_v2.enums.Takeaway;

public class TakeawayConverter implements AttributeConverter<Takeaway, String> {

	@Override
	public String convertToDatabaseColumn(Takeaway attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getCode();
	}

	@Override
	public Takeaway convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return Takeaway.getEnumFromCode(dbData);
	}

}
