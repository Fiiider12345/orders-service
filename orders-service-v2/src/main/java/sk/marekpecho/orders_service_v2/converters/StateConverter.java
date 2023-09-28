package sk.marekpecho.orders_service_v2.converters;

import jakarta.persistence.AttributeConverter;
import sk.marekpecho.orders_service_v2.enums.State;

public class StateConverter implements AttributeConverter<State, String> {

	@Override
	public String convertToDatabaseColumn(State attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getCode();
	}

	@Override
	public State convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return State.getEnumFromCode(dbData);
	}

}
