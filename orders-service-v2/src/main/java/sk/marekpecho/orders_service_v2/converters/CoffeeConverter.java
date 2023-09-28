package sk.marekpecho.orders_service_v2.converters;

import jakarta.persistence.AttributeConverter;
import sk.marekpecho.orders_service_v2.enums.Coffee;

public class CoffeeConverter implements AttributeConverter<Coffee, String> {

	@Override
	public String convertToDatabaseColumn(Coffee attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getCode();
	}

	@Override
	public Coffee convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return Coffee.getEnumFromCode(dbData);
	}

}
