package sk.marekpecho.orders_service_v2.converters;

import jakarta.persistence.AttributeConverter;
import sk.marekpecho.orders_service_v2.enums.Milk;

public class MilkConverter implements AttributeConverter<Milk, String> {

	@Override
	public String convertToDatabaseColumn(Milk attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getCode();
	}

	@Override
	public Milk convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return Milk.getEnumFromCode(dbData);
	}

}
