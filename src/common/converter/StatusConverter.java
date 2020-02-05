package common.converter;

import vn.com.vndirect.brokerinsight.common.type.Status;

import javax.persistence.AttributeConverter;

public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : Status.valueOf(dbData);
    }
}
