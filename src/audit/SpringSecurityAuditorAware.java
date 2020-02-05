package audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import vn.com.vndirect.vndid.auth.UserAuthentication;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    @NotNull
    public Optional<String> getCurrentAuditor() {
        UserAuthentication userAuthentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        if (userAuthentication == null || !userAuthentication.isAuthenticated()) {
            return Optional.of("SADMIN");
        }

        String username = userAuthentication.getUser().getUser().getUserName();
        try {
            return Optional.of(username.split("\\\\")[1]);
        } catch (Exception ignored) {
            return Optional.of(username);
        }
    }

}
