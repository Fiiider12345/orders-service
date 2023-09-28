package sk.marekpecho.orders_service_v2.converters;

import jakarta.persistence.AttributeConverter;
import sk.marekpecho.orders_service_v2.enums.Size;

public class SizeConverter implements AttributeConverter<Size, Character> {

	@Override
	public Character convertToDatabaseColumn(Size attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getCode();
	}

	@Override
	public Size convertToEntityAttribute(Character dbData) {
		if (dbData == null) {
			return null;
		}
		return Size.getEnumFromCode(dbData);
	}

}
