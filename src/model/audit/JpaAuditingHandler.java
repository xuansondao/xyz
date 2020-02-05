package model.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.mapping.PersistentProperty;
import org.springframework.data.mapping.context.MappingContext;

public class JpaAuditingHandler extends AuditingHandler {
    public JpaAuditingHandler(MappingContext<? extends PersistentEntity<?, ?>, ? extends PersistentProperty<?>> mappingContext) {
        super(mappingContext);
    }

    @Override
    @Autowired
    public void setAuditorAware(@Qualifier("springSecurityAuditorAware") AuditorAware<?> auditorAware) {
        super.setAuditorAware(auditorAware);
    }

}
