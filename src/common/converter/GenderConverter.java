package common.converter;

import vn.com.vndirect.brokerinsight.common.type.Gender;

import javax.persistence.AttributeConverter;

public class GenderConverter implements AttributeConverter<Gender, Character> {

    @Override
    public Character convertToDatabaseColumn(Gender attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public Gender convertToEntityAttribute(Character dbData) {
        return dbData == null ? null : Gender.valueOf(dbData);
    }
}
